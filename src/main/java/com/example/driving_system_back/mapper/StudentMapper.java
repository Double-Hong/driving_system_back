package com.example.driving_system_back.mapper;

import com.example.driving_system_back.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentEntity> {
    public List<String> getRoleNameByUserId(Integer userId);
}
