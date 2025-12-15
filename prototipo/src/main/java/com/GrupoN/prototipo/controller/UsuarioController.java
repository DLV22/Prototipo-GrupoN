package com.GrupoN.prototipo.controller;

import com.GrupoN.prototipo.model.Usuario;
import com.GrupoN.prototipo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // 1. Mostrar la página con la lista y el formulario
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("listaUsuarios", service.listarTodos());
        model.addAttribute("usuario", new Usuario()); // Objeto vacío para el formulario
        return "gestion_usuarios"; // Nombre del archivo HTML
    }

    // 2. Guardar un usuario (Nuevo o Editado)
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        service.guardar(usuario);
        return "redirect:/usuarios"; // Recarga la página
    }

    // 3. Cargar datos para editar
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", service.obtenerPorId(id)); // Cargamos el usuario existente
        model.addAttribute("listaUsuarios", service.listarTodos()); // Mantenemos la lista visible
        return "gestion_usuarios";
    }

    // 4. Borrar usuario
    @GetMapping("/borrar/{id}")
    public String borrarUsuario(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/usuarios";
    }
}
