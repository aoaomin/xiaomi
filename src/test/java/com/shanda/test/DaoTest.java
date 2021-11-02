//package com.shanda.test;
//
//import com.shanda.xiaomi.dao.ConsumerMapper;
//import com.shanda.xiaomi.entry.Consumer;
//import com.shanda.xiaomi.entry.ConsumerExample;
//import com.shanda.xiaomi.entry.Goods;
//import com.shanda.xiaomi.service.GoodsShippingService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
////单元测试
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//public class DaoTest {
//    @Autowired
//    private ConsumerMapper consumerMapper;
//    @Test
//    public void testConsumerInsert(){
//        //创建一个consumer对象
//        Consumer consumer = new Consumer("zhangao","123");
//        //将consumer对象增加到数据库中
//        consumerMapper.insertSelective(consumer);
//        System.out.println("执行完成");
//    }
//    @Test
//    public void testConsumerSelectById(){
//        Consumer consumer = consumerMapper.selectByPrimaryKey(1);
//        System.out.println(consumer);
//    }
//    @Test
//    public void testConsumerSelectByExample(){
//        //创建一个查询条件 name pass
//        ConsumerExample ce = new ConsumerExample();
//        ce.createCriteria().andUsernameEqualTo("zhangao")
//                .andPasswordEqualTo("123");
//        //查询数据
//        List<Consumer> consumers = consumerMapper.selectByExample(ce);
//        consumers.forEach(consumer -> System.out.println(consumer));
//    }
//    @Autowired
//    private GoodsShippingService goodsShippingService;
//    @Test
//    public void testSearchGoods(){
//        List<Goods> goodsList = goodsShippingService.searchGoodsWithName("小米");
//        goodsList.forEach(goods -> System.out.println(goods));
//
//    }
//
//}
