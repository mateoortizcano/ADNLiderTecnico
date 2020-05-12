package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.dto.DtoPersona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeadorPersona implements RowMapper<DtoPersona>, MapperResult {
    @Override
    public DtoPersona mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        Integer edad = rs.getInt("edad");
        String numeroDocumento = rs.getString("numero_documento");
        String tipoDocumento = rs.getString("tipo_documento");
        return new DtoPersona(id, nombre, apellido, edad, tipoDocumento, numeroDocumento);
    }
}
