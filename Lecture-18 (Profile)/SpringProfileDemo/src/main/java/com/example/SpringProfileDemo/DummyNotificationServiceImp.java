package com.example.SpringProfileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default", "staging"})
public class DummyNotificationServiceImp implements NotificationService{

    @Override
    public String send(){

        // Dummy notification is sent
        return "Here is a dummy notification";
    }
}
