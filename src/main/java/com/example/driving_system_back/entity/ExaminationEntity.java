package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("examination")
@ApiModel(value = "ExaminationEntity对象", description = "")
public class ExaminationEntity {

    @TableId(value = "examination_id", type = IdType.AUTO)
    private String examinationId;

    @TableField("examination_name")
    private String examinationName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("examination_open_time")
    private LocalDateTime examinationOpenTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("examination_close_time")
    private LocalDateTime examinationCloseTime;

    @TableField("examination_time")
    private String examinationTime;

    @TableField("organization_id")
    private String organizationId;

    @TableField("examination_type")
    private String examinationType;

    @TableField("examination_subject")
    private String examinationSubject;

    @TableField("examination_address")
    private String examinationAddress;

}
