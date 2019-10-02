package com.atguigu.gmall.services;

import com.atguigu.gmall.beans.PmsBaseCatalog1;
import com.atguigu.gmall.beans.PmsBaseCatalog2;
import com.atguigu.gmall.beans.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();
    List<PmsBaseCatalog2> getCatalog2(String id);
    List<PmsBaseCatalog3> getCatalog3(String id);
}
