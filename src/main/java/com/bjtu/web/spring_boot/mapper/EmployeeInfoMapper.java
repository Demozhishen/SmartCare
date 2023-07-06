package com.bjtu.web.spring_boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.web.spring_boot.entity.EmployeeInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo> {
}
