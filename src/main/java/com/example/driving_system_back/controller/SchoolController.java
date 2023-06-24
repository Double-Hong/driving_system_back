package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.SchoolEntity;
import com.example.driving_system_back.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@RestController
@RequestMapping("/school-entity")
public class SchoolController {
       @Autowired
    SchoolMapper schoolMapper;
       @PostMapping("/getAllSchoolName")
    public List<String> getAllSchoolName(){
           return schoolMapper.selectList(null).stream().map(SchoolEntity::getSchoolName).collect(Collectors.toList());
       }
}
