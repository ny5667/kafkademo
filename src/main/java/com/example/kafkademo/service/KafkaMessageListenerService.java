package com.example.kafkademo.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Properties;

@Service
public class KafkaMessageListenerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessageListenerService.class);

    @Value("${kafka.bootstrap.servers}")
    private String KAFKA_BOOTSTRAP_SERVERS;

    @Value("${kafka.topic}")
    private String KAFKA_TOPIC;

    public void run() {

        // 设置Kafka消费者配置
        Properties props = new Properties();
        props.put("bootstrap.servers", KAFKA_BOOTSTRAP_SERVERS); // Kafka服务器地址和端口
        props.put("group.id", "my-consumer-group"); // 消费者组ID
        props.put("key.deserializer", StringDeserializer.class.getName()); // 键的反序列化器
        props.put("value.deserializer", StringDeserializer.class.getName()); // 值的反序列化器

        // 创建Kafka消费者
        Consumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅消息主题
        consumer.subscribe(Collections.singleton(KAFKA_TOPIC));

        // 持续监听消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100); // 轮询获取消息，超时时间为100毫秒

            // 处理接收到的消息
            for (ConsumerRecord<String, String> record : records) {
                String key = record.key();
                String value = record.value();

                // 在这里执行你想要的操作，如打印、处理等
                System.out.println("Received message: key=" + key + ", value=" + value);
                log.error("Received message: key={}, value={}", key, value);
            }
        }
    }
}
