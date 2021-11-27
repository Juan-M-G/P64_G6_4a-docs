package com.grupo6.bill_ms.controllers;
import com.grupo6.bill_ms.models.Bill_Pro;
import com.grupo6.bill_ms.repositories.Bill_proRepository;
import org.springframework.web.bind.annotation.*;
@RestController
public class Bill_ProController {
    private final Bill_proRepository bill_proRepository;
    public Bill_ProController(Bill_proRepository bill_proRepository) {
        this.bill_proRepository = bill_proRepository;
    }
    @PostMapping("/bill_pro")
    Bill_Pro newBill_pro(@RequestBody Bill_Pro bill_pro){
        return bill_proRepository.save(bill_pro);
    }
}