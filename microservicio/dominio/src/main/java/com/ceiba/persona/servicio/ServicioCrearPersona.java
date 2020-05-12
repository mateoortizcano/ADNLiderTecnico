package com.ceiba.persona.servicio;

import com.ceiba.persona.modelo.entidades.Persona;
import com.ceiba.persona.puerto.RepositorioPersona;

public class ServicioCrearPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona) {
        repositorioPersona.crear(persona);
    }
}
