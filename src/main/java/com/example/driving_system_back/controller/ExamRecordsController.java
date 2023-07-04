package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.driving_system_back.entity.ExamRecordsEntity;
import com.example.driving_system_back.mapper.ExamRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/exam-records-entity")
public class ExamRecordsController {

    @Autowired
    public ExamRecordsMapper examRecordsMapper;

    //获取当场考试的考试记录
    @GetMapping("/getExamRecords/{examinationId}")
    public List<ExamRecordsEntity> getExamRecords(@PathVariable String examinationId){
        return examRecordsMapper.selectList(new QueryWrapper<ExamRecordsEntity>().eq("examination_id",examinationId));
    }
}
