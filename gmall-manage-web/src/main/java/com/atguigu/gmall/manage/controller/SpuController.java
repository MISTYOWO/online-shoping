package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.PmsProductInfo;
import com.atguigu.gmall.services.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@Controller
public class SpuController {
    @Reference
    SpuService spuService;
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String Catalog3Id){
        return spuService.spuList(Catalog3Id);
    }
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        return "success";
    }
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String imgUrl = "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";
        return imgUrl;
    }

}
