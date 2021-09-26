package com.hqz.hqzrocketmq.base.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author hqz
 * @date 2021/9/26
 * 发送同步消息
 */
public class SyncProducer {
    public static void main(String[] args) {
        try {
            DefaultMQProducer defaultMQProducer = new DefaultMQProducer("Hqz-Test");
            defaultMQProducer.setNamesrvAddr("192.168.170.146:9876;192.168.170.147:9876");
            defaultMQProducer.start();
            for(int i=0; i<10; i++) {
                Message message = new Message("TopicTest", "TagA", ("Hello RocketMQ:" + i).getBytes());
                SendResult sendResult = defaultMQProducer.send(message);
                System.out.printf("%s%n", sendResult);
            }
            defaultMQProducer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
