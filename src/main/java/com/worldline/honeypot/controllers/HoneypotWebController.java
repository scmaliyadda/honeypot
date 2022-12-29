package com.worldline.honeypot.controllers;

import com.worldline.honeypot.services.HoneypotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * This controller class is to add apis for accepting client requests and act as a honeypot web service
 * @Author: Sujith
 * @Version: 1.0
 * @LastModified: 26-12-2022
 */
@RestController
@RequestMapping("/*")
@CrossOrigin
public class HoneypotWebController {
    @Autowired
    private HoneypotService honeypotService;

    /**
     * This method accept any get request
     * This is for server send event communication between server and client (uni-directional)
     *
     * @return text event stream
     */
    @GetMapping("")
    public Flux<ServerSentEvent<String>> streamEventsResponse() {
        return honeypotService.getStreamEvents();
    }

}
