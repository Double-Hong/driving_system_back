package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.ExaminationAndMultipleChoiceEntity;
import com.example.driving_system_back.entity.MultipleChoiceEntity;
import com.example.driving_system_back.mapper.ExaminationAndMultipleChoiceMapper;
import com.example.driving_system_back.mapper.MultipleChoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-19 18:07:31
 */
@RestController
@RequestMapping("/examination-and-multiple-choice-entity")
public class ExaminationAndMultipleChoiceController {
    @Autowired
    ExaminationAndMultipleChoiceMapper examinationAndMultipleChoiceMapper;
    @Autowired
    MultipleChoiceMapper multipleChoiceMapper;

    @GetMapping("getAllMultipleById/{eid}")//根据eid得到所有的选择题
    public List<MultipleChoiceEntity> getAllMultipleById(@PathVariable String eid) {
        List<ExaminationAndMultipleChoiceEntity> info = examinationAndMultipleChoiceMapper.selectList(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId, eid));
        List<MultipleChoiceEntity> result = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            result.add(i, multipleChoiceMapper.selectById(info.get(i).getMultipleChoiceId()));
        }
        return result;
    }

    @GetMapping("getFractionById/{eid},{bid}")
    public int getFractionById(@PathVariable String eid, @PathVariable String bid) {
        return examinationAndMultipleChoiceMapper.selectOne(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId, eid).eq(ExaminationAndMultipleChoiceEntity::getMultipleChoiceId, bid)).getFraction();

    }

    @GetMapping("getAllchoiceInfoByEid/{eid}")
    public List<ExaminationAndMultipleChoiceEntity> getAllchoiceInfoByEid(@PathVariable String eid) {
        return examinationAndMultipleChoiceMapper.selectList(new QueryWrapper<ExaminationAndMultipleChoiceEntity>().eq("examination_id", eid));
    }

    @GetMapping("/deleteChoiceAndExamShip/{examId},{choiceId}")//删除考试中的一个选择题题目
    public int deleteChoiceAndExamShip(@PathVariable String choiceId, @PathVariable String examId) {
        return examinationAndMultipleChoiceMapper.delete(new QueryWrapper<ExaminationAndMultipleChoiceEntity>().eq("examination_id", examId).eq("multiple_choice_id", choiceId));
    }

    @GetMapping("/modifyFractionInOneExam/{examId},{choiceId},{fraction}")//修改考试中一个题目的分值
    public int modifyFractionInOneExam(@PathVariable String choiceId, @PathVariable String examId, @PathVariable int fraction) {
        ExaminationAndMultipleChoiceEntity examinationAndMultipleChoiceEntity = examinationAndMultipleChoiceMapper.selectOne(new QueryWrapper<ExaminationAndMultipleChoiceEntity>().eq("examination_id", examId)
                .eq("multiple_choice_id", choiceId));
        examinationAndMultipleChoiceEntity.setFraction(fraction);
        return examinationAndMultipleChoiceMapper.update(examinationAndMultipleChoiceEntity, new QueryWrapper<ExaminationAndMultipleChoiceEntity>().eq("examination_id", examId)
                .eq("multiple_choice_id", choiceId));
    }

    @PostMapping("/addOneChoice")//添加一个考试中的题目
    public int addOneChoice(@RequestBody ExaminationAndMultipleChoiceEntity examinationAndMultipleChoiceEntity) {
        return examinationAndMultipleChoiceMapper.insert(examinationAndMultipleChoiceEntity);
    }
}
