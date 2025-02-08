package com.example.kafkatest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Message(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val message: String,
) {

    init {
        if(message.isBlank()) {
            throw IllegalArgumentException("Message cannot be blank")
        }
    }
}