package com.example.driving_system_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.driving_system_back.entity.Result;
import com.example.driving_system_back.entity.coachStudentListEntity;
import com.example.driving_system_back.mapper.coachStudentListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 练车申请 前端控制器
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-24 10:27:57
 */
@RestController
@RequestMapping("/practice-application-entity")
public class PracticeApplicationController {

    @Autowired
    private coachStudentListMapper coachStudentListMapper;

//    @Autowired
//    private PracticeApplicationMapper practiceApplicationMapper;
//
//    @Autowired
//    private StudentService studentService;
//    @GetMapping("/getApplicationById/{studentId}")
//    public List<StudentApplyNameEntity> getStudentApplyNameByStudentId(@PathVariable String studentId) {
//        // 先查询学生信息
//        StudentEntity student = studentService.getById(studentId);
//        if (student == null) {
//            throw new RuntimeException("没有找到学生信息");
//        }
//        // 查询学生申请信息和对应的学生姓名
//        List<StudentApplyNameEntity> applyList = practiceApplicationMapper.getStudentApplyWithNameByStudentId(studentId);
//        // 将查询结果中的学生姓名设置为已知结果
//        for (StudentApplyNameEntity apply : applyList) {
//            apply.setStudentName(student.getStudentName());
//        }
//        return applyList;
//    }
//    @GetMapping("/same_student")
//    public List<StudentApplyNameEntity> listSameStudentApply() {
//        return practiceApplicationMapper.listApplyWithStudent();
//    }
    @GetMapping("/student/{studentId}")
    public Result<?> getApplicationById(@PathVariable String studentId){
        List<coachStudentListEntity> students = (List<coachStudentListEntity>) coachStudentListMapper.selectById(studentId);
        return Result.success(students);
    }
    @GetMapping
    public Result<?> getAllApplication(){
        List<coachStudentListEntity> students = coachStudentListMapper.selectList(new QueryWrapper<coachStudentListEntity>().like("student_name",""));
        return Result.success(students);
    }
}
