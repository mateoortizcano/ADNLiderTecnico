package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidades.Persona;
import com.ceiba.persona.puerto.RepositorioPersona;

public class ServicioCrearPersona {

    public static final String LA_PERSONA_CON_NUMERO_DE_DOCUMENTO_YA_SE_ENCUENTRA_REGISTRADA = "La persona con %s número %s ya se encuentra registrada";
    private final RepositorioPersona repositorioPersona;

    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona) {
        if (repositorioPersona.existeConDocumentoDeIdentidad(persona.getDocumentoDeIdentidad())) {
            throw new ExcepcionDuplicidad(String.format(LA_PERSONA_CON_NUMERO_DE_DOCUMENTO_YA_SE_ENCUENTRA_REGISTRADA,
                    persona.getDocumentoDeIdentidad().getTipo(), persona.getDocumentoDeIdentidad().getNumero()));
        }
        repositorioPersona.crear(persona);
    }
}
