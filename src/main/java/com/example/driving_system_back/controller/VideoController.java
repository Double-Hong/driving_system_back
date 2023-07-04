package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.driving_system_back.entity.VideoEntity;
import com.example.driving_system_back.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 学习视频 前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-07-04 20:47:21
 */
@RestController
@RequestMapping("/video-entity")
public class VideoController {

    @Autowired
    VideoMapper videoMapper;

    @ResponseBody
    @GetMapping("/getAllVideoInfoByStudyType/{studyType}")//获取视频
    public List<VideoEntity> getAllVideoInfoByStudyType(@PathVariable String studyType){

        return videoMapper.selectList(Wrappers.<VideoEntity>lambdaQuery().eq(VideoEntity::getVideoType,studyType));
    }

}
