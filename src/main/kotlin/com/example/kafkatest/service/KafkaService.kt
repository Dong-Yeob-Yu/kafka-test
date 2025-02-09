package com.example.kafkatest.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(topic:String, message:String): String {
        kafkaTemplate.send(topic, message)

        return message
    }

    @KafkaListener(topics = ["\${kafka.consumer.topic}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun listen(message: String) {
        println("Received message: $message")
    }
}