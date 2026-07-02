package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.repository.UserRepository;
import com.jpmc.midascore.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    // This connects our web window directly to our data storage files
    public ApiController(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    // Web Window 1: Look up a user's balance by their ID
    @GetMapping("/balance")
    public float getBalance(@RequestParam Long userId) {
        Optional<UserRecord> user = userRepository.findById(userId);
        return user.map(UserRecord::getBalance).orElse(0.0f);
    }

    // Web Window 2: Look up a specific transaction record details by its ID
    @GetMapping("/transaction")
    public TransactionRecord getTransaction(@RequestParam Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }
}
