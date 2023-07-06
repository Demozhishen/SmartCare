package com.bjtu.web.spring_boot.controller;



import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bjtu.web.spring_boot.common.Result;
import com.bjtu.web.spring_boot.entity.SysUser;
import com.bjtu.web.spring_boot.mapper.SysUserMapper;
import com.bjtu.web.spring_boot.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登陆注册")
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    SysUserMapper sysUserMapper;


    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<?> findUser(@RequestBody SysUser sysUser) {


        SysUser sysUser1 = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, sysUser.getUserName()).eq(SysUser::getPassword, sysUser.getPassword()));
        if (sysUser1 == null) {
            return Result.error("200", "未查询到用户信息");
        }
        String token = TokenUtils.genToken(String.valueOf(sysUser1.getId()), sysUser1.getPassword());
        sysUser1.setToken(token);
        return Result.success(sysUser1);

    }


}
