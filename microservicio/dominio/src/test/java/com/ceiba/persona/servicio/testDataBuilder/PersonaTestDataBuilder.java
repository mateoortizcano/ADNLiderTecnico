package com.ceiba.persona.servicio.testDataBuilder;

import com.ceiba.persona.modelo.entidades.DocumentoDeIdentidad;
import com.ceiba.persona.modelo.entidades.Persona;

public class PersonaTestDataBuilder {
    private String nombre;
    private String apellido;
    private Integer edad;
    private DocumentoDeIdentidad documentoDeIdentidad;

    public PersonaTestDataBuilder() {
        this.nombre = "nombre";
        this.apellido = "apellido";
        this.edad = 38;
        this.documentoDeIdentidad = new DocumentoDeIdentidad("CC", "1099834523");
    }

    public PersonaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public PersonaTestDataBuilder conEdad(Integer edad) {
        this.edad = edad;
        return this;
    }

    public PersonaTestDataBuilder conDocumentoDeIdentidad(DocumentoDeIdentidad documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
        return this;
    }

    public Persona build() {
        return new Persona(nombre, apellido, edad, documentoDeIdentidad);
    }
}
