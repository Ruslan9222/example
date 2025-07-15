//package by.ruslan.radzevich.task11;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.UUID;
//
//public record NewInsuranceMessageDto(
//        UUID propertyInsuranceId,
//        UUID addressId,
//        InsuranceStatus insuranceStatus,
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//        LocalDate startDate,
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//        LocalDate endDate,
//        PaymentFrequency paymentFrequency,
//        BigDecimal cost,
//        BigDecimal paymentSum
//)  implements KafkaMessageDto {
//
//    @Override
//    public String key() {
//        return propertyInsuranceId.toString();
//    }
//}
