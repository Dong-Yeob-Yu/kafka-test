package com.example.kafkatest.service

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
        val send: CompletableFuture<SendResult<String, String>> = kafkaTemplate.send(topic, message)

        try {
            val get = send.get()
            println("Message sent ${get.producerRecord}")
            kafkaTemplate.flush()
            return "success"
        } catch (e: Exception) {
            println("failed ${e.message}")
            return "failed to send message"
        }
    }
}