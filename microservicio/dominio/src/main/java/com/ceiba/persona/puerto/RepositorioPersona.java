package com.ceiba.persona.puerto;

import com.ceiba.persona.modelo.entidades.DocumentoDeIdentidad;
import com.ceiba.persona.modelo.entidades.Persona;

public interface RepositorioPersona {
    /**
     * Permite consultar si existe una persona por su documento de identiddd
     *
     * @param documentoDeIdentidad
     * @return
     */
    boolean existeConDocumentoDeIdentidad(DocumentoDeIdentidad documentoDeIdentidad);

    /**
     * Permite crear personas
     *
     * @param persona
     */
    void crear(Persona persona);
}
