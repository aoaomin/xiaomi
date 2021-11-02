package com.shanda.xiaomi.service;

import com.shanda.xiaomi.dao.GoodsCartMapper;
import com.shanda.xiaomi.entry.Consumer;
import com.shanda.xiaomi.entry.Goods;
import com.shanda.xiaomi.entry.GoodsCart;
import com.shanda.xiaomi.entry.GoodsCartExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//购物车
@Service
public class ShopCartService {
    @Autowired
    private GoodsCartMapper goodsCartMapper;
    //指定商品加入购物车
    public boolean addGoodsToShopCart(Consumer consumer, Goods goods){
        //查询指定的商品在当前用户的购物车是否存在
       List<GoodsCart> cartList = this.chkGoods(consumer,goods);
        if(cartList.size() > 0){
            int count = cartList.get(0).getBuyCount();
            cartList.get(0).setBuyCount(count+1);
            //更新小金额
            double price = cartList.get(0).getSubtotal() / count * cartList.get(0).getBuyCount();
            cartList.get(0).setSubtotal(price);
            goodsCartMapper.updateByPrimaryKey(cartList.get(0));

        }else {
            //新增商品
            //需要的属性Integer goodsId, Integer buyCount, Date addDate, Double subtotal, Integer consumerId
            GoodsCart gc = new GoodsCart(goods.getId(),1,new Date(),goods.getPrice(),consumer.getId());
            goodsCartMapper.insertSelective(gc);
        }
        return false;

    }
    //从购物车中删除指定商品
    public boolean removeGoodsFromShopCart(Consumer consumer,Goods goods){
        //判断商品在购物车中是否存在
        List<GoodsCart> cartList = this.chkGoods(consumer,goods);
        if(cartList.size()>0){
            //商品存在,删除
            goodsCartMapper.deleteByPrimaryKey(cartList.get(0).getId());
            return true;
        }
        System.out.println("商品不存在");
        return false;
    }
    //查询指定用户购物车中所有商品
    public List<GoodsCart> findAllGoodsCartWithConsumer(Consumer consumer){
        GoodsCartExample gce = new GoodsCartExample();
        gce.createCriteria().andConsumerIdEqualTo(consumer.getId());
        return goodsCartMapper.selectByExample(gce);
    }
    //判断某个商品在购物车是否存在
    //consumer 用户
    //goods 商品
    private List<GoodsCart> chkGoods(Consumer consumer,Goods goods){
        //查询指定的商品在当前用户的购物车是否存在
        GoodsCartExample gce = new GoodsCartExample();
        gce.createCriteria().andConsumerIdEqualTo(consumer.getId())
                .andGoodsIdEqualTo(goods.getId());
        //查询操作
        List<GoodsCart> cartList = goodsCartMapper.selectByExample(gce);
        return cartList;
    }
}
