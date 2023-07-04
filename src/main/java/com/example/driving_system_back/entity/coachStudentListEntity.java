package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.sql.Date;

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

    private String practiceId;

    /**
     *
     */
    private String studentId;

    /**
     *
     */
    private String studentName;

    /**
     *
     */
    private String coachId;

    /**
     *
     */
    private Date practiceDatetime;

    /**
     * 申请状态,教练同意还是拒绝
     */
    private Integer applicationState;

}
