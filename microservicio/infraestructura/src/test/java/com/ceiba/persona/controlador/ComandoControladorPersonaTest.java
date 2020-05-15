package com.ceiba.persona.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.controlador.testDataBuilder.ComandoPersonaTestDataBuilder;
import com.ceiba.persona.modelo.entidades.DocumentoDeIdentidad;
import com.ceiba.persona.puerto.RepositorioPersona;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPersona.class)
@Transactional
public class ComandoControladorPersonaTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RepositorioPersona repositorioPersona;

    @Test
    public void crearPersona() throws Exception {
        String numeroIdentificacion = "458652447";
        String tipoIdentificacion = "CC";
        ComandoPersona comandoPersona = new ComandoPersonaTestDataBuilder()
                .withNombre("Alexander")
                .withApellido("Valdes Pineda")
                .withEdad(28)
                .withTipoIdentificacion(tipoIdentificacion)
                .withNumeroIdentificacion(numeroIdentificacion)
                .build();
        mockMvc.perform(post("/personas")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPersona))
        ).andExpect(status().isOk());

        Assert.assertThat(existePersona(numeroIdentificacion, tipoIdentificacion), is(true));
    }

    private boolean existePersona(String numeroIdentificacion, String tipoIdentificacion) {
        return repositorioPersona.existeConDocumentoDeIdentidad(
                new DocumentoDeIdentidad(tipoIdentificacion, numeroIdentificacion));
    }
}
