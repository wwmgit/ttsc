package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/10/4 0004.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long ItemId) {
        //根据主键查询
        //TbItem item = itemMapper.selectByPrimaryKey(ItemId);
        //根据条件查询
        TbItemExample example = new TbItemExample();
        //设置条件
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(ItemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            TbItem item = list.get(0);
            return item;
        }
        return null;
    }

}

