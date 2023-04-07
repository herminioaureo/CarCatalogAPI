package com.herminio.carcatalog.exceptions;

public class CarNotFoundException extends Exception {

    public CarNotFoundException(Long id){
        super(String.valueOf(id));
    }
}
