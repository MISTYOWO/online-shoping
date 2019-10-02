package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.PmsProductInfo;
import com.atguigu.gmall.manage.mapper.SpuServiceMapper;
import com.atguigu.gmall.services.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class SpuServiceImp implements SpuService {
    @Autowired
    SpuServiceMapper spuServiceMapper;
    @Override
    public List<PmsProductInfo> spuList(String Catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(Catalog3Id);
        return spuServiceMapper.select(pmsProductInfo);
    }
}
