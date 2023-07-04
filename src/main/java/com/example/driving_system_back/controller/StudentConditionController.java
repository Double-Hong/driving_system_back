package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.driving_system_back.entity.CoachStudentListEntity;
import com.example.driving_system_back.entity.Result;
import com.example.driving_system_back.entity.StudentConditionEntity;
import com.example.driving_system_back.mapper.StudentConditionMapper;
import com.example.driving_system_back.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private StudentConditionMapper studentMapper;

    @GetMapping("/getAll/{studentName}")
    public Result<?> getAllCondition(@PathVariable String studentName) {
        LambdaQueryWrapper<StudentConditionEntity> query = new LambdaQueryWrapper<StudentConditionEntity>();
        query.like(StudentConditionEntity::getStudentId,studentName);
        List<StudentConditionEntity> students = studentMapper.selectList(query);
        return Result.success(students);
    }

    @PostMapping("/updateTime")
    public Result<?> updateTime(@RequestBody StudentConditionEntity studentCondition){
        LambdaQueryWrapper<StudentConditionEntity> query = new LambdaQueryWrapper<StudentConditionEntity>();
        query.eq(StudentConditionEntity::getConditionId,studentCondition.getConditionId());
        StudentConditionEntity stuCondition = studentMapper.selectById(query);
        stuCondition.setPracticeTimeTwo(studentCondition.getPracticeTimeTwo()+studentCondition.getPracticeTimeTwo());
        if(studentMapper.updateById(stuCondition)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }
}
