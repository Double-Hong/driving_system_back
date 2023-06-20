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
 * 
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("health")
@ApiModel(value = "HealthEntity对象", description = "")
public class HealthEntity {

    @TableId(value = "health_id", type = IdType.AUTO)
    private String healthId;

    @TableField("allergy_history")
    private String allergyHistory;

    @TableField("surgical_history")
    private String surgicalHistory;

    @TableField("height")
    private Double height;

    @TableField("weight")
    private Double weight;

    @TableField("student_id")
    private String studentId;

    @TableField("image_url")
    private  String imageUrl;

}
