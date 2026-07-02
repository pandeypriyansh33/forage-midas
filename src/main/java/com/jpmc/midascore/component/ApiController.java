package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserRepository userRepository;

    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/balance")
    public Balance getBalance(@RequestParam Long userId) {
        Optional<UserRecord> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            return new Balance(userOpt.get().getBalance());
        }
        return new Balance(0.0f);
    }
}
