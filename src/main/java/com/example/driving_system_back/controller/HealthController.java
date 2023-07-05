package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.HealthEntity;
import com.example.driving_system_back.entity.StudentEntity;
import com.example.driving_system_back.mapper.HealthMapper;
import com.example.driving_system_back.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@RestController
@RequestMapping("/health-entity")
public class HealthController {
 @Autowired
    HealthMapper healthMapper;
 @Autowired
    StudentMapper studentMapper;

 @ResponseBody
    @GetMapping("setImageUrlByStudentId/{id}/{imageUrl}")
    public HealthEntity setImageUrlByStudentId(@PathVariable String id,@PathVariable String imageUrl){
    String health =  studentMapper.selectOne(Wrappers.<StudentEntity>lambdaQuery().eq(StudentEntity::getStudentId,id)).getHealthId();

    return  healthMapper.selectById(health).setImageUrl(imageUrl);
 }
 @ResponseBody
    @GetMapping("getHealthyDataByStudentId/{Id}")
    public HealthEntity getHealthyDataByStudentId(@PathVariable String Id){

     return healthMapper.selectOne(Wrappers.<HealthEntity>lambdaQuery().eq(HealthEntity::getStudentId,Id));
 }
 @ResponseBody
    @PostMapping ("/updateHealty")
    public  int updateHealty(@RequestBody HealthEntity healthEntity){
     return healthMapper.updateById(healthEntity);

 }
}
