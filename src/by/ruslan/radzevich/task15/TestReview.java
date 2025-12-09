//package by.ruslan.radzevich.task15;
//
//public class TestReview {
//    /**
//     * Платежный сервис.
//     * Плательщик (Payer) переводит деньги (в т.ч. в валюте) получателю платежа (Payee).
//     * Если плательщик имеет статус VIP в нашей системе, то дополнительная комиссия с него не взымается.
//     * Если платеж не имеет статус VIP то в зависимости от того, является он юрлицом (business) или физическим (private),
//     * взымается различная комиссия.
//     * Плательщики, осуществляющие платеж на сумму свыше 2 тысяч рублей приглашаются посетить представление (концерт)
//     * музыкального исполнителя. Выбор ряда и места в зале осуществлено на этапе
//     * формирования платежа.
//     *
//     */
//
//    @Service
//    public class PaymentService {
//
//        @Autowired private ClientRepository clientRepository;
//        @Autowired private DirectionClient directionClient;
//        @Autowired private BaseMapper baseMapper;
//        @Autowired private TaxesMapper taxesMapper;
//        @Autowired private CustomsMapper customsMapper;
//        @Autowired private CbClient cbClient;
//        @Autowired private CommissionService commissionService;
//        @Autowired private PaymentRepository paymentRepository;
//        @Autowired private PerformanceBookRepository performanceBookRepository;
//        @Autowired private OnlinePaymentServiceClient onlinePaymentServiceClient;
//
//        /**
//         * Исполнение платежа.
//         * @param dto - платежные данные
//         */
//        @Transactional
//        public void execute(PaymentDto dto) {
//            var payee = clientRepository.findById(dto.getPayee());
//            // с ВИП клиентов не взимается дополнительная комиссия
//            var commission = 0d;
//            if (!payee.get().getClientType().startsWith("VIP")) {
//                String clientSubType = payee.get().getClientType().getSubType();
//                // юрлица
//                if (clientSubType == "BUSINESS") {
//                    commission = 0.02d;
//                    // физлица
//                } else if (clientSubType == "PRIVATE") {
//                    commission = 0.01d;
//                }
//            }
//
//            Payment payment = paymentMapper.map(dto);
//            var sumInRub = dto.getSum();
//            if (dto.getCurrency() != "RUB") {
//                // обращение к ЦБ за курсом
//                var rate = cbClient.getExchangeRate(dto.getCurrency());
//                sumInRub = dto.getSum() * rate;
//            }
//
//            payment.setSum(sumInRub - commission);
//            paymentRepository.save(payment);
//            // выбор места на концерт
//            if (sumInRub > 2000) {
//                short row = dto.getAdditionalInfo().getRow();
//                short seatNumber = dto.getAdditionalInfo().getSeatNumber();
//                Long paymentId = payment.getId();
//                Long payerId = payment.getPayer().getId();
//                var performanceBook = new PerformanceBook(row, seatNumber, paymentId, payerId);
//                performanceBookRepository.save(performanceBook);
//            }
//            // отправка в OPS данных для платежа (он фактически изменяет баланс счета)
//            onlinePaymentServiceClient.enroll(payment);
//            System.out.println("Платеж успешно зачислен.");
//        }
//    }
//
//    @Data
//    @Table("performance_book")
//    public class PerformanceBook {
//
//        @Column
//        private Short row;
//        @Column
//        private Short seatNumber;
//        @Column
//        private Long paymentId;
//        @Column
//        private Long userId;
//    }
//
//}
