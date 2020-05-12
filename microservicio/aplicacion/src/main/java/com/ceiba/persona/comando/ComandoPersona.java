package com.ceiba.persona.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPersona {
    private String nombre;
    private String apelido;
    private Integer edad;
    private String tipoDocumentoIdentidad;
    private String numeroIdentificacion;
}
