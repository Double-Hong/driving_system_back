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
 *
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("coach")
@ApiModel(value = "CoachEntity对象", description = "")
public class CoachEntity {

    @TableId(value = "coach_id", type = IdType.AUTO)
    private String coachId;

    @TableField("school_name")
    private String schoolName;

    @TableField("username")
    private String username;

    @TableField("`password`")
    private String password;

    @TableField("coach_name")
    private String coachName;

    @TableField("gender")
    private String gender;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("`type`")
    private String type;

    @TableField("teaching_age")
    private Integer teachingAge;

    @TableField("introduction")
    private String introduction;

}
