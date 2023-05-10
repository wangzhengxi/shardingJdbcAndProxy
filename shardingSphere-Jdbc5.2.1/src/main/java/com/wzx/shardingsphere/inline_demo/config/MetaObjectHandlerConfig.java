package com.wzx.shardingsphere.inline_demo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object scanTime = getFieldValByName("scanTime", metaObject);
        if (scanTime == null) {
            //mybatis-plus版本2.0.9+
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object scanTime = getFieldValByName("scanTime", metaObject);
        if (scanTime == null) {
            //mybatis-plus版本2.0.9+
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }

}
