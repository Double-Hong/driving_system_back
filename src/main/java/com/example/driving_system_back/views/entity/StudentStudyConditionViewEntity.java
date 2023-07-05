package com.example.driving_system_back.views.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author :Double-Hong
 * @name :driving_system_back
 * @date :2023/7/5
 * @time :12:10
 **/
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName("student_study_condition_view")
public class StudentStudyConditionViewEntity {

    @TableField("student_name")
    private String studentName;

    @TableField("study_type")
    private String studyType;

    @TableField("condition_id")
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

    @TableField("practice_time_one")
    private Integer practiceTimeOne;

    @TableField("practice_time_two")
    private Integer practiceTimeTwo;

    @TableField("practice_time_three")
    private Integer practiceTimeThree;

    @TableField("practice_time_four")
    private Integer practiceTimeFour;


}
