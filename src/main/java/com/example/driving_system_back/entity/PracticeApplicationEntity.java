package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 练车申请
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("practice_application")
@ApiModel(value = "PracticeApplicationEntity对象", description = "练车申请")
public class PracticeApplicationEntity {

    @TableId(value = "practice_id", type = IdType.AUTO)
    private String practiceId;

    @TableField("student_id")
    private String studentId;

    @TableField("coach_id")
    private String coachId;

    @ApiModelProperty(value="练习时间")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern= "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime practiceDatetime;

    @ApiModelProperty("申请状态,教练同意还是拒绝")
    @TableField("application_state")
    private Integer applicationState;

    @TableField("practice_type")
    private String practiceType;

    @TableField("practice_type")
    private String practiceType;

}
