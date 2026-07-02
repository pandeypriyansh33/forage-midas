package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core-group")
    public void listen(Transaction transaction) {
        // This method automatically prints out the transaction details whenever a message arrives
        System.out.println("Processing transaction: Sender=" + transaction.getSenderId() + 
                           ", Receiver=" + transaction.getReceiverId() + 
                           ", Amount=" + transaction.getAmount());
    }
}
