package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.StudentConditionEntity;
import com.example.driving_system_back.mapper.StudentConditionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 学生学习情况及考试情况，记录的成绩是最高成绩 前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@RestController
@RequestMapping("/student-condition-entity")
public class StudentConditionController {
 @Autowired
    StudentConditionMapper studentConditionMapper;


 @ResponseBody
 @GetMapping("/getStudentConditionById/{studentId}")
 public StudentConditionEntity getStudentConditionById(@PathVariable String studentId){
     return studentConditionMapper.selectOne(Wrappers.<StudentConditionEntity>lambdaQuery().eq(StudentConditionEntity::getStudentId,studentId));
 }

 @ResponseBody
 @GetMapping("/addObjectOneTimeByStudentId/{studentId}/{time}")
 public int addObjectOneTimeByStudentId(@PathVariable String studentId ,@PathVariable int time){
     StudentConditionEntity studentConditionEntity=studentConditionMapper.selectOne(Wrappers.<StudentConditionEntity>lambdaQuery().eq(StudentConditionEntity::getStudentId,studentId));
     studentConditionEntity.setPracticeTimeOne(studentConditionEntity.getPracticeTimeOne()+time);
        return studentConditionMapper.updateById(studentConditionEntity);

 }
}
