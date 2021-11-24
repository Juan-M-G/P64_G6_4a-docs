package com.grupo6.bill_ms.repositories;
import com.grupo6.bill_ms.models.Bill_Pro;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface Bill_proRepository extends MongoRepository<Bill_Pro, Integer> {
    //List<Transaction> findByUsernameOrigin (String usernameOrigin);
    //List<Transaction> findByUsernameDestiny (String usernameDestiny);
}