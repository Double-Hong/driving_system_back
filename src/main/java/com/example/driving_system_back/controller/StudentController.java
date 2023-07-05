package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;


import com.example.driving_system_back.entity.HealthEntity;
import com.example.driving_system_back.entity.Result;
import com.example.driving_system_back.entity.StudentConditionEntity;
import com.example.driving_system_back.entity.StudentEntity;
import com.example.driving_system_back.mapper.HealthMapper;
import com.example.driving_system_back.mapper.StudentConditionMapper;
import com.example.driving_system_back.mapper.StudentMapper;
import com.example.driving_system_back.service.StudentService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    HealthMapper healthMapper;
    @Autowired
    StudentConditionMapper studentConditionMapper;
    @Autowired
    StudentService studentService;
    @PostMapping("/studentLogin")
    public List<StudentEntity> studentLogin(@RequestBody StudentEntity studentEntity){
        return studentMapper.selectList(new QueryWrapper<StudentEntity>().eq("username",studentEntity.getUsername()).eq("`password`",studentEntity.getPassword()));
    }
    @ResponseBody
    @GetMapping("/studentDelete/{id}")
    public int studentDelete(@PathVariable String id){
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


    public List<StudentEntity> findStudentByStudentName(String Name){
        return studentMapper.selectList(new QueryWrapper<StudentEntity>().like("student_name",Name));
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
    @PostMapping("/updateStudent")
    public Result<?> updateStudent(@RequestBody StudentEntity s){
        if(studentMapper.updateById(s)!=0){
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
        studentMapper.insert(student);
        return Result.success();
    }

    //通过id查找
    @GetMapping("/findById/{id}")
    public Result<?> findStudentById(@PathVariable Integer id){
        StudentEntity student= studentMapper.selectById(id);
        System.out.println(student);
        return Result.success(student);
    }

    /**
     * 注册学生
     * @param studentEntity 学生实体
     * @return 注册消息
     */
    @PostMapping("/registerStudent")
    public String registerStudent(@RequestBody StudentEntity studentEntity){
        System.out.println(studentEntity);
        List<StudentEntity> list = studentMapper.selectList(Wrappers.<StudentEntity>lambdaQuery().eq(StudentEntity::getUsername,studentEntity.getUsername()));
        if(list.size()!=0){
            return "用户名已存在";
        }
        String s = UUID.randomUUID().toString();
        studentEntity.setStudentId(s);
        studentEntity.setPassword("123456");
        studentEntity.setSchoolName("重庆交通驾校");
        studentEntity.setCoachId(null);
        studentEntity.setHealthId(null);
        studentMapper.insert(studentEntity);
        HealthEntity healthEntity = new HealthEntity();
        healthEntity.setStudentId(s);
        healthEntity.setHealthId(UUID.randomUUID().toString());
        healthMapper.insert(healthEntity);
        studentEntity.setHealthId(healthEntity.getHealthId());
        StudentConditionEntity studentConditionEntity = new StudentConditionEntity();
        studentConditionEntity.setStudentId(s);
        studentConditionEntity.setConditionId(UUID.randomUUID().toString());
        studentConditionMapper.insert(studentConditionEntity);
        studentMapper.updateById(studentEntity);
        return "注册成功";
    }

}
