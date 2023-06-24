package com.example.driving_system_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2023-06-19 18:07:31
 */
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName("blank_topic")
@ApiModel(value = "BlankTopicEntity对象", description = "")
public class BlankTopicEntity {

    @TableId(value = "blank_topic", type = IdType.AUTO)
    private String blankTopic;

    @TableField("blank_topic_describe")
    private String blankTopicDescribe;

    @TableField("correct_answer")
    private String correctAnswer;


    public String getBlankTopicId() {
        return blankTopic;
    }

    public void setBlankTopicId(String id) {
        this.blankTopic = id;
    }
}
