package com.wzx.shardingsphere.inline_demo.service;

import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ITOrderService  extends IService<TOrder>{

    TOrder selectById(TOrder tOrder);

    TOrder selectByUserId(TOrder tOrder);

}
