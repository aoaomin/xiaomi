package com.shanda.xiaomi.service;

import com.shanda.xiaomi.dao.ConsumerMapper;
import com.shanda.xiaomi.entry.Consumer;
import com.shanda.xiaomi.entry.ConsumerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    public Consumer findConsumerWithUsernameAndPassword(Consumer consumer){
        //创建一个条件对象
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo(consumer.getUsername())
                .andPasswordEqualTo(consumer.getPassword());
        //查询数据
        List<Consumer> consumerList = consumerMapper.selectByExample(ce);
        //判断返回结果
        return consumerList != null && consumerList.size() == 1 ? consumerList.get(0) : null;


    }
        public String register(Consumer consumer){
        //验证账号是否存在
            ConsumerExample ce = new ConsumerExample();
            ce.createCriteria().andUsernameEqualTo(consumer.getUsername());
            //根据条件对象查询数据
            List<Consumer> consumerList = consumerMapper.selectByExample(ce);
            if(consumerList !=null && consumerList.size() > 0){
                return "注册失败,账号已经存在,请在其他账户注册";
            }
            consumerMapper.insertSelective(consumer);
            return "注册成功";
        }

}
