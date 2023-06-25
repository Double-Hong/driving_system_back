package com.example.driving_system_back.mapper;

import com.example.driving_system_back.entity.PracticeApplicationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.driving_system_back.entity.StudentApplyNameEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 练车申请 Mapper 接口
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Mapper
public interface PracticeApplicationMapper extends BaseMapper<PracticeApplicationEntity> {
    List<StudentApplyNameEntity> getStudentApplyWithNameByStudentId(String studentId);
    List<StudentApplyNameEntity> listApplyWithStudent();
}
