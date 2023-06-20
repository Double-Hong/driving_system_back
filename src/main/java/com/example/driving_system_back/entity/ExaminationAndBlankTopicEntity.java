package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2023-06-19 18:07:31
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("examination_and_blank_topic")
@ApiModel(value = "ExaminationAndBlankTopicEntity对象", description = "")
public class ExaminationAndBlankTopicEntity {

    @TableField("examination_id")
    private String examinationId;

    @TableField("blank_topic_id")
    private String blankTopicId;

    @TableField("answer")
    private String answer;

    @TableField("fraction")
    private String fraction;


}
