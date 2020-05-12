package com.ceiba.configuracion;

import com.ceiba.persona.puerto.DaoPersona;
import com.ceiba.persona.puerto.RepositorioPersona;
import com.ceiba.persona.servicio.ServicioConsultarPersona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearPersona servicioCrearPersona (RepositorioPersona repositorioPersona) {
        return new ServicioCrearPersona(repositorioPersona);
    }

    @Bean
    public ServicioConsultarPersona servicioConsultarPersona (DaoPersona daoPersona) {
        return new ServicioConsultarPersona(daoPersona);
    }

}
