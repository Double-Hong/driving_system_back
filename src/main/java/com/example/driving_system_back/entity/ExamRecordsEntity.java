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
 * 考试记录
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("exam_records")
@ApiModel(value = "ExamRecordsEntity对象", description = "考试记录")
public class ExamRecordsEntity {

    @TableId(value = "exam_records_id", type = IdType.AUTO)
    private String examRecordsId;

    @TableField("student_id")
    private String studentId;

    @TableField("examination_id")
    private String examinationId;

    @TableField("score")
    private Double score;


}
