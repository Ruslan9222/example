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

//@ExtendWith(MockitoExtension.class)
//class KafkaServiceImplTest {
//
//    @Mock
//    private KafkaSender sender;
//
//    @Mock
//    private KafkaProperties properties;
//
//    @Mock
//    private KafkaProperties.Producer producer;
//
//    private KafkaServiceImpl kafkaService;
//
//    @BeforeEach
//    void setup() {
//        kafkaService = new KafkaServiceImpl(sender, properties);
//    }
//
//    @Test
//    void send_ShouldSendMessageToCorrectTopic() {
//        // Arrange
//        NewInsuranceMessageDto message = new NewInsuranceMessageDto(
//                UUID.randomUUID(),
//                UUID.randomUUID(),
//                InsuranceStatus.APPROVED,
//                LocalDate.of(2025, 1, 1),
//                LocalDate.of(2026, 1, 1),
//                PaymentFrequency.ONCE_IN_MONTH,
//                new BigDecimal("5000.00"),
//                new BigDecimal("416.67")
//        );
//
//        when(properties.getProducer()).thenReturn(producer);
//        when(producer.getTopicNames()).thenReturn(
//                Map.of("property-insurance-created", "test-topic"));
//
//        // Act
//        kafkaService.send(message);
//
//        // Assert
//        verify(sender).sendAsync("test-topic", message);
//    }