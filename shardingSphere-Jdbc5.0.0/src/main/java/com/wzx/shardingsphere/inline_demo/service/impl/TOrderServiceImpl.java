package com.wzx.shardingsphere.inline_demo.service.impl;

import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import com.wzx.shardingsphere.inline_demo.mapper.TOrderMapper;
import com.wzx.shardingsphere.inline_demo.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder>  implements ITOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public TOrder selectById(TOrder tOrder) {

        return tOrderMapper.getById(tOrder.getOrderId());
    }

    @Override
    public TOrder selectByUserId(TOrder tOrder) {

        return tOrderMapper.getByUserId(tOrder.getUserId());
    }
}
