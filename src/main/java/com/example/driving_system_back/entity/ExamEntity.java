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
@TableName("exam")
@ApiModel(value = "ExamEntity对象", description = "")
public class ExamEntity {

    @TableId(value = "exam_id", type = IdType.AUTO)
    private String examId;

    @TableField("subject_one")
    private Integer subjectOne;

    @TableField("subject_two")
    private Integer subjectTwo;

    @TableField("subject_three")
    private Integer subjectThree;

    @TableField("subject_four")
    private Integer subjectFour;

    @TableField("state_one")
    private Boolean stateOne;

    @TableField("state_two")
    private Boolean stateTwo;

    @TableField("state_three")
    private Boolean stateThree;

    @TableField("state_four")
    private Boolean stateFour;

    @TableField("student_id")
    private String studentId;


}
