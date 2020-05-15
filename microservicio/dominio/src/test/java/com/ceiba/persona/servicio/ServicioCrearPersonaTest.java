package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.persona.modelo.entidades.DocumentoDeIdentidad;
import com.ceiba.persona.modelo.entidades.Persona;
import com.ceiba.persona.puerto.RepositorioPersona;
import com.ceiba.persona.servicio.testDataBuilder.DocumentoDeIdentidadTestDataBuilder;
import com.ceiba.persona.servicio.testDataBuilder.PersonaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.ceiba.BasePrueba.assertThrows;

public class ServicioCrearPersonaTest {

    @InjectMocks
    private ServicioCrearPersona servicioCrearPersona;
    @Mock
    private RepositorioPersona repositorioPersona;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarNombrePersonaNoNulo() {
        PersonaTestDataBuilder personaBuilder = new PersonaTestDataBuilder().conNombre(null);
        assertThrows(personaBuilder::build, ExcepcionValorObligatorio.class, "EL nombre es obligatorio");
    }

    @Test
    public void validarNombrePersonaNoVacio() {
        PersonaTestDataBuilder personaBuilder = new PersonaTestDataBuilder().conNombre("");
        assertThrows(personaBuilder::build, ExcepcionLongitudValor.class, "EL nombre es obligatorio");
    }

    @Test
    public void validarApellidoPersonaNoNulo() {
        PersonaTestDataBuilder personaBuilder = new PersonaTestDataBuilder().conApellido(null);
        assertThrows(personaBuilder::build, ExcepcionValorObligatorio.class, "EL apellido es obligatorio");
    }

    @Test
    public void validarApellidoPersonaNoVacio() {
        PersonaTestDataBuilder personaBuilder = new PersonaTestDataBuilder().conApellido("");
        assertThrows(personaBuilder::build, ExcepcionLongitudValor.class,
                "EL apellido es obligatorio");
    }

    @Test
    public void validarEdadPersonaNoNulo() {
        PersonaTestDataBuilder personaBuilder = new PersonaTestDataBuilder().conEdad(null);
        assertThrows(personaBuilder::build, ExcepcionValorObligatorio.class,
                "La edad es obligatoria");
    }

    @Test
    public void validarDocumentoPersonaNoNulo() {
        PersonaTestDataBuilder personaBuilder = new PersonaTestDataBuilder().conDocumentoDeIdentidad(null);
        assertThrows(personaBuilder::build, ExcepcionValorObligatorio.class,
                "El documento de identidad es obligatorio");
    }

    @Test
    public void validarTipoDocumentoPersonaNoNulo() {
        DocumentoDeIdentidadTestDataBuilder documentoBuilder = new DocumentoDeIdentidadTestDataBuilder().conTipo(null);
        assertThrows(documentoBuilder::build, ExcepcionValorObligatorio.class,
                "El tipo de documento de identidad es obligatorio");
    }

    @Test
    public void validarNumeroDocumentoPersonaNoNulo() {
        DocumentoDeIdentidadTestDataBuilder documentoBuilder = new DocumentoDeIdentidadTestDataBuilder().conNumero(null);
        assertThrows(documentoBuilder::build, ExcepcionValorObligatorio.class,
                "El número de documento de identidad es obligatorio");
    }

    @Test
    public void verificarTipoDocumentoIdentidadValido() {
        DocumentoDeIdentidadTestDataBuilder documentoDeIdentidadTestDataBuilder = new DocumentoDeIdentidadTestDataBuilder().conTipo("nit");
        assertThrows(documentoDeIdentidadTestDataBuilder::build, ExcepcionValorInvalido.class,
                "El tipo de documento de identidad no es válido");
    }

    @Test
    public void verificarEdadMayorACero() {
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conEdad(-1);
        assertThrows(personaTestDataBuilder::build, ExcepcionValorInvalido.class, "La edad debe ser un valor mayor a 0");
    }

    @Test
    public void verificarEdadMenorA130() {
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conEdad(131);
        assertThrows(personaTestDataBuilder::build, ExcepcionValorInvalido.class, "La edad debe ser un valor menor a 130");
    }

    @Test
    public void verificarNumeroDocumentoIdentidadNumerico() {
        DocumentoDeIdentidadTestDataBuilder documentoDeIdentidadTestDataBuilder = new DocumentoDeIdentidadTestDataBuilder().conNumero("123a");
        assertThrows(documentoDeIdentidadTestDataBuilder::build, ExcepcionValorInvalido.class,
                "El número de documento de identidad no es válido");
    }

    @Test
    public void verificarNumeroDocumentoIdentidadPositivo() {
        DocumentoDeIdentidadTestDataBuilder documentoDeIdentidadTestDataBuilder = new DocumentoDeIdentidadTestDataBuilder().conNumero("-123");
        assertThrows(documentoDeIdentidadTestDataBuilder::build, ExcepcionValorInvalido.class,
                "El número de documento debe ser un valor mayor o igual a cero");
    }

    @Test
    public void verificarQueTipoDocumentoTITengaEdadMenorA18() {
        DocumentoDeIdentidad documentoDeIdentidad = new DocumentoDeIdentidadTestDataBuilder()
                .conTipo("TI").build();
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conEdad(18)
                .conDocumentoDeIdentidad(documentoDeIdentidad);
        assertThrows(personaTestDataBuilder::build, ExcepcionValorInvalido.class, "La edad no corresponde con el tipo de documento");
    }

    @Test
    public void verificarQueTipoDocumentoCCTengaEdadMayorOIgualA18() {
        DocumentoDeIdentidad documentoDeIdentidad = new DocumentoDeIdentidadTestDataBuilder()
                .conTipo("CC").build();
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conEdad(17)
                .conDocumentoDeIdentidad(documentoDeIdentidad);
        assertThrows(personaTestDataBuilder::build, ExcepcionValorInvalido.class, "La edad no corresponde con el tipo de documento");
    }

    @Test
    public void verificarExistenciaPreviaPersona() {
        String tipo = "CC";
        String numero = "123456789";
        DocumentoDeIdentidad documentoDeIdentidad = new DocumentoDeIdentidadTestDataBuilder()
                .conTipo(tipo).conNumero(numero).build();
        Persona persona = new PersonaTestDataBuilder().conEdad(19)
                .conDocumentoDeIdentidad(documentoDeIdentidad).build();
        Mockito.when(repositorioPersona.existeConDocumentoDeIdentidad(documentoDeIdentidad)).thenReturn(true);
        assertThrows(() -> servicioCrearPersona.ejecutar(persona), ExcepcionDuplicidad.class,
                String.format("La persona con %s número %s ya se encuentra registrada", tipo, numero));
    }
}
