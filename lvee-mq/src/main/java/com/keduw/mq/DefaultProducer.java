package com.keduw.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DefaultProducer {

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
}
