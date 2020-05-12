package com.ceiba.persona.puerto;

import com.ceiba.persona.modelo.dto.DtoPersona;

import java.util.List;

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
    DtoPersona consultarConDocumentoDeIdentidad(String tipoDocumento, String numeroDocumento);
}
