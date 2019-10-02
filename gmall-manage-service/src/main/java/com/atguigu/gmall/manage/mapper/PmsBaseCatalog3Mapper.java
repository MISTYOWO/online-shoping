package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.beans.PmsBaseCatalog2;
import com.atguigu.gmall.beans.PmsBaseCatalog3;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseCatalog3Mapper extends Mapper<PmsBaseCatalog3> {
    @Select("select * from pms_base_catalog3 where catalog2_id = #{catalog2Id} ")
    List<PmsBaseCatalog3> selectBycatalog2Id(String catalog2Id);
}
