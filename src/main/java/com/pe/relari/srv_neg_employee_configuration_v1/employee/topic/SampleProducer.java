package com.pe.relari.srv_neg_employee_configuration_v1.employee.topic;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JsonConverter;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.Utility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
@AllArgsConstructor
public class SampleProducer {

    public static final String TOPIC = "employee_topic";

    private KafkaSender<Integer, String> sender;

    public Mono<Void> sendMessages(Employee employee) {
        return sender.send(
                Mono.fromCallable(() -> SenderRecord.create(
                        new ProducerRecord<>(
                                TOPIC, employee.getIdEmployee(),
                                JsonConverter.convertJsonString(employee)
                        ),
                        employee.getIdEmployee())
                ))
                .doOnError(e -> log.error("Send failed", e))
                .doOnNext(r -> {
                    var metadata = r.recordMetadata();
                    log.debug("Message {} sent successfully, topic={} partition={} offset={} timestamp={}",
                            r.correlationMetadata(),
                            metadata.topic(),
                            metadata.partition(),
                            metadata.offset(),
                            Utility.buildDate(metadata.timestamp()));
                    new CountDownLatch(employee.getIdEmployee()).countDown();
                })
                .ignoreElements()
                .then();
    }

    public void close() {
        sender.close();
    }
}
