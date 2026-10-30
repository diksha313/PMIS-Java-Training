package com.quickrelief.demo1.service;

import com.quickrelief.demo1.SupplyRequest;
import com.quickrelief.demo1.repository.RequestRepository;
import com.quickrelief.demo1.repository.SupplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestService {

    private final RequestRepository requestRepository;
    private final SupplyRepository supplyRepository;

    public RequestService(
            RequestRepository requestRepository,
            SupplyRepository supplyRepository) {
        this.requestRepository = requestRepository;
        this.supplyRepository = supplyRepository;
    }
    @Transactional
    public String processRequest(SupplyRequest request) {

        if (request.getItemName() == null ||
                request.getItemName().isBlank()) {
            throw new IllegalArgumentException("Item name is required");
        }

        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (request.getRequestedBy() == null ||
                request.getRequestedBy().isBlank()) {
            throw new IllegalArgumentException("Requester name is required");
        }

        int available = supplyRepository.getAvailableQuantity(
                request.getItemName());

        if (available < request.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock available");
        }

        int updated = supplyRepository.deductStock(
                request.getItemName(),
                request.getQuantity());

        if (updated == 0) {
            throw new IllegalArgumentException("Insufficient stock available");
        }

        request.setStatus("APPROVED");
        requestRepository.saveRequest(request);

        return "Request approved successfully";
    }
    public java.util.List<SupplyRequest> getAllRequests() {
        return requestRepository.findAllRequests();
    }
}
