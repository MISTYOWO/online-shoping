package com.atguigu.gmall.services;

import com.atguigu.gmall.beans.PmsSkuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuService {
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo);
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
    public PmsSkuInfo getSkuById(String SkuId);
}
