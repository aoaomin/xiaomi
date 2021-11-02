package com.shanda.xiaomi.service;

import com.shanda.xiaomi.dao.GoodsMapper;
import com.shanda.xiaomi.dao.GoodsTypeMapper;
import com.shanda.xiaomi.entry.Goods;
import com.shanda.xiaomi.entry.GoodsExample;
import com.shanda.xiaomi.entry.GoodsType;
import com.shanda.xiaomi.entry.GoodsTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//商品业务处理类
@Service
public class GoodsShippingService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsTypeService goodsTypeServicer;
    //根据id查询商品
    public Goods findGoodsWithId(Integer id){
        return goodsMapper.selectByPrimaryKey(id);
    }
    //根据商品类型查询商品     二级商品类型
    //goodstype商品类型
    //return属于指定商品类型的所有商品
    public List<Goods> findGoodsWithType(GoodsType goodsType){
        GoodsExample ge = new GoodsExample();
        ge.createCriteria().andGoodsTypeIdEqualTo(goodsType.getId());
        return goodsMapper.selectByExample(ge);
    }
    //返回所有商品
    public List<Goods> findGoodsWithToptype(GoodsType goodstype){
        //根据一级类型查询所有所属二级类型
        List<GoodsType> gt = goodsTypeServicer.findSecondLevel(goodstype);
        //查询所有二级类型下的商品
        List<Goods> goodsList = new ArrayList<>();
        for (GoodsType goodsType : gt) {
            List<Goods> goodses = this.findGoodsWithType(goodsType);
            goodsList.addAll(goodses);

        }
        return goodsList;
    }
    //根据名称模糊搜索商品数据
    //返回符合条件的商品
    public List<Goods> searchGoodsWithName(String name){
        //构建条件
        GoodsExample ge = new GoodsExample();
        ge.createCriteria().andNameLike("%" + name + "%");
        return goodsMapper.selectByExample(ge);
    }


}
