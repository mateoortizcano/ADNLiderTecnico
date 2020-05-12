package com.ceiba.persona.modelo.entidades;

public enum TipoDocumentoDeIdentidad {
    CC("Cédula de Ciudadanía"),
    TI("Tarjeta de Identidad");

    private String nombreCompleto;

    TipoDocumentoDeIdentidad(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
