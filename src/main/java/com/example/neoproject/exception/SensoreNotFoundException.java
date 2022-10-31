package com.example.neoproject.exception;

public class SensoreNotFoundException extends RuntimeException {
    public SensoreNotFoundException(Integer id) {
        super("Sensore con id: " +id+ "non esiste");
    }

    public SensoreNotFoundException(String tipologia) {
        super("Sensore di tipologia "+ tipologia +" non esiste");
    }

}
