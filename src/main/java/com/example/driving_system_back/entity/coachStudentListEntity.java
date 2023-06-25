package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@TableName("coach_student_list")
public class coachStudentListEntity {
    @TableId(value = "practice_id", type = IdType.AUTO)
    private String practiceId;

    @TableField("student_id")
    private String studentId;

    @TableField("coach_id")
    private String coachId;

    @TableField("practice_datetime")
    private LocalDateTime practiceDatetime;

    @ApiModelProperty("申请状态,教练同意还是拒绝")
    @TableField("application_state")
    private Boolean applicationState;
    @TableField("student_name")
    private String studentName;
}
