package com.bjtu.web.spring_boot.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjtu.web.spring_boot.common.Result;
import com.bjtu.web.spring_boot.entity.EventInfo;
import com.bjtu.web.spring_boot.entity.EventInfo;
import com.bjtu.web.spring_boot.mapper.EventInfoMapper;
import com.bjtu.web.spring_boot.mapper.EventInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Api(tags = "事件管理")
@RestController
@CrossOrigin
@RequestMapping("/eventInfo")
public class EventInfoController {
    @Resource
   EventInfoMapper eventInfoMapper;




    @ApiOperation("添加事件")
    @PostMapping
    public Result<?> save(@RequestBody EventInfo eventInfo){
        eventInfoMapper.insert(eventInfo);
        return Result.success();
    }

    @ApiOperation("查询事件")
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String search){
        Page<EventInfo> eventInfoPage = eventInfoMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<EventInfo>lambdaQuery().like(EventInfo::getEventType, search));
        return Result.success(eventInfoPage);
    }




    @ApiOperation("修改事件")
     @PutMapping
    public Result<?> update(@RequestBody EventInfo eventInfo){
        eventInfoMapper.updateById(eventInfo);
        return Result.success();
     }

     @ApiOperation("删除事件")
     @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id){
        eventInfoMapper.deleteById(id);
        return Result.success();
     }
    @ApiOperation("导出事件信息")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<EventInfo> list = eventInfoMapper.selectList(null);
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/事件信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名


        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("事件信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }
}
