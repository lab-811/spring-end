package org.example.Islambek.exception;

public class IncorrectIdException extends ArithmeticException{

    public IncorrectIdException() {
        super("Incorrect id");
    }

    public IncorrectIdException(String s) {
        super(s);
    }
}
