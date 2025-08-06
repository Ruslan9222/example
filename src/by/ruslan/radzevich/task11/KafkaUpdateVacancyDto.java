//package by.ruslan.radzevich.task11;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//import java.util.UUID;
//
//public record KafkaUpdateVacancyDto(
//    String key,
//    String payload,
//    UUID vacancyId
//) implements KafkaMessageDto {
//    @Override
//    public String key() {
//        return key;
//    }
//}

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

//@Slf4j
//@Service
//@RequiredArgsConstructor
//@EnableConfigurationProperties(KafkaProperties.class)
//public class OutboxPublisherImpl implements OutboxPublisher {
//
//    public static final String BLOCK_CREATED_EVENT = "BLOCK_CREATED";
//    public static final String VACANCY_UPDATED_EVENT = "VACANCY_UPDATED";
//
//    private final OutboxEventRepository outboxEventRepository;
//    private final KafkaSender kafkaSender;
//    private final ObjectMapper mapper;
//
//
//    @Value("${mycare.kafka.producer.topicNames.block}")
//    private String blockTopic;
//
//    @Value("${mycare.kafka.producer.topicNames.update}")
//    private String updateTopic;
//
//    /**
//     * Периодически извлекает необработанные события из Outbox-таблицы и публикует их в Kafka.
//     * <p>
//     * Метод запускается каждые 35 секунд и выполняется в рамках транзакции. После успешной отправки
//     * события помечаются как обработанные и сохраняются в базу. В случае ошибки событие остаётся
//     * необработанным и будет повторно обработано при следующем запуске.
//     * </p>
//     *
//     * @throws KafkaException если возникает ошибка при отправке сообщения в Kafka
//     */
//
//    @Scheduled(fixedDelay = 35000)
//    @Transactional
//    @Override
//    public void publishOutboxEvents() {
//
//        List<OutboxEvent> events = outboxEventRepository.findByProcessedFalse();
//        if (events.isEmpty()) {
//            return;
//        }
//
//        for (OutboxEvent event : events) {
//            try {
//                switch (event.getEventType()) {
//                    case BLOCK_CREATED_EVENT:
//                    {
//                        sendBlockMessage(event);
//                    }
//                    case VACANCY_UPDATED_EVENT:
//                    {
//                        sendUpdateMessage(event);
//                    }
//                }
//
//                event.setProcessed(true);
//                event.setProcessedAt(LocalDateTime.now());
//                outboxEventRepository.saveAndFlush(event);
//
//            } catch (JsonProcessingException e) {
//                log.error("Ошибка сериализации JSON для события ID: {}", event.getId(), e);
//            } catch (KafkaException e) {
//                log.error("Ошибка отправки Kafka-сообщения для события ID: {}", event.getId(), e);
//            } catch (Exception e) {
//                log.error("Непредвиденная ошибка при обработке события ID: {}", event.getId(), e);
//            }
//
//        }
//    }
//
//    private void sendBlockMessage(OutboxEvent event) throws JsonProcessingException {
//        BlockResponseCreatedDto dto = mapper.readValue(
//                event.getEventPayload(), BlockResponseCreatedDto.class);
//
//        String serializedPayload = mapper.writeValueAsString(dto);
//
//        KafkaBlockUserDto kafkaMessage = new KafkaBlockUserDto(
//                event.getAggregateId().toString(),
//                serializedPayload,
//                dto.blockingPeriod(),
//                dto.operationDateTime(),
//                dto.userId(),
//                dto.blockStatus()
//        );
//
//        kafkaSender.sendSync(blockTopic, kafkaMessage);
//    }
//
//    private void sendUpdateMessage(OutboxEvent event) throws JsonProcessingException {
//        UpdateVacancyResponseDto dto = mapper.readValue(
//                event.getEventPayload(), UpdateVacancyResponseDto.class);
//
//        String serializedPayload = mapper.writeValueAsString(dto);
//
//        KafkaMessageDto kafkaMessage = new KafkaUpdateVacancyDto(
//                event.getAggregateId().toString(),
//                serializedPayload,
//                dto.vacancyId()
//        );
//
//        kafkaSender.sendSync(updateTopic, kafkaMessage);
//    }
//
//
//}
//


//@Override
//@Transactional
//public UpdateVacancyResponseDto updateVacancy(UUID vacancyId, UpdateVacancyRequestDto dto) {
//    Vacancy existingVacancy = vacancyRepository.findById(vacancyId)
//            .orElseThrow(() -> new NotFoundException("Vacancy not found"));
//
//    vacancyMapper.updateVacancyDtoToVacancy(dto, existingVacancy);
//    Vacancy updatedVacancy = vacancyRepository.save(existingVacancy);
//
//    Optional.ofNullable(dto.updateVacancyToOfficeRequestDto())
//            .ifPresent(officeDto -> {
//                UUID officeId = existingVacancy.getOffice().getOfficeId();
//                Office existingOffice = officeRepository.findById(officeId)
//                        .orElseThrow(() -> new NotFoundException("Office not found"));
//
//                if (officeDto.officeName() != null) {
//                    existingOffice.setOfficeName(officeDto.officeName());
//                }
//
//                officeRepository.save(existingOffice);
//            });
//
//    Optional.ofNullable(dto.updateVacancyToContactRequestDto())
//            .ifPresent(contactDto -> {
//                UUID contactId = existingVacancy.getContact().getContactId();
//                Contact existingContact = contactRepository.findById(contactId)
//                        .orElseThrow(() -> new NotFoundException("Contact not found"));
//
//                if (contactDto.lastName() != null) {
//                    existingContact.setLastName(contactDto.lastName());
//                }
//
//                contactRepository.save(existingContact);
//            });
//
//    UpdateVacancyResponseDto response = new UpdateVacancyResponseDto(
//            vacancyRepository.save(updatedVacancy).getVacancyId());
//
//    String payload;
//
//    try {
//        payload = mapper.writeValueAsString(response);
//    } catch (JsonProcessingException e) {
//        log.error("Ошибка сериализации UpdateVacancyResponseDto: {}", e.getMessage());
//        throw new RuntimeException("Ошибка сериализации", e); // или кастомное исключение
//    }
//
//    OutboxEvent event = OutboxEvent.builder()
//            .aggregateId(response.vacancyId())
//            .aggregateType("VACANCY")
//            .eventType("VACANCY_UPDATED")
//            .eventPayload(payload)
//            .createdAt(LocalDateTime.now())
//            .processed(false)
//            .build();
//
//    outboxEventRepository.save(event);
//
//    return response;
//}