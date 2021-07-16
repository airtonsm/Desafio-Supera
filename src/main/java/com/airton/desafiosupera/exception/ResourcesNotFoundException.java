package com.airton.desafiosupera.exception;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(Long id){
        super("Resouce not found Id " + id);
    }

}

