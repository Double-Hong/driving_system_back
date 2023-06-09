package com.example.driving_system_back;

import com.example.driving_system_back.entity.CoachStudentListEntity;
import com.example.driving_system_back.mapper.CoachStudentListMapper;
import com.example.driving_system_back.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DrivingSystemBackApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    CoachStudentListMapper coachStudentListMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        System.out.println(studentMapper.selectList(null));
    }


    @Test
    void view(){
        List<CoachStudentListEntity> list = coachStudentListMapper.selectList(null);
        System.out.println(list);
    }
}
