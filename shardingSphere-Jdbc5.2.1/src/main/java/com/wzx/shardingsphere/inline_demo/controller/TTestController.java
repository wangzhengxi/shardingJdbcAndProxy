package com.wzx.shardingsphere.inline_demo.controller;


import com.wzx.shardingsphere.inline_demo.entity.TTest;
import com.wzx.shardingsphere.inline_demo.service.ITTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tTest")
public class TTestController {

        @Autowired
        private ITTestService testService;

        @GetMapping("/save")
        public String save(){
            List<TTest> tTestList = new ArrayList<>();
            for (int i =1 ; i<5;i++){
                TTest tTest = new TTest();
                tTest.setOrderId1(100+i);
                tTest.setUserId(i);
                tTest.setStatus("状态"+i);
                tTestList.add(tTest);
            }
            testService.saveBatch(tTestList);
            return "success";
        }

        @GetMapping("/get")
        public String get(Integer orderId1){
//            Long orderId = 347817138016223235L;
//            int userId = 5;
            TTest tTest = new TTest();
            tTest.setOrderId1(orderId1);
            TTest tTest1 = testService.selectById(tTest);
            if(tTest1!=null){
                return tTest1.getOrderId1()+":"+tTest1.getStatus()+":"+tTest1.getUserId();
            }
           return null;
        }


    @PostMapping("/tr")
    public String tr(){
        testService.tr();
        return "success";
    }
}
