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
@TableName("school")
@ApiModel(value = "SchoolEntity对象", description = "")
public class SchoolEntity {

    @TableId(value = "school_name", type = IdType.AUTO)
    private String schoolName;

    @TableField("introduction")
    private String introduction;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;


}
