package com.example.kafka.examplekafka.consumer

import com.example.kafka.examplekafka.model.PessoaModel
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PessoaConsumer {

    @Value("\${topic.example}")
    private val topic: String? = null

    var log: Logger = Logger.getLogger(PessoaConsumer::class.java.name)

    @KafkaListener(topics = ["\${topic.example}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun getMessage(message: String) {

        val objectMapper = jacksonObjectMapper()

        var pessoa = objectMapper.readValue(message, PessoaModel::class.java)

        log.info("CONSUMINDO MSG: " + pessoa)
    }
}