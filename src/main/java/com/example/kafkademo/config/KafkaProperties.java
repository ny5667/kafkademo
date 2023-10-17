//package com.example.kafkademo.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@PropertySource("classpath:application.properties")
//@ConfigurationProperties
//public class KafkaProperties {
//
//    @Value("${kafka.bootstrap.servers}")
//    private String kafkaBootstrapServers;
//
//    @Value("${kafka.topic}")
//    private String kafkaTopic;
//
//    // 创建 getter 方法以访问配置属性的值
//
//    public String getKafkaBootstrapServers() {
//        return kafkaBootstrapServers;
//    }
//
//    public String getKafkaTopic() {
//        return kafkaTopic;
//    }
//}
