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
@TableName("examination_and_multiple_choice")
@ApiModel(value = "ExaminationAndMultipleChoiceEntity对象", description = "")
public class ExaminationAndMultipleChoiceEntity {

    @TableField("examination_id")
    private String examinationId;

    @TableField("multiple_choice_id")
    private String multipleChoiceId;

    @TableField("answer")
    private String answer;

    @TableField("fraction")
    private int fraction;


}
