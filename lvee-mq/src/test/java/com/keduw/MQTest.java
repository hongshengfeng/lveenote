package com.keduw;

import com.keduw.mq.RConsumer;
import com.keduw.mq.RProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MQApplication.class)
public class MQTest {

    private static final Logger logger = LoggerFactory.getLogger(MQTest.class);

    @Autowired
    private RProducer RProducer;

    @Autowired
    private RConsumer RConsumer;

    @Test
    public void main() {
        try {
            //send();
            //sendSync();
            //sendOneWay();
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void send() throws Exception{
        String info = "测试信息";
        String topic = "TOPIC_TEST";
        String tag = "*";
        Long startTime = System.currentTimeMillis();
        SendResult sendResult = RProducer.send(topic, tag, info);
        System.out.println(sendResult);
        System.out.println("耗费时间：" + (System.currentTimeMillis() - startTime));
    }

    public void sendSync() throws Exception{
        String info = "异步测试信息";
        String topic = "TOPIC_TEST";
        String tag = "*";
        Long startTime = System.currentTimeMillis();
        RProducer.sendSync(topic, tag, info);
        System.out.println("耗费时间：" + (System.currentTimeMillis() - startTime));
    }

    public void sendOneWay() throws Exception{
        String info = "异步测试信息";
        String topic = "TOPIC_TEST";
        String tag = "*";
        Long startTime = System.currentTimeMillis();
        RProducer.sendOneWay(topic, tag, info);
        System.out.println("耗费时间：" + (System.currentTimeMillis() - startTime));
    }


}
