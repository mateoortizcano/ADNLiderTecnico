package com.ceiba.persona.modelo.entidades;

import static com.ceiba.dominio.ValidadorArgumento.*;

public class DocumentoDeIdentidad {
    public static final String EL_TIPO_DOCUMENTO_DE_IDENTIDAD_ES_OBLIGATORIO = "El tipo de documento de identidad es obligatorio";
    public static final String EL_NUMERO_DE_DOCUMENTO_DE_IDENTIDAD_ES_OBLIGATORIO = "El número de documento de identidad es obligatorio";
    public static final String EL_TIPO_DE_DOCUMENTO_DE_IDENTIDAD_NO_ES_VALIDO = "El tipo de documento de identidad no es válido";
    public static final String EL_NUMERO_DE_DOCUMENTO_DE_IDENTIDAD_NO_ES_VALIDO = "El número de documento de identidad no es válido";
    public static final String EL_NUMERO_DE_DOCUMENTO_DEBE_SER_UN_VALOR_POSITIVO = "El número de documento debe ser un valor mayor o igual a cero";
    private String tipo;
    private String numero;

    public DocumentoDeIdentidad(String tipo, String numero) {
        validarObligatorio(tipo, EL_TIPO_DOCUMENTO_DE_IDENTIDAD_ES_OBLIGATORIO);
        validarObligatorio(numero, EL_NUMERO_DE_DOCUMENTO_DE_IDENTIDAD_ES_OBLIGATORIO);
        validarValido(tipo.toUpperCase(), TipoDocumentoDeIdentidad.class, EL_TIPO_DE_DOCUMENTO_DE_IDENTIDAD_NO_ES_VALIDO);
        validarNumerico(numero, EL_NUMERO_DE_DOCUMENTO_DE_IDENTIDAD_NO_ES_VALIDO);
        validarPositivo(Double.parseDouble(numero), EL_NUMERO_DE_DOCUMENTO_DEBE_SER_UN_VALOR_POSITIVO);
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }
}
