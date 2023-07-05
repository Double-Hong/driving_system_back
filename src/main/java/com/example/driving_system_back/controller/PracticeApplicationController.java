package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.PracticeApplicationEntity;
import com.example.driving_system_back.entity.Result;
import com.example.driving_system_back.entity.CoachStudentListEntity;
import com.example.driving_system_back.mapper.CoachStudentListMapper;
import com.example.driving_system_back.mapper.PracticeApplicationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 练车申请 前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@RestController
@RequestMapping("/practice-application-entity")
@Slf4j
public class PracticeApplicationController {

    @Autowired
    private CoachStudentListMapper coachStudentListMapper;
    @Autowired
    private PracticeApplicationMapper practiceApplicationMapper;

    @GetMapping("/student/{studentId}")
    public Result<?> getApplicationById(@PathVariable String studentId){
        List<CoachStudentListEntity> students = (List<CoachStudentListEntity>) coachStudentListMapper.selectById(studentId);
        return Result.success(students);
    }
    @GetMapping
    public Result<?> getAllApplication(){
        LambdaQueryWrapper<CoachStudentListEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(CoachStudentListEntity::getStudentName,"");
        List<CoachStudentListEntity> students = coachStudentListMapper.selectList(queryWrapper);
        //log.info("查询的学生信息："+students);
        return Result.success(students);
    }
    @PostMapping("/saveApplication")
    public Result<?> saveApplication(@RequestBody CoachStudentListEntity coachStudentListEntity){
        coachStudentListMapper.updateById(coachStudentListEntity);
        return Result.success();
    }
    @PostMapping("/updateApplication")
    public Result<?> updateApplication(@RequestBody CoachStudentListEntity coachStudent){
        System.out.println("123412412");
        System.out.println(coachStudent.getPracticeId());
        PracticeApplicationEntity practiceApplication= practiceApplicationMapper.selectById(coachStudent.getPracticeId());
        System.out.println(practiceApplication.getPracticeId());
        practiceApplication.setApplicationState(coachStudent.getApplicationState());
        System.out.println(practiceApplication);
        if(practiceApplicationMapper.updateById(practiceApplication)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }

    }
    @ResponseBody
    @GetMapping("/getPracticeApplicationByStudentId/{studentId}/{practiceType}")
    public List<PracticeApplicationEntity> getPracticeApplicationByStudentId(@PathVariable  String studentId,@PathVariable String practiceType){
        return practiceApplicationMapper.selectList(Wrappers.<PracticeApplicationEntity>lambdaQuery().eq(PracticeApplicationEntity::getStudentId,studentId).eq(PracticeApplicationEntity::getPracticeType,practiceType));
    }
    @ResponseBody
    @PostMapping("/insertPracticeApplication")
    public int insertPracticeApplication(@RequestBody PracticeApplicationEntity practiceApplicationEntity){
        UUID uuid = UUID.randomUUID();
        practiceApplicationEntity.setPracticeId(uuid.toString());
        return practiceApplicationMapper.insert(practiceApplicationEntity);
    }
    @ResponseBody
    @PostMapping("/updatePracticeApplication")
    public int updatePracticeApplication(@RequestBody PracticeApplicationEntity practiceApplicationEntity){
        return practiceApplicationMapper.updateById(practiceApplicationEntity);
    }

    @ResponseBody
    @GetMapping("deletedById/{id}")
    public int deletedById(@PathVariable String id){
        return practiceApplicationMapper.deleteById(id);
    }


}
