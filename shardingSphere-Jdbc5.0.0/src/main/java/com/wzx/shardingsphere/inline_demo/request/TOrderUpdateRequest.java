package com.wzx.shardingsphere.inline_demo.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class TOrderUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;

    private Long userId;

    private String status;

//    @Override
//    public String toString() {
//        return "TOrder{" +
//        "orderId=" + orderId +
//        ", userId=" + userId +
//        ", status=" + status +
//        "}";
//    }
}
