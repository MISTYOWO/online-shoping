package com.example.misty.user.mapper;

import com.atguigu.gmall.beans.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper  extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
