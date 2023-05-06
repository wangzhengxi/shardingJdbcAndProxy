package com.wzx.shardingsphere.inline_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzx.shardingsphere.inline_demo.entity.TTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface TTestMapper extends BaseMapper<TTest>{

    TTest getById(@Param("orderId1") Integer orderId1);
}
