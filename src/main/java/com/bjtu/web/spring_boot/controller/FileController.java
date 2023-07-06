package com.bjtu.web.spring_boot.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.bjtu.web.spring_boot.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RequestMapping("/file")
@RestController
@CrossOrigin
public class FileController {

    @Value("${server.port}")
    private String port;

    public static final String ip="http://localhost";


    @PostMapping("/upload/{dir}")
    public Result<?> upload(MultipartFile file,@PathVariable String dir) throws IOException {
        String originalFilename = file.getOriginalFilename();
        System.out.println(dir);
        String flag = IdUtil.fastSimpleUUID();
        String rootPath=System.getProperty("user.dir")+"/src/main/resources/file/"+dir+"/"+flag+"_"+originalFilename;
        System.out.printf(rootPath);
        FileUtil.writeBytes(file.getBytes(),rootPath);
        return Result.success(ip+":"+port+"/file/"+flag+"/"+dir);
    }

    @GetMapping("/{flag}/{dir}")
    public void getFiles(@PathVariable String flag,@PathVariable String dir, HttpServletResponse response) {
        OutputStream os;
        String basePath=System.getProperty("user.dir")+"/src/main/resources/file/"+dir+"/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String filename = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if (StrUtil.isNotEmpty(filename)){
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + filename);
                os=response.getOutputStream();
                // 读取文件的字节流
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
