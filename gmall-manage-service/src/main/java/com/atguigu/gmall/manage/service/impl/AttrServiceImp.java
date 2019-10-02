package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.PmsBaseAttrInfo;
import com.atguigu.gmall.beans.PmsBaseAttrValue;
import com.atguigu.gmall.beans.PmsBaseSaleAttr;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.atguigu.gmall.services.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class AttrServiceImp implements AttrService {
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos =  pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public int updatePmsBaseAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrInfo.getAttrValueList();
        int len = pmsBaseAttrValues.size();
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue() ;
        pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
        pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
        int status;
        for(int i=0;i<len;i++){
            pmsBaseAttrValues.get(i).setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.insert(pmsBaseAttrValues.get(i));
        }
        if(pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo) != null){
            status = pmsBaseAttrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);
        }
        else{
            status = pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
        }
        return status;
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
