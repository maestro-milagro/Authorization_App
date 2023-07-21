package com.example.demo.exeptions;

public class InvalidCredentials extends Throwable {
    public InvalidCredentials(String msg) {
        super(msg);
    }

}
