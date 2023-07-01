package com.example.driving_system_back.mapper;

import com.example.driving_system_back.entity.StudentConditionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生学习情况及考试情况，记录的成绩是最高成绩 Mapper 接口
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Mapper
public interface StudentConditionMapper extends BaseMapper<StudentConditionEntity> {

}
