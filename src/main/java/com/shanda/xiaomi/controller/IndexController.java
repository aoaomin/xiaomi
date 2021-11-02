package com.shanda.xiaomi.controller;

import com.shanda.xiaomi.entry.Goods;
import com.shanda.xiaomi.entry.GoodsType;
import com.shanda.xiaomi.service.GoodsShippingService;
import com.shanda.xiaomi.service.GoodsTypeService;
import com.shanda.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//首页相关处理接口
@Controller
public class IndexController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsShippingService goodsShippingService;

    @GetMapping("/initIndex")
    @ResponseBody
    public ResponseMessage initIndex() {
        //查询一级商品类型数据
        List<GoodsType> topLevel = goodsTypeService.findTopLevel();
        Map<Integer, List<Goods>> goodsMap = new HashMap<>();
        //遍历查询每个一级类型下的二级类型,按照二级类型:商品类型
        for(GoodsType goodsType: topLevel){
            //查询所属一级类型下的所有二级类型
            List<GoodsType> secondLevel = goodsTypeService.findSecondLevel(goodsType);
            //查询每个二级类型下的商品
            for(GoodsType secondGoodsType: secondLevel) {
                //查询商品
                List<Goods> goodsList = goodsShippingService.findGoodsWithType(secondGoodsType);
                //存储数据
                goodsMap.put(secondGoodsType.getId(),goodsList);
            }
        }
        //返回首页需要的数据
        return ResponseMessage.success()
                .addObject("goodsTypeList",topLevel)
                .addObject("goodsMap",goodsMap);
    }
}
