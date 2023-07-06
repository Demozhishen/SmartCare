package com.bjtu.web.spring_boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjtu.web.spring_boot.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
}
