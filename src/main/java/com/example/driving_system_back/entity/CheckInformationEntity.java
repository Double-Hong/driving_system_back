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
 * 打卡信息
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("check_information")
@ApiModel(value = "CheckInformationEntity对象", description = "打卡信息")
public class CheckInformationEntity {

    @TableId(value = "check_infomation_id", type = IdType.AUTO)
    private String checkInfomationId;

    @TableField("student_id")
    private String studentId;

    @TableField("coach_id")
    private String coachId;

    @ApiModelProperty("类型,C1或C2")
    @TableField("check_type")
    private String checkType;

    @ApiModelProperty("科目三还是科目二")
    @TableField("check_subject")
    private String checkSubject;


}
