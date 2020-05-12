package com.ceiba.persona.consulta.manejador;

import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.DaoPersona;
import com.ceiba.persona.servicio.ServicioConsultarPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarPersona {
    private final ServicioConsultarPersona servicioConsultarPersona;

    public ManejadorConsultarPersona(ServicioConsultarPersona servicioConsultarPersona) {
        this.servicioConsultarPersona = servicioConsultarPersona;
    }

    public DtoPersona ejecutar(String tipoDocumento, String numeroDocumento) {
        return this.servicioConsultarPersona.ejecutar(tipoDocumento, numeroDocumento);
    }
}
