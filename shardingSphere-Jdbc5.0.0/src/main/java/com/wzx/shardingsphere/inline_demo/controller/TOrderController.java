package com.wzx.shardingsphere.inline_demo.controller;


import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import com.wzx.shardingsphere.inline_demo.request.TOrderRequest;
import com.wzx.shardingsphere.inline_demo.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @title:
 * @author: wzx
 * @date: 2023/5/4 9:03 下午
 * @version:  v1.0.0
 */
@RestController
@RequestMapping("/tOrder")
public class TOrderController {

        @Autowired
        private ITOrderService itOrderService;

        @GetMapping("/save")
        public String save(){
            List<TOrder> tOrderList = new ArrayList<>();
            for (long i =0 ; i<100;i++){
                TOrder tOrder = new TOrder();
                tOrder.setOrderId("AAA"+i);
                tOrder.setUserId(i);
                tOrder.setStatus("状态"+i);
                tOrderList.add(tOrder);
            }
            itOrderService.saveBatch(tOrderList);
            return "success";
        }

        @GetMapping("/get")
        public String get(String orderId){
//            Long orderId = 347817138016223235L;
//            int userId = 5;
            TOrder tOrder = new TOrder();
//            tOrder.setUserId(userId);
            tOrder.setOrderId(orderId);
            TOrder tOrder1 = itOrderService.selectById(tOrder);
            if(tOrder1!=null){
                return tOrder1.getOrderId()+":"+tOrder1.getStatus()+":"+tOrder1.getUserId();
            }
           return null;
        }

    @GetMapping("/getUserId")
    public String getUserId(Long userId){
//            Long orderId = 347817138016223235L;
//            int userId = 5;
        TOrder tOrder = new TOrder();
//            tOrder.setUserId(userId);
        tOrder.setUserId(userId);
        TOrder tOrder1 = itOrderService.selectByUserId(tOrder);
        if(tOrder1!=null){
            return tOrder1.getOrderId()+":"+tOrder1.getStatus()+":"+tOrder1.getUserId();
        }
        return null;
    }



    @PostMapping("/saveOne")
    public String saveOne(@RequestBody TOrderRequest request){
        TOrder tOrder= new TOrder();
        tOrder.setOrderId(request.getOrderId());
        tOrder.setUserId(request.getUserId());
        tOrder.setStatus(request.getStatus());
        itOrderService.save(tOrder);
        return "success";
    }
}
