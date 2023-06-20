package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.HealthEntity;
import com.example.driving_system_back.entity.StudentEntity;
import com.example.driving_system_back.mapper.HealthMapper;
import com.example.driving_system_back.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@RestController
@RequestMapping("/student-entity")
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    HealthMapper healthMapper;
    @PostMapping("/studentLogin")
    public List<StudentEntity> studentLogin(@RequestBody StudentEntity studentEntity){
        return studentMapper.selectList(new QueryWrapper<StudentEntity>().eq("username",studentEntity.getUsername()).eq("`password`",studentEntity.getPassword()));
    }
    @ResponseBody
    @GetMapping("/studentDelete/{id}")
    public int studentDelete(@PathVariable int id){
        return studentMapper.deleteById(id);
    }

    @ResponseBody
    @GetMapping("/selectStudentIdByUserName/{username}")//通过username找到学员id
    public String selectStudentIdByUserName(@PathVariable  String username){
        return studentMapper.selectOne(Wrappers.<StudentEntity>lambdaQuery().eq(StudentEntity::getUsername,username)).getStudentId();
    }
    @ResponseBody
    @GetMapping("/selectStudentById/{id}")//查找学员信息通过id
    public StudentEntity selectStudentById(@PathVariable  String id){
        return studentMapper.selectById(id);
    }
//    @ResponseBody
//    @PostMapping("insertStudent")//添加学生信息
//    public int insertStudent(@RequestBody StudentEntity studentEntity){
//        return studentMapper.insert(studentEntity);
//    }
    @ResponseBody
    @PostMapping("updateStudentById")//输入学生全部信息修改学生信息
    public int updateStudentById(@RequestBody StudentEntity studentEntity){
        return studentMapper.updateById(studentEntity);
    }

    @ResponseBody
    @GetMapping("getImageUrlByStudentId/{id}")
    public String getImageUrlByStudentId(@PathVariable String id){
        String healthyId;
        healthyId=studentMapper.selectOne(Wrappers.<StudentEntity>lambdaQuery().eq(StudentEntity::getStudentId,id)).getHealthId();
        return healthMapper.selectById(healthyId).getImageUrl();

    }
}
