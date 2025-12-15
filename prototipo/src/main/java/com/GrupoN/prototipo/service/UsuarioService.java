package com.GrupoN.prototipo.service;

import com.GrupoN.prototipo.model.Usuario;
import com.GrupoN.prototipo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    // Listar todos (Read)
    public List<Usuario> listarTodos() {
        return repositorio.findAll();
    }

    // Guardar o Actualizar (Create / Update)
    public void guardar(Usuario usuario) {
        repositorio.save(usuario);
    }

    // Obtener por ID (para editar)
    public Usuario obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    // Eliminar (Delete)
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
