package com.shanda.xiaomi.controller;

import com.shanda.xiaomi.entry.Consumer;
import com.shanda.xiaomi.entry.Goods;
import com.shanda.xiaomi.entry.GoodsCart;
import com.shanda.xiaomi.service.GoodsShippingService;
import com.shanda.xiaomi.service.ShopCartService;
import com.shanda.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

//购物车操作控制器数据接口
@Controller
@RequestMapping("/shopcart")
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private GoodsShippingService goodsShippingService;

    @GetMapping("/add/{goodsId}")
    @ResponseBody
    public ResponseMessage addGoodsToCart(@PathVariable Integer goodsId, HttpSession session) {
        // 获取当前登录用户
        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
        if (consumer == null) {
            return ResponseMessage.error();
        }
        // 加入商品到购物车
        Goods goods = goodsShippingService.findGoodsWithId(goodsId);
        shopCartService.addGoodsToShopCart(consumer, goods);
        return ResponseMessage.success();
    }

//    @GetMapping("/remove/{goodsId}")
//    @ResponseBody
//    public ResponseMessage removeGoodsFromCart(@PathVariable Integer goodsId, HttpSession session) {
//        // 获取当前登录用户
//        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
//        if (consumer == null) {
//            return ResponseMessage.error();
//        }
//        Goods goods = goodsShippingService.findGoodsWithId(goodsId);
//        shopCartService.removeGoodsFromShopCart(consumer, goods);
//
//        return ResponseMessage.success();
//    }

    @GetMapping("/chk")
    @ResponseBody
    public ResponseMessage findAllWithConsumer(HttpSession session) {
        // 获取当前登录用户
        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
        if (consumer == null) {
            return ResponseMessage.error();
        }
        List<GoodsCart> cartList = shopCartService.findAllGoodsCartWithConsumer(consumer);
        return ResponseMessage.success().addObject("cartList", cartList);
    }
}
