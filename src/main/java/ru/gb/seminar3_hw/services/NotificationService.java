package ru.gb.seminar3_hw.services;

import org.springframework.stereotype.Service;
import ru.gb.seminar3_hw.domain.User;

@Service
public class NotificationService {

    public String notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
        return "A new user has been created: " + user.getName();
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}