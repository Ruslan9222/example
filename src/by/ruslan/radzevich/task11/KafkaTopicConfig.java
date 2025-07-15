//package by.ruslan.radzevich.task11;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class KafkaTopicConfig {
//
//    private final KafkaProperties properties;
//
//    @Bean
//    public KafkaAdmin.NewTopics topics() {
//        return new KafkaAdmin.NewTopics(
//                properties.getProducer().getTopicNames().values().stream()
//                        .map(topicName -> TopicBuilder
//                                .name(topicName)
//                                .partitions(1)
//                                .replicas(1)
//                                .build())
//                        .toArray(NewTopic[]::new)
//        );
//    }
//}
