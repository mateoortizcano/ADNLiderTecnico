package com.ceiba.persona.comando.fabrica;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.modelo.entidades.DocumentoDeIdentidad;
import com.ceiba.persona.modelo.entidades.Persona;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {
    public Persona crear(ComandoPersona comandoPersona) {
        DocumentoDeIdentidad documentoDeIdentidad = new DocumentoDeIdentidad(comandoPersona.getTipoDocumentoIdentidad(),
                comandoPersona.getNumeroIdentificacion());
        return new Persona(comandoPersona.getNombre(), comandoPersona.getApelido(), comandoPersona.getEdad(),
                documentoDeIdentidad);
    }
}
