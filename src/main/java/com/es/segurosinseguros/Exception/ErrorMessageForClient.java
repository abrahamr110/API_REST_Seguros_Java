package com.es.segurosinseguros.Exception;

public class ErrorMessageForClient extends RuntimeException{
    private String mensaje,uri;

    public ErrorMessageForClient(String mensaje, String uri) {
        this.mensaje = mensaje;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
