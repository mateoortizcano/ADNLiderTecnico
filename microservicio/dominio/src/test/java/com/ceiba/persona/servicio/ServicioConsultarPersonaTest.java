package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.persona.puerto.DaoPersona;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.ceiba.BasePrueba.assertThrows;
import static org.mockito.Mockito.when;

public class ServicioConsultarPersonaTest {
    @InjectMocks
    private ServicioConsultarPersona servicioConsultarPersona;
    @Mock
    private DaoPersona daoPersona;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verificarObligatoriedadTipoDocumento() {
        String tipoDocumento = null;
        String numeroDocumento = "123";
        assertThrows(() -> servicioConsultarPersona.ejecutar(tipoDocumento, numeroDocumento),
                ExcepcionValorObligatorio.class, "El tipo de documento es obligatorio");
    }

    @Test
    public void verificarObligatoriedadNumeroDocumento() {
        String tipoDocumento = "CC";
        String numeroDocumento = null;
        assertThrows(() -> servicioConsultarPersona.ejecutar(tipoDocumento, numeroDocumento),
                ExcepcionValorObligatorio.class, "El número de documento es obligatorio");
    }

    @Test
    public void cuandoNohayPersonasEntoncesArrojaExcepcion() {
        String tipoDocumento = "CC";
        String numeroDocumento = "123";
        when(daoPersona.consultarConDocumentoDeIdentidad(tipoDocumento, numeroDocumento)).thenReturn(Optional.empty());
        assertThrows(() -> servicioConsultarPersona.ejecutar(tipoDocumento, numeroDocumento),
                ExcepcionSinDatos.class, "No se encontró ninguna persona con esa identificación");
    }
}
