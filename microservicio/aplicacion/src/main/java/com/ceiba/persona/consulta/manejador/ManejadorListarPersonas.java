package com.ceiba.persona.consulta.manejador;

import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.DaoPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPersonas {
    private final DaoPersona daoPersona;

    public ManejadorListarPersonas(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public List<DtoPersona> ejecutar(Integer numeroRegistroInicial, Integer numeroRegistros) {
        return this.daoPersona.listar(numeroRegistroInicial, numeroRegistros);
    }
}
