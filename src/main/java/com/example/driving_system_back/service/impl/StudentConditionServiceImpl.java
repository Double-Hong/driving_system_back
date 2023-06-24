package com.example.driving_system_back.service.impl;

import com.example.driving_system_back.entity.StudentConditionEntity;
import com.example.driving_system_back.mapper.StudentConditionMapper;
import com.example.driving_system_back.service.StudentConditionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生学习情况及考试情况，记录的成绩是最高成绩 服务实现类
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@Service
public class StudentConditionServiceImpl extends ServiceImpl<StudentConditionMapper, StudentConditionEntity> implements StudentConditionService {

}
