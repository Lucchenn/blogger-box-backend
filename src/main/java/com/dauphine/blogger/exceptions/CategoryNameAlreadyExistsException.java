package com.dauphine.blogger.exceptions;

public class CategoryNameAlreadyExistsException extends Exception {
    public CategoryNameAlreadyExistsException(String message) {
        super(message);
    }
}
