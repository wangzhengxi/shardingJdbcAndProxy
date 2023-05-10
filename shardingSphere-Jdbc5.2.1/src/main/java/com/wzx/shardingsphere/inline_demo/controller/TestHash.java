package com.wzx.shardingsphere.inline_demo.controller;

import java.util.ArrayList;
import java.util.List;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.println;

/**
 * meta
 *
 * @author create by wangzx on 2023/5/5 11:54
 * @version meta v1.0.0
 */
public class TestHash {

    public static  void main (String []arg){
        Long a=100000002131312339L;
        a=a/10;
        Long b=1L;
        b=b/10;
        System.out.println(a);
        System.out.println(b);
    }
}
