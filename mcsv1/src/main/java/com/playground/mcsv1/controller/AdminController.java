package com.playground.mcsv1.controller;

import brave.Tracer;
import com.playground.mcsv1.controller.client.ExtClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/v1.0/admin")
public class AdminController {

    private final static String TOPIC = "mcsv";

    @Autowired
    private Tracer tracer;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ExtClient extClient;

    @GetMapping(path = "/test")
    public String test(){


        log.info("req received");
        printTrace();

        String body = extClient.test();
        log.info("from extClient: [{}]", body);

        String traceId = "traceId: " + tracer.currentSpan().context().traceIdString();
        kafkaTemplate.send(TOPIC,traceId);

        return tracer.toString() + "<----------> from extClient: " + body;
    }

    private void printTrace () {
        String traceId = tracer.currentSpan().context().traceIdString();
        String spanId = tracer.currentSpan().context().spanIdString();
        log.info("--- Tracer ---  traceId: {} & spanId: {}", traceId, spanId);
    }
}
