package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @PostMapping("/coachLogin")
    public List<CoachEntity> coachLogin(@RequestBody CoachEntity coachEntity){
        return coachMapper.selectList(new QueryWrapper<CoachEntity>().eq("username",coachEntity.getUsername()).eq("`password`",coachEntity.getPassword()));
    }

    @GetMapping("/getCoach/{id}")
    public CoachEntity getCoach(@PathVariable String id){
        return coachMapper.selectById(id);
    }

}
