package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.driving_system_back.entity.PracticeApplicationEntity;
import com.example.driving_system_back.entity.Result;
import com.example.driving_system_back.entity.StudentConditionEntity;
import com.example.driving_system_back.entity.StudentConditionViewEntity;
import com.example.driving_system_back.mapper.PracticeApplicationMapper;
import com.example.driving_system_back.mapper.StudentConditionMapper;
import com.example.driving_system_back.mapper.StudentConditionViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 考试记录 前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@RestController
@RequestMapping("/student-condition-view")
public class StudentConditionViewController {
    @Autowired
    private StudentConditionViewMapper studentConditionViewMapper;

    @Autowired
    private StudentConditionMapper studentConditionMapper;


    @Autowired
    private PracticeApplicationMapper   practiceApplicationMapper;

    //获取所有学生信息
    @PostMapping("/getAllCondition")
    public Result<?> getAllCondition(){
        LambdaQueryWrapper<StudentConditionViewEntity> query = new LambdaQueryWrapper<StudentConditionViewEntity>();
        query.like(StudentConditionViewEntity::getStudentName,"");
        List<StudentConditionViewEntity> studentConditionViewEntityList = studentConditionViewMapper.selectList(query);
        return Result.success(studentConditionViewEntityList);
    }

    //按名字查找学生信息
    @PostMapping("/student_condition/{studentName}")
    public Result<?> getAllStudentCondition(@PathVariable String studentName){
        System.out.println(studentName+"1231312");
        LambdaQueryWrapper<StudentConditionViewEntity> queryWrapper=new LambdaQueryWrapper<StudentConditionViewEntity>();
        queryWrapper.like(StudentConditionViewEntity::getStudentName,studentName);
        List<StudentConditionViewEntity> studentConditionViewEntityList=studentConditionViewMapper.selectList(queryWrapper);
        return Result.success(studentConditionViewEntityList);
    }

    //通过id查询学生信息
    @GetMapping("/findStudentBuId/{studentId}")
    public Result<?> findStudentById(@PathVariable String studentId){
        LambdaQueryWrapper<StudentConditionViewEntity> queryWrapper=new LambdaQueryWrapper<StudentConditionViewEntity>();
        queryWrapper.eq(StudentConditionViewEntity::getStudentId, studentId);
        StudentConditionViewEntity studentConditionViewEntity = studentConditionViewMapper.selectById(queryWrapper);
        return Result.success(studentConditionViewEntity);
    }


    //修改学生信息
    @PostMapping("/updateStudentCondition")
    public Result<?> updateStudentCondition(@RequestBody StudentConditionViewEntity entity){
        //修改student Condition里的数据
        LambdaQueryWrapper<StudentConditionEntity> queryWrapper=new LambdaQueryWrapper<StudentConditionEntity>();
        queryWrapper.eq(StudentConditionEntity::getStudentId, entity.getStudentId());
        StudentConditionEntity studentConditionEntity = studentConditionMapper.selectById(entity.getConditionId());
        studentConditionEntity.setPracticeTimeTwo(entity.getPracticeTimeTwo());
        studentConditionEntity.setPracticeTimeThree(entity.getPracticeTimeThree());
        //修改practiceApplicaiotion的数据
        LambdaQueryWrapper<PracticeApplicationEntity> practiceApplicationEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        System.out.println(entity.getStudentId());
        practiceApplicationEntityLambdaQueryWrapper.eq(PracticeApplicationEntity::getPracticeId,entity.getPracticeId());
        PracticeApplicationEntity practiceApplication = practiceApplicationMapper.selectOne(practiceApplicationEntityLambdaQueryWrapper);
        practiceApplication.setApplicationState(entity.getApplicationState());
        practiceApplicationMapper.updateById(practiceApplication);
        if(studentConditionMapper.updateById(studentConditionEntity)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }

}
