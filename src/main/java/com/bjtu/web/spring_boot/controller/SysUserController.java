package com.bjtu.web.spring_boot.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjtu.web.spring_boot.common.Result;

import com.bjtu.web.spring_boot.entity.SysUser;
import com.bjtu.web.spring_boot.mapper.SysUserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Api(tags = "系统管理员管理")
@RestController
@CrossOrigin
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    SysUserMapper sysUserMapper;

 

    @ApiOperation("添加系统管理员")
    @PostMapping
    public Result<?> save(@RequestBody SysUser sysUser){
        sysUserMapper.insert(sysUser);
        return Result.success();
    }

    @ApiOperation("查询系统管理员")
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String search){
        Page<SysUser> sysUserPage = sysUserMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<SysUser>lambdaQuery().like(SysUser::getUserName, search));
        return Result.success(sysUserPage);
    }




    @ApiOperation("修改系统管理员")
     @PutMapping
    public Result<?> update(@RequestBody SysUser sysUser){
        sysUserMapper.updateById(sysUser);
        return Result.success();
     }

     @ApiOperation("删除系统管理员")
     @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id){
        sysUserMapper.deleteById(id);
        return Result.success();
     }
    @ApiOperation("导出系统管理员信息")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<SysUser> list = sysUserMapper.selectList(null);
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/系统管理员信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名


        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("系统管理员信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }
}
