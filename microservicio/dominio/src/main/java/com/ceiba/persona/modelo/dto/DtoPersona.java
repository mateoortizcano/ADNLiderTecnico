package com.ceiba.persona.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPersona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String tipoDocumento;
    private String numeroDocumento;
}
