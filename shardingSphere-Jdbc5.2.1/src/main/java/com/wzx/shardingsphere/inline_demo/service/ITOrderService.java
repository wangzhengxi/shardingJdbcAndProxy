package com.wzx.shardingsphere.inline_demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import com.wzx.shardingsphere.inline_demo.request.TOrderPageRequest;

import java.util.List;


public interface ITOrderService extends IService<TOrder> {

    List<TOrder>  selectById(TOrder tOrder);

    List<TOrder> selectByUserId(TOrder tOrder);

    Page<TOrder> getPage(TOrderPageRequest request);

    int updateOne(TOrder tOrder);

    int deleteOne(Long userId);
}
