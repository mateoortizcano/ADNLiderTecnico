package com.ceiba.persona.controlador.testDataBuilder;

import com.ceiba.persona.comando.ComandoPersona;

public class ComandoPersonaTestDataBuilder {
    private String nombre;
    private String apelido;
    private Integer edad;
    private String tipoDocumentoIdentidad;
    private String numeroIdentificacion;

    public ComandoPersonaTestDataBuilder() {
        this.nombre = "Nombre";
        this.apelido = "Apellido";
        this.edad = 12;

    }

    public ComandoPersonaTestDataBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPersonaTestDataBuilder withApellido(String apellido) {
        this.apelido = apellido;
        return this;
    }

    public ComandoPersonaTestDataBuilder withEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public ComandoPersona build() {
        return new ComandoPersona(nombre, apelido, edad, tipoDocumentoIdentidad, numeroIdentificacion);
    }

    public ComandoPersonaTestDataBuilder withTipoIdentificacion(String tipoIdentificacion) {
        this.tipoDocumentoIdentidad = tipoIdentificacion;
        return this;
    }

    public ComandoPersonaTestDataBuilder withNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }
}
