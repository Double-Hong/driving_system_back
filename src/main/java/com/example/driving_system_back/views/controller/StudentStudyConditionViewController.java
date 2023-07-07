package com.example.driving_system_back.views.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.driving_system_back.views.entity.StudentStudyConditionViewEntity;
import com.example.driving_system_back.views.mapper.StudentStudyConditionViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :Double-Hong
 * @name :driving_system_back
 * @date :2023/7/5
 * @time :12:17
 **/
@RestController
@RequestMapping("/student_study_condition_view")
public class StudentStudyConditionViewController {

    @Autowired
    private StudentStudyConditionViewMapper studentStudyConditionViewMapper;

    @GetMapping("/getAll")
    public List<StudentStudyConditionViewEntity> getAll() {
        return studentStudyConditionViewMapper.selectList(null);
    }

    @GetMapping("/getByCoachId/{coachId}")
    public List<StudentStudyConditionViewEntity> getByCoachId(@PathVariable String coachId) {
        return studentStudyConditionViewMapper.selectList(new QueryWrapper<StudentStudyConditionViewEntity>().eq("coach_id", coachId));
    }
}
