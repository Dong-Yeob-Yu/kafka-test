package com.example.kafkatest.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(topic:String, message:String) {
        kafkaTemplate.send(topic, message)
        println("Message sent to $topic : $message")
    }
}