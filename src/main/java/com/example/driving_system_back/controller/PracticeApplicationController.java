package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.PracticeApplicationEntity;
import com.example.driving_system_back.mapper.PracticeApplicationMapper;
import com.example.driving_system_back.service.PracticeApplicationService;
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
public class PracticeApplicationController {

    @Autowired
    PracticeApplicationMapper practiceApplicationMapper;

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
