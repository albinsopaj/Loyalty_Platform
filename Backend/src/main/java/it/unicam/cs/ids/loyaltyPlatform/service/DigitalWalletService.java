package it.unicam.cs.ids.loyaltyPlatform.service;

import it.unicam.cs.ids.loyaltyPlatform.repository.DigitalWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DigitalWalletService {

    @Autowired
    private DigitalWalletRepository repository;

}
