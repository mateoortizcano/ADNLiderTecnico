package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.DaoPersona;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j2
@Repository
public class DaoPersonaMySql implements DaoPersona {

    public static final int NUMERO_DE_RESULTADOS_POR_DEFECTO = 100;
    public static final int NUMERO_REGISTRO_INICIAL_POR_DEFECTO = 0;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "persona", value = "listar")
    private String sqlListar;
    @SqlStatement(namespace = "persona", value = "consultarPorDocumentoDeIdentidad")
    private String sqlConsultarPorDocumentoDeIdentidad;

    public DaoPersonaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPersona> listar(Integer offset, Integer rowCount) {
        offset = (offset == null) || (offset <= 0) ? NUMERO_REGISTRO_INICIAL_POR_DEFECTO : (offset-1);
        rowCount = (rowCount == null) || (rowCount < 0) ? NUMERO_DE_RESULTADOS_POR_DEFECTO : rowCount;
        MapSqlParameterSource parametrosSql = new MapSqlParameterSource();
        parametrosSql.addValue("offset", offset);
        parametrosSql.addValue("row_count", rowCount);
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(
                sqlListar, parametrosSql, new MapeadorPersona());
    }

    @Override
    public Optional<DtoPersona> consultarConDocumentoDeIdentidad(String tipoDocumento, String numeroDocumento) {
        MapSqlParameterSource parametrosSql = new MapSqlParameterSource();
        parametrosSql.addValue("tipo_documento", tipoDocumento);
        parametrosSql.addValue("numero_documento", numeroDocumento);
        try {
            return Optional.of(customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(
                    sqlConsultarPorDocumentoDeIdentidad, parametrosSql, new MapeadorPersona()));
        } catch (EmptyResultDataAccessException excepcion) {
            log.error("No se encontró ninguna persona con esa identificación", excepcion);
            return Optional.empty();
        }
    }
}
