package com.bjtu.web.spring_boot.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjtu.web.spring_boot.common.Result;
import com.bjtu.web.spring_boot.entity.EmployeeInfo;
import com.bjtu.web.spring_boot.entity.EmployeeInfo;
import com.bjtu.web.spring_boot.mapper.EmployeeInfoMapper;
import com.bjtu.web.spring_boot.mapper.EmployeeInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Api(tags = "员工信息管理")
@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeInfoController {
    @Resource
   EmployeeInfoMapper employeeInfoMapper;
    


    @ApiOperation("添加员工信息")
    @PostMapping
    public Result<?> save(@RequestBody EmployeeInfo employeeInfo){
        employeeInfoMapper.insert(employeeInfo);
        return Result.success();
    }

    @ApiOperation("查询员工信息")
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String search){
        Page<EmployeeInfo> employeeInfoPage = employeeInfoMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<EmployeeInfo>lambdaQuery().like(EmployeeInfo::getUsername, search));
        return Result.success(employeeInfoPage);
    }




    @ApiOperation("修改员工信息")
     @PutMapping
    public Result<?> update(@RequestBody EmployeeInfo employeeInfo){
        employeeInfoMapper.updateById(employeeInfo);
        return Result.success();
     }

     @ApiOperation("删除员工信息")
     @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id){
        employeeInfoMapper.deleteById(id);
        return Result.success();
     }
    @ApiOperation("导出员工信息信息")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<EmployeeInfo> list = employeeInfoMapper.selectList(null);
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/员工信息信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名


        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("员工信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

/*    @PostMapping("/upload")
    public Result<?> uploadFile(@RequestParam(value = "file",required = false)MultipartFile file){
        if (file.isEmpty()) {
            return Result.error("303","文件为空");
        }

        String originalFilename = file.getOriginalFilename();
        String fileName=System.currentTimeMillis()+"."+originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        String path="C:\\Users\\14485\\Desktop\\bicycle-vue\\vue\\springboot-vue-demo\\src\\assets\\employee\\";
        File dest = new File(path + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return Result.success(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }*/
}
