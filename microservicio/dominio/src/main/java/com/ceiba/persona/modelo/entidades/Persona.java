package com.ceiba.persona.modelo.entidades;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import static com.ceiba.dominio.ValidadorArgumento.*;

public class Persona {
    public static final String EL_NOMBRE_ES_OBLIGATORIO = "EL nombre es obligatorio";
    public static final String EL_APELLIDO_ES_OBLIGATORIO = "EL apellido es obligatorio";
    public static final int LONGITUD_MINIMA_TEXTO_OBLIGATORIO = 1;
    public static final String LA_EDAD_ES_OBLIGATORIA = "La edad es obligatoria";
    public static final String EL_DOCUMENTO_DE_IDENTIDAD_ES_OBLIGATORIO = "El documento de identidad es obligatorio";
    public static final String LA_EDAD_DEBE_SER_UN_VALOR_MAYOR_A_0 = "La edad debe ser un valor mayor a 0";
    public static final long EDAD_MAXIMA = 130L;
    public static final String LA_EDAD_DEBE_SER_UN_VALOR_MENOR_A_130 = "La edad debe ser un valor menor a 130";
    public static final int DIECIOCHO_ANIOS = 18;
    public static final String LA_EDAD_NO_CORRESPONDE_CON_EL_TIPO_DE_DOCUMENTO = "La edad no corresponde con el tipo de documento";
    private String nombre;
    private String apellido;
    private Integer edad;
    private DocumentoDeIdentidad documentoDeIdentidad;

    public Persona(String nombre, String apellido, Integer edad, DocumentoDeIdentidad documentoDeIdentidad) {
        validarObligatorio(nombre, EL_NOMBRE_ES_OBLIGATORIO);
        validarLongitudMinima(nombre, LONGITUD_MINIMA_TEXTO_OBLIGATORIO, EL_NOMBRE_ES_OBLIGATORIO);
        validarObligatorio(apellido, EL_APELLIDO_ES_OBLIGATORIO);
        validarLongitudMinima(apellido, LONGITUD_MINIMA_TEXTO_OBLIGATORIO, EL_APELLIDO_ES_OBLIGATORIO);
        validarObligatorio(edad, LA_EDAD_ES_OBLIGATORIA);
        validarObligatorio(documentoDeIdentidad, EL_DOCUMENTO_DE_IDENTIDAD_ES_OBLIGATORIO);
        validarPositivo(edad.doubleValue(), LA_EDAD_DEBE_SER_UN_VALOR_MAYOR_A_0);
        validarMenor(edad.longValue(), EDAD_MAXIMA, LA_EDAD_DEBE_SER_UN_VALOR_MENOR_A_130);
        validarEdadConTipoDocumento(edad, documentoDeIdentidad);
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documentoDeIdentidad = documentoDeIdentidad;
    }

    private void validarEdadConTipoDocumento(Integer edad, DocumentoDeIdentidad documentoDeIdentidad) {
        if ((tipoDelDocumentoIdentidadEsIgualA(documentoDeIdentidad, TipoDocumentoDeIdentidad.TI) && edad >= DIECIOCHO_ANIOS)
                || (tipoDelDocumentoIdentidadEsIgualA(documentoDeIdentidad, TipoDocumentoDeIdentidad.CC) && edad < DIECIOCHO_ANIOS)) {
            throw new ExcepcionValorInvalido(LA_EDAD_NO_CORRESPONDE_CON_EL_TIPO_DE_DOCUMENTO);
        }
    }

    private boolean tipoDelDocumentoIdentidadEsIgualA(DocumentoDeIdentidad documentoDeIdentidad,
                                                      TipoDocumentoDeIdentidad enumTipoDocumento) {
        return enumTipoDocumento.name().equals(documentoDeIdentidad.getTipo().toUpperCase());
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public DocumentoDeIdentidad getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }
}
