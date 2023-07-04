package com.example.driving_system_back.views.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@TableName("examing_view")
public class ExamingViewEntity {

   @TableField("examination_id")
    private String examinationId;

   @TableField("multiple_choice_id")
    private String multipleChoiceId;

   @TableField("answer")
    private String answer;

   @TableField("fraction")
    private int fraction;

   @TableField ("correct_answer")
    private String correctAnswer;

   @TableField("multiple_choice_describe")
    private String multipleChoiceDescribe;

   @TableField("option1")
    private String option1;

   @TableField("option2")
    private String option2;

    @TableField("option3")
    private String option3;

    @TableField("option4")
    private String option4;

}
