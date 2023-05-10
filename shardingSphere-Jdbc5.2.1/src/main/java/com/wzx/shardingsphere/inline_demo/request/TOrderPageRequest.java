package com.wzx.shardingsphere.inline_demo.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class TOrderPageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageSize;

    private Integer pageNum;
}
