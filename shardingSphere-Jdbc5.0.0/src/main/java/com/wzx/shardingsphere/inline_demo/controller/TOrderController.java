package com.wzx.shardingsphere.inline_demo.controller;


import com.alibaba.fastjson.JSON;
import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import com.wzx.shardingsphere.inline_demo.request.TOrderRequest;
import com.wzx.shardingsphere.inline_demo.request.TOrderUpdateRequest;
import com.wzx.shardingsphere.inline_demo.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @title:
 * @author: wzx
 * @date: 2023/5/4 9:03 下午
 * @version: v1.0.0
 */
@RestController
@RequestMapping("/tOrder")
public class TOrderController {

    @Autowired
    private ITOrderService itOrderService;

    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public String save() {
        List<TOrder> tOrderList = new ArrayList<>();
        for (long i = 0; i < 1000; i++) {
            TOrder tOrder = new TOrder();
            tOrder.setOrderId("AAA" + i);
            tOrder.setUserId(i);
            tOrder.setStatus("状态" + i);
            tOrderList.add(tOrder);
        }
//            itOrderService.saveBatch(tOrderList);
//            //测试事物
//            int i = 1 / 0;
        return "success";
    }

    @PostMapping("/getOrderId")
    public List<TOrder> getOrderId(@RequestBody TOrderRequest request) {
//            Long orderId = 347817138016223235L;
//            int userId = 5;
        TOrder tOrder = new TOrder();
//            tOrder.setUserId(userId);
        tOrder.setOrderId(request.getOrderId());
        List<TOrder> tOrder1 = itOrderService.selectById(tOrder);
        if (tOrder1 != null) {
            return tOrder1;
        }
        return null;
    }

    @GetMapping("/getUserId")
    public List<TOrder> getUserId(Long userId) {
//            Long orderId = 347817138016223235L;
//            int userId = 5;
        TOrder tOrder = new TOrder();
//            tOrder.setUserId(userId);
        tOrder.setUserId(userId);
        List<TOrder> tOrderList = itOrderService.selectByUserId(tOrder);
        if (tOrderList != null) {
            return tOrderList;
        }
        return null;
    }


    @PostMapping("/saveOne")
    @Transactional(rollbackFor = Exception.class)
    public String saveOne(@RequestBody TOrderRequest request) {
        TOrder tOrder = new TOrder();
        tOrder.setOrderId(request.getOrderId());
        tOrder.setUserId(request.getUserId());
        tOrder.setStatus(request.getStatus());
        itOrderService.save(tOrder);
        return "success";
    }

    //更新
    @PostMapping("/updateOne")
    @Transactional(rollbackFor = Exception.class)
    public String updateOne(@RequestBody TOrderUpdateRequest request) {
        TOrder tOrder = new TOrder();
        tOrder.setOrderId(request.getOrderId());
        tOrder.setUserId(request.getUserId());
        tOrder.setStatus(request.getStatus());
        itOrderService.updateOne(tOrder);
        return "success";
    }

    @PostMapping("/deleteOne")
    @Transactional(rollbackFor = Exception.class)
    public String deleteOne(@RequestBody TOrderUpdateRequest request) {
        itOrderService.deleteOne(request.getUserId());
        return "success";
    }
}
