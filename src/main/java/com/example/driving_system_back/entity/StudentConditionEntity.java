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
 * 学生学习情况及考试情况，记录的成绩是最高成绩
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("student_condition")
@ApiModel(value = "StudentConditionEntity对象", description = "学生学习情况及考试情况，记录的成绩是最高成绩")
public class StudentConditionEntity {

    @TableId(value = "condition_id", type = IdType.AUTO)
    private String conditionId;

    @TableField("student_id")
    private String studentId;

    @TableField("subject_one")
    private Integer subjectOne;

    @TableField("subject_two")
    private Integer subjectTwo;

    @TableField("subject_three")
    private Integer subjectThree;

    @TableField("subject_four")
    private Integer subjectFour;


}
