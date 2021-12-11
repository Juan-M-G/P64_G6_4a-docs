package com.grupo6.bill_ms.repositories;
import  com.grupo6.bill_ms.models.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BillRepository extends MongoRepository <Bill, Integer> { 
    List<Bill> findByUser (Integer userId);
}