package com.example.driving_system_back.views.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author :Double-Hong
 * @name :driving_system_back
 * @date :2023/7/2
 * @time :17:27
 **/
@Getter
@Setter
@Accessors(chain = true)
@TableName("examination_student_view")
public class ExaminationStudentViewEntity {

    @TableField("exam_records_id")
    private String examRecordsId;

    @TableField("student_id")
    private String studentId;

    @TableField("examination_id")
    private String examinationId;

    @TableField("score")
    private Double score;

    @TableField("student_name")
    private String studentName;

    @TableField("examination_name")
    private String examinationName;

    @TableField("examination_type")
    private String examinationType;

    @TableField("examination_subject")
    private String examinationSubject;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("examination_open_time")
    private LocalDateTime examinationOpenTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("examination_close_time")
    private LocalDateTime examinationCloseTime;
}
