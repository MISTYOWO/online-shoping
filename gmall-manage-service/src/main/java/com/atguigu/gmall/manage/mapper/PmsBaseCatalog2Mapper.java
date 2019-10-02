package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.beans.PmsBaseCatalog2;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseCatalog2Mapper extends Mapper<PmsBaseCatalog2> {
    @Select("select * from pms_base_catalog2 where catalog1_id = #{catalog1Id} ")
    List<PmsBaseCatalog2> selectBycatalog1Id(String catalog1Id);
}
