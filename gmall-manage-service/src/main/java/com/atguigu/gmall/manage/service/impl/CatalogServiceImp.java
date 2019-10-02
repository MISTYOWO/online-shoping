package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.PmsBaseCatalog1;
import com.atguigu.gmall.beans.PmsBaseCatalog2;
import com.atguigu.gmall.beans.PmsBaseCatalog3;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.atguigu.gmall.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImp implements CatalogService {
    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }
    public List<PmsBaseCatalog2> getCatalog2(String id) {


        List<PmsBaseCatalog2> Catalog2s = (List<PmsBaseCatalog2>) pmsBaseCatalog2Mapper.selectBycatalog1Id(id);

         return Catalog2s;
    }
    public List<PmsBaseCatalog3> getCatalog3(String id) {
        return (List<PmsBaseCatalog3>) pmsBaseCatalog3Mapper.selectBycatalog2Id(id);
    }
}
