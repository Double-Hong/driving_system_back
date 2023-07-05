package com.example.driving_system_back.views.controller;

import com.example.driving_system_back.views.entity.StudentStudyConditionViewEntity;
import com.example.driving_system_back.views.mapper.StudentStudyConditionViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
