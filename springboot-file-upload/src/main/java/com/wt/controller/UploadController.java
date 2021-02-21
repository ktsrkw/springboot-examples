package com.wt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Objects;
import java.util.UUID;

@Controller
public class UploadController {

    @GetMapping("/")
    public String toUploadPage(){
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile, HttpServletRequest request){
        try{
            ////处理上传文件的步骤////

            //1、创建文件在服务器端的存放路径
            String imgPath = System.getProperty("user.dir") + "/src/main/resources/static/useruploads";
            //上面的System.getProperty("user.dir")自动获取项目目录，这样部署的时候就不需要改源码了
            //使用手动的绝对路径是这样的：
            //String imgPath="D:/codes/download/springboot-fileupload/src/main/resources/static/userUpload";
            File imgDir = new File(imgPath);

            //2、生成文件在服务器端存放的名字（避免重名）
            //得到上传文件的后缀名（.jpg，.txt，.mp4 ...）
            String fileSuffix= Objects.requireNonNull(uploadFile.getOriginalFilename())
                    .substring(uploadFile.getOriginalFilename().lastIndexOf("."));
            //给文件准备好一个新的名字imgNewName：随机生成的UUID再加上前面取得的文件后缀名
            String imgNewName= UUID.randomUUID().toString()+fileSuffix;
            File uploadedFile = new File(imgDir+"/"+imgNewName);

            //3、上传
            uploadFile.transferTo(uploadedFile);

            //4、获取上传文件的访问路径
            //这里的images是映射路径，实际不是存储在这的
            String filePath = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/images/" + imgNewName;

            //返回访问图片的地址给前端
            return filePath;

        }catch(Exception e) {
            e.printStackTrace();
            return "上传失败";
        }

    }

}
