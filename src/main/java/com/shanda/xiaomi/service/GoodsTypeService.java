package com.shanda.xiaomi.service;

import com.shanda.xiaomi.dao.GoodsTypeMapper;
import com.shanda.xiaomi.entry.GoodsType;
import com.shanda.xiaomi.entry.GoodsTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//商品类型业务处理类
@Service
public class GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    //查询一级商品类型
    public List<GoodsType> findTopLevel(){
        GoodsTypeExample gte = new GoodsTypeExample();
        gte.createCriteria().andPidIsNull();
        return goodsTypeMapper.selectByExample(gte);
    }
    //根据一级类型,查询所有所属的二级类型
    public List<GoodsType> findSecondLevel(GoodsType top){
        GoodsTypeExample gte = new GoodsTypeExample();
        gte.createCriteria().andPidEqualTo(top.getId());
        return goodsTypeMapper.selectByExample(gte);


    }
    //根据指定编号查询一个类型
    //goodsTypeId主键编号
    public GoodsType findById(Integer goodsTypeId) {
        return goodsTypeMapper.selectByPrimaryKey(goodsTypeId);
    }
}
