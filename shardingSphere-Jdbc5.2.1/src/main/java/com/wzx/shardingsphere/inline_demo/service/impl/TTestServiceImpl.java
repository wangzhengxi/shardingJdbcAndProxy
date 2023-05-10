package com.wzx.shardingsphere.inline_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import com.wzx.shardingsphere.inline_demo.entity.TTest;
import com.wzx.shardingsphere.inline_demo.mapper.TOrderMapper;
import com.wzx.shardingsphere.inline_demo.mapper.TTestMapper;
import com.wzx.shardingsphere.inline_demo.service.ITTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TTestServiceImpl extends ServiceImpl<TTestMapper, TTest>  implements ITTestService {

    @Autowired
    private TTestMapper tTestMapper;
    @Autowired
    TOrderMapper tOrderMapper;

    @Override
    public TTest selectById(TTest tTest) {

        return tTestMapper.getById(tTest.getOrderId1());
    }

//    测试多个数据库的事务问题
    @Override
    public int tr(){
        TTest tTest=new TTest();
        tTest.setOrderId1(1);
        tTest.setStatus("11");
        tTest.setUserId(1);
        tTestMapper.insert(tTest);
//        int a=1/0;
        TOrder tOrder=new TOrder();
        tOrder.setOrderId("AAA110");
        tOrder.setStatus("12");
        tOrder.setUserId(1L);
        tOrderMapper.insert(tOrder);
        return 0;
    };
}
