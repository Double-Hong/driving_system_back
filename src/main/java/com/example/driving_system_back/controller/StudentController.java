package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.driving_system_back.common.vo.Result;
import com.example.driving_system_back.entity.StudentEntity;
import com.example.driving_system_back.mapper.StudentMapper;
import com.example.driving_system_back.service.StudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    private StudentService studentService;

    @PostMapping("/studentLogin")
    public List<StudentEntity> studentLogin(@RequestBody StudentEntity studentEntity){
        return studentMapper.selectList(new QueryWrapper<StudentEntity>().eq("username",studentEntity.getUsername()).eq("`password`",studentEntity.getPassword()));
    }


    public List<StudentEntity> findStudentByStudentName(String Name){
        return studentMapper.selectList(Wrappers.<StudentEntity>lambdaQuery().like(StudentEntity::getStudentName, Name));
    }

    @GetMapping
    public Result<?> findAllStudent(){
        return Result.success(findStudentByStudentName(""));
    }
    //查找学生
    @PostMapping("/getStudentList/{studentName}")
    public Result<?>getStudentList (@PathVariable String studentName){
        List<StudentEntity> students=findStudentByStudentName(studentName);
        return Result.success(students);
    }


    //修改用户
    @PostMapping
    public Result<?> updateStudent(@RequestBody StudentEntity s){
        if(studentService.updateById(s)){
//            String name="";
//            List<StudentEntity> students=findStudentByStudentName(name);
            return Result.success();
        }
        else{
            return Result.fail();
        }

    }

    //删除用户
    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable Integer id){
        if(studentService.removeById(id)){
            String name="";
            List<StudentEntity> students=findStudentByStudentName(name);
            return Result.success(students);
        }
        else{
            return Result.fail();
        }

    }

    //新增用户
    @PostMapping("/addStudent")
    public Result<?> insertStudent(@RequestBody StudentEntity student){
        String s = UUID.randomUUID().toString();
        student.setStudentId(s);
        student.setPassword("123456");
        studentService.save(student);
        return Result.success();
    }

    //通过id查找
    @GetMapping("/findById/{id}")
    public Result<?> findStudentById(@PathVariable String id){
        StudentEntity student= studentService.getById(id);
        return Result.success(student);
    }
}
