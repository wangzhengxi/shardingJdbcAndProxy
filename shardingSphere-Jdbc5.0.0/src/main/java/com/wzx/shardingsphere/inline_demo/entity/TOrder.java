package com.wzx.shardingsphere.inline_demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * meta
 *
 * @author create by wangzx on 2023/5/5 11:54
 * @version meta v1.0.0
 */
@Data
public class TOrder implements Serializable {

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
