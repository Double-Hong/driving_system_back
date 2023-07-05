package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName("student")
@ApiModel(value = "StudentEntity对象", description = "")
public class StudentEntity {

    @TableId(value = "student_id", type = IdType.AUTO)
    private String studentId;

    @TableField("school_name")
    private String schoolName;

    @TableField("coach_id")
    private String coachId;

    @TableField("health_id")
    private String healthId;

    @TableField("username")
    private String username;

    @TableField("`password`")
    private String password;

    @TableField("student_name")
    private String studentName;

    @TableField("gender")
    private String gender;

    @TableField("birthday")
    private LocalDate birthday;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("study_type")
    private String studyType;

    @TableField("head_photo")
    private String headPhoto;

}
