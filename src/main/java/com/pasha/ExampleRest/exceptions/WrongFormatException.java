package com.pasha.ExampleRest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongFormatException extends RuntimeException {
    public WrongFormatException(String message) {
        super((message != null && !message.trim().isEmpty()) ? "Wrong format of " + message : "");
    }

    public WrongFormatException() {
        this("");
    }
}
