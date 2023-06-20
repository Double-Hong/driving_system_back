package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.CoachEntity;
import com.example.driving_system_back.mapper.CoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@RestController
@RequestMapping("/coach-entity")
public class CoachController {
      @Autowired
    CoachMapper coachMapper;
      /*
      通过教练id得到教练信息
       */
      @GetMapping("getCoachById/{id}")
    public CoachEntity getCoachById (@PathVariable String id){

          return coachMapper.selectById(id);
      }
      @GetMapping("getAllCoachBySchoolName/{schoolName}")
    public List<CoachEntity> getAllCoach(@PathVariable String schoolName){
          return  coachMapper.selectList(Wrappers.<CoachEntity>lambdaQuery().eq(CoachEntity::getSchoolName,schoolName));
      }

}
