package com.ceiba.persona.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.persona.modelo.entidades.Persona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComando<ComandoPersona> {

    private final ServicioCrearPersona servicioCrearPersona;
    private final FabricaPersona fabricaPersona;

    public ManejadorCrearPersona(ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona) {
        this.servicioCrearPersona = servicioCrearPersona;
        this.fabricaPersona = fabricaPersona;
    }

    @Override
    public void ejecutar(ComandoPersona comando) {
        Persona persona = fabricaPersona.crear(comando);
        servicioCrearPersona.ejecutar(persona);
    }
}
