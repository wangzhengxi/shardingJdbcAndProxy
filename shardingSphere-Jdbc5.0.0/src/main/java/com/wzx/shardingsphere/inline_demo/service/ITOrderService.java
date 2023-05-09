package com.wzx.shardingsphere.inline_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzx.shardingsphere.inline_demo.entity.TOrder;

import java.util.List;


public interface ITOrderService extends IService<TOrder> {

    List<TOrder>  selectById(TOrder tOrder);

    List<TOrder> selectByUserId(TOrder tOrder);

    int updateOne(TOrder tOrder);

    int deleteOne(Long userId);
}
