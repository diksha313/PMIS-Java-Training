
package com.quickrelief.demo1.controller;

import com.quickrelief.demo1.Supply;
import com.quickrelief.demo1.service.SupplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

    @RestController
    @RequestMapping("/api/supplies")
    public class SupplyController {

        private final SupplyService supplyService;

        @PostMapping
        public String addSupply(@RequestBody Supply supply) {
            supplyService.addOrRestock(supply);
            return "Supply added or restocked successfully";
        }

        public SupplyController(SupplyService supplyService) {
            this.supplyService = supplyService;
        }

        @GetMapping
        public List<Supply> getAllSupplies() {
            return supplyService.getAllSupplies();
        }
    }


