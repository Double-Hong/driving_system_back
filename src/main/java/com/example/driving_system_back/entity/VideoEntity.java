package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学习视频
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-07-04 20:47:21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("video")
@ApiModel(value = "VideoEntity对象", description = "学习视频")
public class VideoEntity {

    @TableId(value = "video_id", type = IdType.AUTO)
    private String videoId;

    @TableField("school_name")
    private String schoolName;

    @ApiModelProperty("视频名称")
    @TableField("video_name")
    private String videoName;

    @TableField("video_url")
    private String videoUrl;

    @ApiModelProperty("C1 or C2 ?")
    @TableField("video_type")
    private String videoType;


}
