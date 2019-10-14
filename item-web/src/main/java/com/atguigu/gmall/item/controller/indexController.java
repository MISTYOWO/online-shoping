package com.atguigu.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.beans.PmsProductSaleAttr;
import com.atguigu.gmall.beans.PmsSkuInfo;
import com.atguigu.gmall.beans.PmsSkuSaleAttrValue;
import com.atguigu.gmall.services.SkuService;
import com.atguigu.gmall.services.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class indexController {
    @Reference
    SkuService skuService;
    @Reference
    SpuService spuService;

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap){
        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);;
        modelMap.put("skuInfo",pmsSkuInfo);


        if(pmsSkuInfo != null){
            List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spusaleAttrLIstCheckBySku(pmsSkuInfo.getProductId(),pmsSkuInfo.getId());
            modelMap.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrs);
            Map<String,String> skuSaleAttrHash = new HashMap<>();
            List<PmsSkuInfo> pmsSkuInfos = skuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
            for (PmsSkuInfo skuInfo : pmsSkuInfos) {
                String k = "";
                String v = skuInfo.getId();
                List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
                for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                    k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";
                }
                skuSaleAttrHash.put(k, v);
            }
            String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
            modelMap.put("skuSaleAttrHashJsonStr", skuSaleAttrHashJsonStr);
        }

        return "item";
    }
}
