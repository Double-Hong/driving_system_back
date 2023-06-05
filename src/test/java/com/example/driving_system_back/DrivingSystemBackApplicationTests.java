package com.example.driving_system_back;

import com.example.driving_system_back.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrivingSystemBackApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        System.out.println(studentMapper.selectList(null));
    }

}
