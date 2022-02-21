package com.example.kafka.examplekafka.producer

import com.example.kafka.examplekafka.model.PessoaModel
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Logger

@Service
class PessoaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Value("\${topic.example}")
    private val topic: String? = null

    var log: Logger = Logger.getLogger(PessoaProducer::class.java.name)

    fun sendMessage() {

        val objectMapper = jacksonObjectMapper()

        val randomName = generateRandomString()

        var pessoa = PessoaModel(Random().nextInt(), randomName, "$randomName@gmail.com")

        val message = objectMapper.writeValueAsString(pessoa)

        log.info("ENVIANDO MSG: " + message)
        kafkaTemplate.send(topic!!, message)
    }

    fun generateRandomString(): String {
        val leftLimit = 97

        val rightLimit = 122

        val targetStringLength = 10
        val random = Random()

        return random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength.toLong())
            .collect({ StringBuilder() }, java.lang.StringBuilder::appendCodePoint, java.lang.StringBuilder::append)
            .toString()
    }
}