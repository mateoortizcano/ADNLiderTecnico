package com.ceiba.persona.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.entidades.DocumentoDeIdentidad;
import com.ceiba.persona.modelo.entidades.Persona;
import com.ceiba.persona.puerto.RepositorioPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaMySql implements RepositorioPersona {

    public static final String NUMERO_DOCUMENTO = "numero_documento";
    public static final String TIPO_DOCUMENTO = "tipo_documento";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "persona", value = "existeConTipoYNumeroDeDocumentoDeIdentidad")
    private String sqlExisteConTipoYNumeroDeDocumentoDeIdentidad;

    @SqlStatement(namespace = "persona", value = "crear")
    private String sqlCrearPersona;

    public RepositorioPersonaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean existeConDocumentoDeIdentidad(DocumentoDeIdentidad documentoDeIdentidad) {
        MapSqlParameterSource parametrosSql = new MapSqlParameterSource();
        parametrosSql.addValue(TIPO_DOCUMENTO, documentoDeIdentidad.getTipo());
        parametrosSql.addValue(NUMERO_DOCUMENTO, documentoDeIdentidad.getNumero());
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(
                sqlExisteConTipoYNumeroDeDocumentoDeIdentidad, parametrosSql, Boolean.class);
    }

    @Override
    public void crear(Persona persona) {
        MapSqlParameterSource parametrosSql = new MapSqlParameterSource();
        parametrosSql.addValue("nombre", persona.getNombre());
        parametrosSql.addValue("apellido", persona.getApellido());
        parametrosSql.addValue("edad", persona.getEdad());
        parametrosSql.addValue(TIPO_DOCUMENTO, persona.getDocumentoDeIdentidad().getTipo());
        parametrosSql.addValue(NUMERO_DOCUMENTO, persona.getDocumentoDeIdentidad().getNumero());
        customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrearPersona, parametrosSql);
    }
}
