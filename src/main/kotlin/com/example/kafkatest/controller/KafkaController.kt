package com.example.kafkatest.controller

import com.example.kafkatest.service.KafkaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaController(
    private val kafkaService: KafkaService
) {

    @GetMapping("/send")
    fun sendMessage(@RequestParam message: String) {
        kafkaService.sendMessage("test-topic", message)
    }
}