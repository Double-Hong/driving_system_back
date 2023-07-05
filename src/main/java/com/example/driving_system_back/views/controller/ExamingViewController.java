package com.example.driving_system_back.views.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.driving_system_back.views.entity.ExaminationStudentViewEntity;
import com.example.driving_system_back.views.entity.ExamingViewEntity;
import com.example.driving_system_back.views.mapper.ExaminationStudentViewMapper;
import com.example.driving_system_back.views.mapper.ExamingViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examing-view")
public class ExamingViewController {

    @Autowired
    ExamingViewMapper examingViewMapper;


    //得到某场考试的所有题目
    @GetMapping("/getExamingViewByExaminationId/{examinationId}")
    public List<ExamingViewEntity> getExamingViewByExaminationId(@PathVariable String examinationId) {
        return examingViewMapper.selectList(new QueryWrapper<ExamingViewEntity>().eq("examination_id", examinationId));
    }



}
