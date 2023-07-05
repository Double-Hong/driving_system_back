package com.example.driving_system_back.views.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.driving_system_back.views.entity.ExaminationStudentViewEntity;
import com.example.driving_system_back.views.mapper.ExaminationStudentViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :Double-Hong
 * @name :driving_system_back
 * @date :2023/7/2
 * @time :17:37
 **/
@RestController
@RequestMapping("/examination-student-view")
public class ExaminationStudentViewController {

    @Autowired
    private ExaminationStudentViewMapper examinationStudentViewMapper;

    @GetMapping("/getAll")
    public List<ExaminationStudentViewEntity> getAll() {
        return examinationStudentViewMapper.selectList(null);
    }

    @GetMapping("/getByExamId/{examId}")
    public List<ExaminationStudentViewEntity> getByExamId(@PathVariable  String examId) {
        return examinationStudentViewMapper.selectList(new QueryWrapper<ExaminationStudentViewEntity>().eq("examination_id", examId));
    }
    @GetMapping("/getByStudentId/{studentId}")
    public List<ExaminationStudentViewEntity> getByStudentId(@PathVariable  String studentId) {
        return examinationStudentViewMapper.selectList(new QueryWrapper<ExaminationStudentViewEntity>().eq("student_id", studentId));
    }
}
