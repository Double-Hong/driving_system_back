package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 学生学习情况及考试情况，记录的成绩是最高成绩
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Data
@Getter
@Setter
@TableName("student_condition_view")
@ApiModel(value = "StudentConditionEntity对象", description = "学生学习情况及考试情况，记录的成绩是最高成绩")
public class StudentConditionViewEntity implements Serializable {

    private String conditionId;

    private String studentId;

    private Integer subjectOne;

    private Integer subjectTwo;


    private Integer subjectThree;


    private Integer subjectFour;


    private Integer practiceTimeOne;


    private Integer practiceTimeTwo;


    private Integer practiceTimeThree;


    private Integer practiceTimeFour;

    private String studentName;

    private Integer applicationState;

    private String practiceType;

    private String practiceId;

}
