# kafka-example

## 1- Executar o arquivo docker compose no diretório /docker:

```sudo docker-compose -f kafka_kafkadrop_zookeeper.yml up```

   1.1 - Kafka Drop: `http://localhost:19000`

## 2- Start da aplicação Spring Boot

  `Run ExampleKafkaApplication`
  
#### Após Start da aplicação serão enviados 10000 msgs para o tópico `topic_example`. e consequentemente serão consumidos

