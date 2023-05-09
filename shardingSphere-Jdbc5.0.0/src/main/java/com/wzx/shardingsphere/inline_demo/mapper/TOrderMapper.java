package com.wzx.shardingsphere.inline_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface TOrderMapper extends BaseMapper<TOrder>{

    List<TOrder>  getById(@Param("orderId") String orderId);

    List<TOrder> getByUserId(@Param("userId") Long userId);

    int updateOne(TOrder tOrder);

    int deleteOne(@Param("userId") Long userId);
}
