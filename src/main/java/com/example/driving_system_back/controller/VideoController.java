package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.driving_system_back.entity.VideoEntity;
import com.example.driving_system_back.mapper.VideoMapper;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 学习视频 前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-07-03 23:40:34
 */
@RestController
@RequestMapping("/video-entity")
public class VideoController {

    @Autowired
    VideoMapper videoMapper;

    /**
     * 通过学校名字得到视频
     *
     * @param name 学校名字
     * @return 视频列表
     */
    @GetMapping("/getVideoBySchoolName/{name}")
    public List<VideoEntity> getVideoBySchoolName(@PathVariable String name) {
        return videoMapper.selectList(new QueryWrapper<VideoEntity>().eq("school_name", name));
    }


    /**
     * 通过视频id得到视频并返回更新后的实体列表
     * @param videoEntity 视频实体
     * @return 视频列表
     */
    @PostMapping("/addVideo")
    public List<VideoEntity> addVideo(@RequestBody VideoEntity videoEntity) {
        UUID uuid = UUID.randomUUID();
        videoEntity.setVideoId(uuid.toString());
        videoMapper.insert(videoEntity);
        return videoMapper.selectList(new QueryWrapper<VideoEntity>().eq("school_name", videoEntity.getSchoolName()));
    }

}
