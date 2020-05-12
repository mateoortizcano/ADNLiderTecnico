package com.ceiba.persona.servicio.testDataBuilder;

import com.ceiba.persona.modelo.entidades.DocumentoDeIdentidad;

public class DocumentoDeIdentidadTestDataBuilder {
    private String tipo;
    private String numero;

    public DocumentoDeIdentidadTestDataBuilder() {
        this.tipo = "CC";
        this.numero = "123";
    }

    public DocumentoDeIdentidadTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public DocumentoDeIdentidadTestDataBuilder conNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public DocumentoDeIdentidad build() {
        return new DocumentoDeIdentidad(tipo, numero);
    }
}
