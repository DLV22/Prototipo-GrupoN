package com.GrupoN.prototipo.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas Unitarias de la Entidad Usuario")
class UsuarioTest {

    @Test
    @DisplayName("Test de Constructor vacío y Setters/Getters")
    void testConstructorVacioYSetters() {
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(1L);
        usuario.setNombre("Diego");
        usuario.setEdad(22);
        usuario.setPeso(75.5f);
        usuario.setNivelStress(5);
        usuario.setHorarioSueno("23:00-07:00");

        assertEquals(1L, usuario.getIdUsuario());
        assertEquals("Diego", usuario.getNombre());
        assertEquals(22, usuario.getEdad());
        assertEquals(75.5f, usuario.getPeso());
        assertEquals(5, usuario.getNivelStress());
        assertEquals("23:00-07:00", usuario.getHorarioSueno());
    }

    @Test
    @DisplayName("Test de Constructor con parámetros")
    void testConstructorCompleto() {
        Usuario usuario = new Usuario("Juan", 30, 80.0f, 2, "22:00-06:00");

        assertNull(usuario.getIdUsuario()); // El ID es null hasta que se guarda en BD
        assertEquals("Juan", usuario.getNombre());
        assertEquals(30, usuario.getEdad());
        assertEquals(80.0f, usuario.getPeso());
        assertEquals(2, usuario.getNivelStress());
        assertEquals("22:00-06:00", usuario.getHorarioSueno());
    }
}
