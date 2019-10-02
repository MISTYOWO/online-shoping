package com.atguigu.gmall.services;

import com.atguigu.gmall.beans.PmsBaseAttrInfo;
import com.atguigu.gmall.beans.PmsBaseAttrValue;
import com.atguigu.gmall.beans.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
    public int updatePmsBaseAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
    public List<PmsBaseAttrValue> getAttrValueList(String catalog3Id);
    public List<PmsBaseSaleAttr> baseSaleAttrList();
}
