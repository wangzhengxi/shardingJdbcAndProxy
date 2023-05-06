package com.wzx.shardingsphere.inline_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzx.shardingsphere.inline_demo.entity.TTest;


public interface ITTestService extends IService<TTest>{

    TTest selectById(TTest tTest);
    int tr();
}
