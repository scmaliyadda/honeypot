package com.worldline.honeypot.services;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * This is service interface for honeypot web service apis
 * @Author: Sujith
 * @Version: 1.0
 * @LastModified: 26-12-2022
 */
@Service
public interface HoneypotService {
    Flux<ServerSentEvent<String>> getStreamEvents();
}
