package com.quickrelief.demo1.controller;

import com.quickrelief.demo1.SupplyRequest;
import com.quickrelief.demo1.service.RequestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public String createRequest(@RequestBody SupplyRequest request) {
        return requestService.processRequest(request);
    }
    @GetMapping
    public List<SupplyRequest> getAllRequests() {
        return requestService.getAllRequests();
    }
}