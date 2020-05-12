package com.ceiba.persona.controlador;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.manejador.ManejadorCrearPersona;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador comando persona"})
public class ComandoControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;

    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
    }

    @PostMapping
    public void crearPersona(@RequestBody ComandoPersona comandoPersona) {
        this.manejadorCrearPersona.ejecutar(comandoPersona);
    }
}
