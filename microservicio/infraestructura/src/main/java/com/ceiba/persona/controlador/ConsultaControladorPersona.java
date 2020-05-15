package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.manejador.ManejadorConsultarPersona;
import com.ceiba.persona.consulta.manejador.ManejadorListarPersonas;
import com.ceiba.persona.modelo.dto.DtoPersona;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador consulta persona"})
public class ConsultaControladorPersona {

    private final ManejadorListarPersonas manejadorListarPersonas;
    private final ManejadorConsultarPersona manejadorConsultarPersona;

    public ConsultaControladorPersona(ManejadorListarPersonas manejadorListarPersonas,
                                      ManejadorConsultarPersona manejadorConsultarPersona) {
        this.manejadorListarPersonas = manejadorListarPersonas;
        this.manejadorConsultarPersona = manejadorConsultarPersona;
    }

    @GetMapping
    public List<DtoPersona> listarTodos(@RequestParam("numeroRegistroInicial") Integer numeroRegistroInicial,
                                        @RequestParam("numeroRegistros") Integer numeroRegistros) {
        return manejadorListarPersonas.ejecutar(numeroRegistroInicial, numeroRegistros);
    }

    @GetMapping("/{numeroDocumento}")
    public DtoPersona listarPorTipoYNumeroDeDocumento(@PathVariable("numeroDocumento") String numeroDocumento,
                                                      @RequestParam("tipoDocumento") String tipoDocumento) {
        return manejadorConsultarPersona.ejecutar(tipoDocumento, numeroDocumento);
    }
}
