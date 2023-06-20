package com.example.driving_system_back.service.impl;

import com.example.driving_system_back.entity.AdministratorEntity;
import com.example.driving_system_back.mapper.AdministratorMapper;
import com.example.driving_system_back.service.AdministratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Double-Hong and My-way and 何栋梁 and 肖雅云
 * @since 2023-06-03 14:03:41
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, AdministratorEntity> implements AdministratorService {



    public int login(AdministratorEntity administrator) {
        this.save(administrator);
        return 1;
    }

}
