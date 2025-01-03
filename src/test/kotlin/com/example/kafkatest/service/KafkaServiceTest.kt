package com.example.kafkatest.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaServiceTest(
    @Autowired private val kafkaService: KafkaService
){

//    @DisplayName("토픽에 메시지를 보낸다.")
//    @Test
//    fun kafkaTopicSendMessageTest() {
//        kafkaService.sendMessage("test-topic", "second message")
//    }
}