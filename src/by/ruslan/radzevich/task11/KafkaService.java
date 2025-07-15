//package by.ruslan.radzevich.task11;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class  KafkaService {
//
//
//    private final KafkaSender sender;
//    private final KafkaProperties properties;
//
//    /**
//     * Отправка сообщения о блокировке пользователя в топик property-insurance-created.
//     *
//     * @param message исходящее Дто
//     */
//
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    public void send(NewInsuranceMessageDto message) {
//        String topicName = properties.getProducer().getTopicNames()
//                .get("property-insurance-created");
//        sender.sendAsync(topicName, message);
//    }
//
//}
//private final ApplicationEventPublisher eventPublisher;

//        eventPublisher.publishEvent(propertyInsuranceMapper
//            .toNewInsuranceMessageDto(apartmentInsuranceProcessDto.getPropertyInsurance()));

//    @Mapping(target = "addressId", source = "address.addressId")
//    NewInsuranceMessageDto toNewInsuranceMessageDto(PropertyInsuranceDto insurance);