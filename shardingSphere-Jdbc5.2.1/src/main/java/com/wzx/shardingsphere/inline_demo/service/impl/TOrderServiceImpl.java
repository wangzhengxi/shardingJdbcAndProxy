package com.wzx.shardingsphere.inline_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzx.shardingsphere.inline_demo.entity.TOrder;
import com.wzx.shardingsphere.inline_demo.mapper.TOrderMapper;
import com.wzx.shardingsphere.inline_demo.request.TOrderPageRequest;
import com.wzx.shardingsphere.inline_demo.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public List<TOrder> selectById(TOrder tOrder) {

        return tOrderMapper.getById(tOrder.getOrderId());
    }

    @Override
    public List<TOrder> selectByUserId(TOrder tOrder) {

        return tOrderMapper.getByUserId(tOrder.getUserId());
    }

    @Override
    public Page<TOrder> getPage(TOrderPageRequest request) {
        Integer pageNum = request.getPageNum();
        Integer pageSize = request.getPageSize();
        Page<TOrder> page = PageHelper.startPage(pageNum, pageSize);
        List<TOrder> pageRes = tOrderMapper.getPage();
        return page;
    }

    @Override
    public int updateOne(TOrder tOrder) {
        return tOrderMapper.updateOne(tOrder);
    }

    @Override
    public int deleteOne(Long userId) {
        return tOrderMapper.deleteOne(userId);
    }
}
