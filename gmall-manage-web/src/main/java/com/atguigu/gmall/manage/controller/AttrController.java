package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.PmsBaseAttrInfo;
import com.atguigu.gmall.beans.PmsBaseAttrValue;
import com.atguigu.gmall.beans.PmsBaseSaleAttr;
import com.atguigu.gmall.beans.PmsProductInfo;
import com.atguigu.gmall.services.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@CrossOrigin
@Controller
public class AttrController {
    @Reference
    AttrService attrService;
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos= attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        int status =  attrService.updatePmsBaseAttrInfo(pmsBaseAttrInfo);
        return status == 1?"success":"failed";
    }
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> PmsBaseAttrValues =  attrService.getAttrValueList(attrId);
        return PmsBaseAttrValues;
    }
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        return attrService.baseSaleAttrList();
    }
}
