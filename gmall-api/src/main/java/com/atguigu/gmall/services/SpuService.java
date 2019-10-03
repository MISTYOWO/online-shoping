package com.atguigu.gmall.services;

import com.atguigu.gmall.beans.PmsProductImage;
import com.atguigu.gmall.beans.PmsProductInfo;
import com.atguigu.gmall.beans.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    public List<PmsProductInfo> spuList(String Catalog3Id);
    public void saveInfo(PmsProductInfo pmsProductInfo);
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId);
    public List<PmsProductImage> spuImageList(String spuId);
}
