package com.ceiba.persona.puerto;

import com.ceiba.persona.modelo.dto.DtoPersona;

import java.util.List;
import java.util.Optional;

public interface DaoPersona {

    /**
     * Permite listar personas
     *
     * @return
     */
    List<DtoPersona> listar();

    /**
     * Permite consultar personas por el documento de identidad
     * @param tipoDocumento
     * @param numeroDocumento
     * @return
     */
    Optional<DtoPersona> consultarConDocumentoDeIdentidad(String tipoDocumento, String numeroDocumento);
}
