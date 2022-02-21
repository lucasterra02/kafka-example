package com.example.kafka.examplekafka

import com.example.kafka.examplekafka.consumer.PessoaConsumer
import com.example.kafka.examplekafka.producer.PessoaProducer
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import java.util.logging.Logger

@Configuration
class ExampleKafkaCommandLine(
    private val pessoaProducer: PessoaProducer
) : CommandLineRunner {

    var log: Logger = Logger.getLogger(ExampleKafkaCommandLine::class.java.name)

    override fun run(vararg args: String?) {
        var x = 0
        while (x < 10000) {
            pessoaProducer.sendMessage();
            x++
        }
    }
}