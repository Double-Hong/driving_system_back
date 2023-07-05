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
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-19 18:07:31
 */
@RestController
@RequestMapping("/multiple-choice-entity")
public class MultipleChoiceController {
    @Autowired
    MultipleChoiceMapper multipleChoiceMapper;

    @Autowired
    ExaminationAndMultipleChoiceMapper examinationAndMultipleChoiceMapper;

    @GetMapping("/getAllChoiceInfo")//获取全部选择题
    public List<MultipleChoiceEntity> getAllChoiceInfo() {
        return multipleChoiceMapper.selectList(null);
    }

    @GetMapping("/getChoiceInfoByExamId/{examId}")//根据考试ID获得除已选的选择题外的选择题(添加选择题时展示)
    public List<MultipleChoiceEntity> getChoiceInfoByExamId(@PathVariable String examId) {
        List<MultipleChoiceEntity> allMultipleChoiceEntity = multipleChoiceMapper.selectList(null);
        List<ExaminationAndMultipleChoiceEntity> info = examinationAndMultipleChoiceMapper.selectList(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId, examId));
        List<MultipleChoiceEntity> hadMultipleChoiceEntity = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            hadMultipleChoiceEntity.add(i, multipleChoiceMapper.selectById(info.get(i).getMultipleChoiceId()));
        }
        for (int i = 0; i < hadMultipleChoiceEntity.size(); i++) {
            for (int j = 0; j < allMultipleChoiceEntity.size(); j++) {
                if (Objects.equals(hadMultipleChoiceEntity.get(i).getMultipleChoiceId(), allMultipleChoiceEntity.get(j).getMultipleChoiceId())) {
                    allMultipleChoiceEntity.remove(allMultipleChoiceEntity.get(j));
                }
            }
        }
        return allMultipleChoiceEntity;
    }

    //搜索选择题
    @GetMapping("/findChoice/{search},{examId}")
    public List<MultipleChoiceEntity> findChoice(@PathVariable String search, @PathVariable String examId) {
        List<MultipleChoiceEntity> allMultipleChoiceEntity = multipleChoiceMapper.selectList(new QueryWrapper<MultipleChoiceEntity>().like("multiple_choice_describe", search)
                .or().like("option1", search).or().like("option2", search).or().like("option3", search)
                .or().like("option4", search));
        List<ExaminationAndMultipleChoiceEntity> info = examinationAndMultipleChoiceMapper.selectList(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId, examId));
        List<MultipleChoiceEntity> hadMultipleChoiceEntity = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            hadMultipleChoiceEntity.add(i, multipleChoiceMapper.selectById(info.get(i).getMultipleChoiceId()));
        }
        for (int i = 0; i < hadMultipleChoiceEntity.size(); i++) {
            for (int j = 0; j < allMultipleChoiceEntity.size(); j++) {
                if (Objects.equals(hadMultipleChoiceEntity.get(i).getMultipleChoiceId(), allMultipleChoiceEntity.get(j).getMultipleChoiceId())) {
                    allMultipleChoiceEntity.remove(allMultipleChoiceEntity.get(j));
                }
            }
        }
        return allMultipleChoiceEntity;
    }

    @PostMapping("/editChoiceById")//修改选择题信息并返回新数据
    public List<MultipleChoiceEntity> editChoiceById(@RequestBody MultipleChoiceEntity multipleChoiceEntity) {
        multipleChoiceMapper.updateById(multipleChoiceEntity);
        return multipleChoiceMapper.selectList(null);
    }

    @GetMapping("/deleteChoiceById/{choiceId}")//删除选择题信息并返回新数据
    public List<MultipleChoiceEntity> deleteChoiceById(@PathVariable String choiceId) {
        multipleChoiceMapper.deleteById(choiceId);
        return multipleChoiceMapper.selectList(null);
    }

    @PostMapping("/addChoice")//新增选择题并返回新数据
    public List<MultipleChoiceEntity> addChoice(@RequestBody MultipleChoiceEntity multipleChoiceEntity) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        multipleChoiceEntity.setMultipleChoiceId(id);
        multipleChoiceMapper.insert(multipleChoiceEntity);
        return multipleChoiceMapper.selectList(null);
    }

    @GetMapping("/findChoiceAll/{search}")
    public List<MultipleChoiceEntity> findChoiceAll(@PathVariable String search) {
        return multipleChoiceMapper.selectList(new QueryWrapper<MultipleChoiceEntity>().like("multiple_choice_describe", search)
                .or().like("option1", search).or().like("option2", search).or().like("option3", search)
                .or().like("option4", search));
    }

    //随机选择选择题
    public static boolean isRepeat(int[] arr,int num){   //repeat  :重复
        for (int j : arr){   //使用增强for循环把数组所有的元素返回，赋值给i
            if (j == num){  //判断i和生成的随机数是否相等
                return true;
            }
        }
        return false;
    }
   @ResponseBody
    @GetMapping("/randomChoice/{num}")
    public List<MultipleChoiceEntity> randomChoice(@PathVariable int num) {
        List<MultipleChoiceEntity> allMultipleChoiceEntity = multipleChoiceMapper.selectList(null);
        List<MultipleChoiceEntity> randomMultipleChoiceEntity = new ArrayList<>();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            int random = (int) (Math.random() * allMultipleChoiceEntity.size());
            if (isRepeat(arr, random)) {
                i--;
            } else {
                arr[i] = random;
                randomMultipleChoiceEntity.add(allMultipleChoiceEntity.get(random));
            }
        }
        return randomMultipleChoiceEntity;
    }
}
