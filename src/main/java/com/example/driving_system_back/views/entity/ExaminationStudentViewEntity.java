package com.example.driving_system_back.views.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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

}
