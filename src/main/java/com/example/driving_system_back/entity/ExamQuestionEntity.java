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
@TableName("exam_question")
@ApiModel(value = "ExamQuestionEntity对象", description = "")
public class ExamQuestionEntity {

    @TableId(value = "question_id", type = IdType.AUTO)
    private String questionId;

    @TableField("title")
    private String title;

    @TableField("`rank`")
    private Integer rank;

    @TableField("`type`")
    private Integer type;

    @TableField("op1")
    private String op1;

    @TableField("op2")
    private String op2;

    @TableField("op3")
    private String op3;

    @TableField("op4")
    private String op4;

    @TableField("tittleType")
    private String tittleType;


}
