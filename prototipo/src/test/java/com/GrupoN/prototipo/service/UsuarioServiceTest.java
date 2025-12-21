package com.GrupoN.prototipo.service;

import com.GrupoN.prototipo.model.Usuario;
import com.GrupoN.prototipo.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Habilita Mockito
@DisplayName("Pruebas del Servicio de Usuario (con Mocks)")
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repositorioMock;

    @InjectMocks
    private UsuarioService servicio;

    @Test
    @DisplayName("Listar todos los usuarios")
    void testListarTodos() {
        Usuario u1 = new Usuario("Diego", 22, 75f, 5, "23-07");
        Usuario u2 = new Usuario("Juan", 30, 80f, 2, "22-06");
        when(repositorioMock.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> resultado = servicio.listarTodos();

        assertEquals(2, resultado.size());
        verify(repositorioMock, times(1)).findAll(); // Verifica que se llamó al repositorio
    }

    @Test
    @DisplayName("Guardar un usuario")
    void testGuardar() {
        Usuario u = new Usuario("Diego", 22, 75f, 5, "23-07");
        when(repositorioMock.save(any(Usuario.class))).thenReturn(u);

        servicio.guardar(u);

        verify(repositorioMock, times(1)).save(u);
    }

    @Test
    @DisplayName("Obtener por ID - Usuario existente")
    void testObtenerPorId_Encontrado() {
        Usuario u = new Usuario("Diego", 22, 75f, 5, "23-07");
        when(repositorioMock.findById(1L)).thenReturn(Optional.of(u));

        Usuario resultado = servicio.obtenerPorId(1L);

        assertNotNull(resultado);
        assertEquals("Diego", resultado.getNombre());
    }

    @Test
    @DisplayName("Obtener por ID - Usuario NO existente")
    void testObtenerPorId_NoEncontrado() {
        when(repositorioMock.findById(99L)).thenReturn(Optional.empty());

        Usuario resultado = servicio.obtenerPorId(99L);

        assertNull(resultado);
    }

    @Test
    @DisplayName("Eliminar usuario")
    void testEliminar() {
        servicio.eliminar(1L);

        verify(repositorioMock, times(1)).deleteById(1L);
    }
}
