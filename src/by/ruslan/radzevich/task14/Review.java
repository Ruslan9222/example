//package by.ruslan.radzevich.task14;
//
//public class Review {
//
//    @Slf4j
//    @Component
//    @RequiredArgsConstructor
//    public class KafkaMessageConsumer {
//
//        private final ObjectMapper objectMapper;
//        private final IncomingMessageRepository incomingMessageRepository;
//        private final KafkaTemplate<String, String> kafkaTemplate;
//
//        @KafkaListener(topics = "input-topic")
//        public void consume(String message) {
//            IncomingMessageContract incomingMessageContract =
//                    objectMapper.readValue(message, IncomingMessageContract.class);
//            if (incomingMessageContract.getType() != null &&
//                    incomingMessageContract.getCode() != null) {
//                log.info("Message received: " + incomingMessageContract.getMessageId());
//                boolean exists = checkIfMessageExists(incomingMessageContract.getMessageId());
//                if (!exists) {
//                    switch (incomingMessageContract.getType()) {
//                        case "CAD":
//                            proceedIncomingMessageOfTypeCAD(incomingMessageContract);
//                            break;
//                        case "UN":
//                            proceedIncomingMessageOfTypeUN(incomingMessageContract);
//                            break;
//                        default:
//                            log.error("Unexpected incoming message type: " +
//                                    incomingMessageContract.getType());
//                    }
//                    kafkaTemplate.send("output-topic",
//                            "Message processed: " +
//                                    incomingMessageContract.getMessageId());
//                } else {
//                    log.warn("Duplicate message: " + incomingMessageContract.getMessageId());
//                }
//            } else {
//                log.error("Invalid incoming message: " + message);
//            }
//        }
//}}
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class KafkaMessageConsumer {
//
//    private final ObjectMapper objectMapper;
//    private final IncomingMessageRepository incomingMessageRepository;
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    private final Map<String, Consumer<IncomingMessageContract>> handlers = Map.of(
//            "CAD", this::proceedIncomingMessageOfTypeCAD,
//            "UN", this::proceedIncomingMessageOfTypeUN
//    );
//
//    @KafkaListener(topics = "input-topic")
//    @Transactional
//    public void consume(String message) {
//        try {
//            IncomingMessageContract contract = objectMapper.readValue(message, IncomingMessageContract.class);
//
//            UUID messageId = contract.getMessageId();
//            String type = contract.getType();
//            Integer code = contract.getCode();
//
//            if (messageId == null || type == null || type.isBlank() || code == null) {
//                log.error("Invalid incoming message: {}", message);
//                return;
//            }
//
//            MDC.put("messageId", messageId.toString());
//            log.info("Received message: type={}, code={}", type, code);
//
//            if (incomingMessageRepository.existsByMessageId(messageId)) {
//                log.warn("Duplicate message: {}", messageId);
//                return;
//            }
//
//            Consumer<IncomingMessageContract> handler = handlers.get(type);
//            if (handler == null) {
//                log.error("Unexpected message type: {}", type);
//                return;
//            }
//
//            handler.accept(contract);
//
//            IncomingMessageEntity entity = IncomingMessageEntity.builder()
//                    .id(UUID.randomUUID())
//                    .messageId(messageId)
//                    .payload(message)
//                    .code(code)
//                    .type(type)
//                    .build();
//
//            incomingMessageRepository.save(entity);
//
//            kafkaTemplate.send("output-topic", "Message processed: " + messageId);
//            log.info("Message processed and sent to output-topic: {}", messageId);
//
//        } catch (JsonProcessingException e) {
//            log.error("Failed to deserialize message: {}", message, e);
//        } catch (Exception e) {
//            log.error("Unexpected error during message processing", e);
//        } finally {
//            MDC.clear();
//        }
//    }
//
//    private void proceedIncomingMessageOfTypeCAD(IncomingMessageContract contract) {
//        log.info("Processing CAD message: {}", contract.getMessageId());
//        // CAD-specific logic
//    }
//
//    private void proceedIncomingMessageOfTypeUN(IncomingMessageContract contract) {
//        log.info("Processing UN message: {}", contract.getMessageId());
//        // UN-specific logic
//    }
//}
