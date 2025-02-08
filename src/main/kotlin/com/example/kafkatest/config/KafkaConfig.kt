package com.example.kafkatest.config

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.*
import java.io.Serializable

@Configuration
class KafkaConfig {

    // 생산자 설정
    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val configProps: Map<String, Serializable> = mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "kafka:9092",                    // 카프카 서버 주소
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
        )

        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val configProps: Map<String, Serializable> = mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "kafka:9092",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        )

        return DefaultKafkaConsumerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }

    @Bean
    fun createTopic(): NewTopic {
        return NewTopic("test-topic", 1, 1)
    }
}