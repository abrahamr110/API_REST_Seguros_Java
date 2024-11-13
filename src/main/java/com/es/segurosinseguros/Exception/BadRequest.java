package com.es.segurosinseguros.Exception;

public class BadRequest extends RuntimeException{
    private static final String Descripcion = "Bad Request";

    public BadRequest(String mensaje) {
        super(Descripcion + ": " + mensaje);
    }
}
