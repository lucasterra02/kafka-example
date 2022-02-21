package com.example.kafka.examplekafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class ExampleKafkaApplication

fun main(args: Array<String>) {
	runApplication<ExampleKafkaApplication>(*args)
}
