package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.ExamRecordsEntity;
import com.example.driving_system_back.entity.ExaminationEntity;
import com.example.driving_system_back.entity.StudentConditionEntity;
import com.example.driving_system_back.mapper.ExamRecordsMapper;
import com.example.driving_system_back.mapper.ExaminationMapper;
import com.example.driving_system_back.mapper.StudentConditionMapper;
import com.example.driving_system_back.service.impl.ExamRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    @Autowired
    private StudentConditionMapper studentConditionMapper;

    @Autowired
    private ExaminationMapper examinationMapper;

    //获取当场考试的考试记录
    @GetMapping("/getExamRecords/{examinationId}")
    public List<ExamRecordsEntity> getExamRecords(@PathVariable String examinationId) {
        return examRecordsMapper.selectList(new QueryWrapper<ExamRecordsEntity>().eq("examination_id", examinationId));
    }

    @ResponseBody
    @GetMapping("/getExamRecordByStudentId/{studentId}")
    public List<ExamRecordsEntity> getExamRecordByStudentId(@PathVariable String studentId) {
        return examRecordsMapper.selectList(Wrappers.<ExamRecordsEntity>lambdaQuery().eq(ExamRecordsEntity::getStudentId, studentId));
    }

    @ResponseBody
    @GetMapping("getAllExamRecords")
    public List<ExamRecordsEntity> getAllExamRecords() {
        return examRecordsMapper.selectList(null);
    }


    @ResponseBody
    @PostMapping("/addExamRecord")
    public int addExamRecord(@RequestBody ExamRecordsEntity examRecordsEntity) {
        if (examRecordsMapper.selectOne(Wrappers.<ExamRecordsEntity>lambdaQuery().eq(ExamRecordsEntity::getStudentId, examRecordsEntity.getStudentId()).eq(ExamRecordsEntity::getExaminationId, examRecordsEntity.getExaminationId())) != null) {
            return 0;
        }

        UUID uuid = UUID.randomUUID();
        examRecordsEntity.setExamRecordsId(uuid.toString());
        return examRecordsMapper.insert(examRecordsEntity);

    }

    @ResponseBody
    @GetMapping("/setExamScore/{examinationId}/{studentId}/{examScore}")
    public int setexamScore(@PathVariable String examinationId, @PathVariable String studentId, @PathVariable double examScore) {

        String objectType = examinationMapper.selectOne(Wrappers.<ExaminationEntity>lambdaQuery().eq(ExaminationEntity::getExaminationId, examinationId)).getExaminationSubject();
        ExamRecordsEntity examRecordsEntity = examRecordsMapper.selectOne(Wrappers.<ExamRecordsEntity>lambdaQuery().eq(ExamRecordsEntity::getExaminationId, examinationId).eq(ExamRecordsEntity::getStudentId, studentId));
        StudentConditionEntity studentConditionEntity = studentConditionMapper.selectOne(Wrappers.<StudentConditionEntity>lambdaQuery().eq(StudentConditionEntity::getStudentId, studentId));
        examRecordsEntity.setScore(examScore);
        if (objectType.equals("科目一")) {
            if (examRecordsEntity.getScore() >= studentConditionEntity.getSubjectOne()) {
                studentConditionEntity.setSubjectOne((int) Math.round(examRecordsEntity.getScore()));
                studentConditionMapper.updateById(studentConditionEntity);
            }
        } else if (objectType.equals("科目四")) {
            if (examRecordsEntity.getScore() >= studentConditionEntity.getSubjectFour()) {
                studentConditionEntity.setSubjectFour((int) Math.round(examRecordsEntity.getScore()));
                studentConditionMapper.updateById(studentConditionEntity);
            }
        }

        return examRecordsMapper.updateById(examRecordsEntity);
    }

    @GetMapping("/inputExamScore/{examScore}/{examRecordsId}")
    public int inputExamScore(@PathVariable String examRecordsId, @PathVariable float examScore){
        ExamRecordsEntity examRecordsEntity = examRecordsMapper.selectOne(Wrappers.<ExamRecordsEntity>lambdaQuery().eq(ExamRecordsEntity::getExamRecordsId, examRecordsId));
        examRecordsEntity.setScore(examScore);
        return examRecordsMapper.updateById(examRecordsEntity);
    }
}
