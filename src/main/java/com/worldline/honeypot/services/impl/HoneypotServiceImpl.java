package com.worldline.honeypot.services.impl;

import com.worldline.honeypot.services.HoneypotService;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * This is service implementation for honeypot web service apis
 * @Author: Sujith
 * @Version: 1.0
 * @LastModified: 26-12-2022
 */
@Service
public class HoneypotServiceImpl implements HoneypotService {
    private final String responseTxt = "Not Found";

    /**
     * Build server sent event using given response text with 5 seconds duration
     *
     * @return text event stream
     */
    @Override
    public Flux<ServerSentEvent<String>> getStreamEvents() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(sequence -> ServerSentEvent.<String>builder()
                        .data(responseTxt)
                        .build());
    }
}
