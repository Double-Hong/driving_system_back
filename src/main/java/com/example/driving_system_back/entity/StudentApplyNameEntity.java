package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Getter
@Setter
@Accessors(chain = true)
@Data
public class StudentApplyNameEntity {

    private String practiceId;
    private String studentId;
    private String coachId;
    private LocalDateTime practiceDatetime;
    private Boolean applicationState;
    private  String studentName;

    public StudentApplyNameEntity(String studentId, String practiceId, String coachId, Boolean status, LocalDateTime practiceDatetime, String name) {
        this.studentId = studentId;
        this.practiceId = practiceId;
        this.coachId = coachId;
        this.applicationState = status;
        this.practiceDatetime = practiceDatetime;
        this.studentName = name;
    }
}
