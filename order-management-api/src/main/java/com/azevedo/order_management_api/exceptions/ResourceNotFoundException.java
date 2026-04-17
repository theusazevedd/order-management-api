package com.azevedo.order_management_api.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }

}
