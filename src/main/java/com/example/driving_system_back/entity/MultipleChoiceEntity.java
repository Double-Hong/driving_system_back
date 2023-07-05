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
 * @since 2023-06-19 18:07:31
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("multiple_choice")
@ApiModel(value = "MultipleChoiceEntity对象", description = "")
public class MultipleChoiceEntity {

    @TableId(value = "multiple_choice_id", type = IdType.AUTO)
    private String multipleChoiceId;

    @TableField("multiple_choice_describe")
    private String multipleChoiceDescribe;

    @TableField("option1")
    private String option1;

    @TableField("option2")
    private String option2;

    @TableField("option3")
    private String option3;

    @TableField("option4")
    private String option4;

    @TableField("correct_answer")
    private String correctAnswer;

   @TableField("photo_url")
   private  String photoUrl;
}
