package com.keduw.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@Component
public class RProducer {

    private static final Logger logger = LoggerFactory.getLogger(RProducer.class);

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.retryTimesWhenSendFailed:3}")
    private int retryTimesWhenSendFailed;

    private DefaultMQProducer producer;

    @PostConstruct
    private void init() throws MQClientException {
        producer = new DefaultMQProducer("g_test");
        producer.setNamesrvAddr(namesrvAddr);
        producer.setUnitName("g_test");
        producer.setSendLatencyFaultEnable(true);
        producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);
        producer.setSendMsgTimeout(60000);
        producer.start();
    }

    @PreDestroy
    public void shutdown(){
        if(producer != null){
            producer.shutdown();
        }
    }

    /**
     * 同步发送消息
     * @return
     * @throws Exception
     */
    public SendResult send(String topic, String tag, String info) throws Exception {
        boolean failed = false;
        do {
            try {
                Message message = new Message(topic, tag, info.getBytes());
                return producer.send(message);
            }catch (Exception e){
                failed = true;
                logger.error("send err", e);
                TimeUnit.SECONDS.sleep(3);
            }
        }while (failed);
        return null;
    }

    /**
     * 异步发送消息
     * @throws Exception
     */
    public void sendSync(String topic, String tag, String info) throws Exception{
        Message message = new Message(topic, tag, info.getBytes());
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {}

            @Override
            public void onException(Throwable e) {}
        });
    }

    /**
     * 单向发送消息
     * @throws Exception
     */
    public void sendOneWay(String topic, String tag, String info) throws Exception{
        Message message = new Message(topic, tag, info.getBytes());
        producer.sendOneway(message);
    }

}
