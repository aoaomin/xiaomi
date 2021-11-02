package com.shanda.xiaomi.controller;
//辅助工具控制器


import com.shanda.xiaomi.entry.Goods;
import com.shanda.xiaomi.entry.GoodsType;
import com.shanda.xiaomi.service.GoodsShippingService;
import com.shanda.xiaomi.service.GoodsTypeService;
import com.shanda.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/u")
public class UtilsController {
    @Autowired
    private GoodsShippingService goodsShippingService;
    @Autowired
    private GoodsTypeService goodsTypeService;
    @GetMapping("/search/{name}")
    @ResponseBody
    public ResponseMessage searchGoodsWithName(@PathVariable String name){
        List<Goods> goodsList = goodsShippingService.searchGoodsWithName(name);
        return goodsList.size() >0 ? ResponseMessage.success().addObject("goodsList",goodsList)
                                    : ResponseMessage.error();
    }
//    level 类型级别1 一级类型 2 二级类型
//    goodsTypeId 类型编号
    @GetMapping("/search/{level}/{goodsTypeId}")
    @ResponseBody
    public ResponseMessage searchGoodsWithType(@PathVariable String level,
                                               @PathVariable String goodsTypeId){
        //根据编号查询类型
        GoodsType goodsType = goodsTypeService.findById(Integer.parseInt(goodsTypeId));
        List<Goods> goodsList = null;
        //判断级别
        if("1".equals(level)){
            goodsList = goodsShippingService.findGoodsWithToptype(goodsType);
        }else if("2".equals(level)){
            goodsList = goodsShippingService.findGoodsWithType(goodsType);
        }
        return goodsList != null && goodsList.size() > 0
                ? ResponseMessage.success().addObject("goodsList",goodsList)
                : ResponseMessage.error();
    }
}
