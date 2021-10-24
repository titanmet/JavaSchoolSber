package com.ratnikov.exeption;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super(id != null ? id.toString() : null);
    }
}