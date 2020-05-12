package com.ceiba.persona.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorPersona.class)
public class ConsultaControladorPersonaTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void consultarListadoDePersonas() throws Exception {
        mockMvc.perform(get("/personas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Andres")))
                .andExpect(jsonPath("$[0].apellido", is("Parra")))
                .andExpect(jsonPath("$[0].tipoDocumento", is("CC")));
    }

    @Test
    public void consultarPersonasPorDocumentoYTipoDocumento() throws Exception {
        mockMvc.perform(get("/personas/1036544852?tipoDocumento=CC")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("nombre", is("Andres")))
                .andExpect(jsonPath("apellido", is("Parra")));
    }
}
