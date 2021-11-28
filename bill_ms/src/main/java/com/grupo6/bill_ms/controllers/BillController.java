package com.grupo6.bill_ms.controllers;
import com.grupo6.bill_ms.exceptions.BillNotFoundException;
import com.grupo6.bill_ms.models.Bill;
import com.grupo6.bill_ms.repositories.BillRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BillController {
    private final BillRepository billRepository;
    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }
    @GetMapping("/bill/{id}")
    Bill getBill(@PathVariable Integer id){
        return billRepository.findById(id).orElseThrow(() -> new BillNotFoundException("No se encontró una factura con el número: " + id));
    }
    @GetMapping("/bills")
    List<Bill> Bills(){
        return billRepository.findAll();
    }
    @PostMapping("/bills")
    Bill newBill(@RequestBody Bill bill){
        return billRepository.save(bill);
    }
}