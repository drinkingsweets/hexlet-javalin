package org.example.hexlet;

import lombok.Getter;
import lombok.Setter;


public class Flash {
    private static String message;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String newMessage) {
        message = newMessage;
    }
}
