package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName coach_student_list
 */
@TableName(value ="coach_student_list")
@Data
public class CoachStudentListEntity implements Serializable {
    /**
     * 
     */
    private String practice_id;

    /**
     * 
     */
    private String student_id;

    /**
     * 
     */
    private String student_name;

    /**
     * 
     */
    private String coach_id;

    /**
     * 
     */
    private Date practice_datetime;

    /**
     * 申请状态,教练同意还是拒绝
     */
    private Integer application_state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}