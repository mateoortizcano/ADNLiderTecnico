package com.ceiba.persona.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.DaoPersona;

public class ServicioConsultarPersona {
    public static final String EL_TIPO_DE_DOCUMENTO_ES_OBLIGATORIO = "El tipo de documento es obligatorio";
    public static final String EL_NUMERO_DE_DOCUMENTO_ES_OBLIGATORIO = "El número de documento es obligatorio";
    public static final String NO_SE_ENCONTRO_NINGUNA_PERSONA_CON_ESA_IDENTIFICACION = "No se encontró ninguna persona con esa identificación";
    private final DaoPersona daoPersona;

    public ServicioConsultarPersona(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public DtoPersona ejecutar(String tipoDocumento, String numeroDocumento) {
        ValidadorArgumento.validarObligatorio(tipoDocumento, EL_TIPO_DE_DOCUMENTO_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(numeroDocumento, EL_NUMERO_DE_DOCUMENTO_ES_OBLIGATORIO);
        DtoPersona persona = this.daoPersona.consultarConDocumentoDeIdentidad(tipoDocumento, numeroDocumento);
        if (persona == null) {
            throw new ExcepcionSinDatos(NO_SE_ENCONTRO_NINGUNA_PERSONA_CON_ESA_IDENTIFICACION);
        }
        return persona;
    }
}
