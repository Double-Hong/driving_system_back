package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.Result;
import com.example.driving_system_back.entity.StudentEntity;
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

    @PostMapping("/studentLogin")
    public List<StudentEntity> studentLogin(@RequestBody StudentEntity studentEntity){
        return studentMapper.selectList(new QueryWrapper<StudentEntity>().eq("username",studentEntity.getUsername()).eq("`password`",studentEntity.getPassword()));
    }

    public List<StudentEntity> findStudentByStudentName(String Name){
        return studentMapper.selectList(Wrappers.<StudentEntity>lambdaQuery().eq(StudentEntity::getStudentName, Name));
    }

    //查找学生
    @PostMapping("/getStudentList/{studentName}")
    public Result<?> getStudentList (@PathVariable String studentName){
        List<StudentEntity> students=findStudentByStudentName(studentName);
        return Result.success(students);
    }


}
