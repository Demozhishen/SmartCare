package com.bjtu.web.spring_boot.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjtu.web.spring_boot.common.Result;
import com.bjtu.web.spring_boot.entity.VolunteerInfo;
import com.bjtu.web.spring_boot.entity.VolunteerInfo;
import com.bjtu.web.spring_boot.mapper.VolunteerInfoMapper;
import com.bjtu.web.spring_boot.mapper.VolunteerInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Api(tags = "义工管理")
@RestController
@CrossOrigin
@RequestMapping("/volunteerInfo")
public class VolunteerInfoController {
    @Resource
   VolunteerInfoMapper volunteerInfoMapper;

  


    @ApiOperation("添加义工")
    @PostMapping
    public Result<?> save(@RequestBody VolunteerInfo volunteerInfo){
        volunteerInfoMapper.insert(volunteerInfo);
        return Result.success();
    }

    @ApiOperation("查询义工")
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String search){
        Page<VolunteerInfo> volunteerInfoPage = volunteerInfoMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<VolunteerInfo>lambdaQuery().like(VolunteerInfo::getName, search));
        return Result.success(volunteerInfoPage);
    }




    @ApiOperation("修改义工")
     @PutMapping
    public Result<?> update(@RequestBody VolunteerInfo volunteerInfo){
        volunteerInfoMapper.updateById(volunteerInfo);
        return Result.success();
     }

     @ApiOperation("删除义工")
     @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id){
        volunteerInfoMapper.deleteById(id);
        return Result.success();
     }
    @ApiOperation("导出义工信息")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<VolunteerInfo> list = volunteerInfoMapper.selectList(null);
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/义工信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名


        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("义工信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }
}
