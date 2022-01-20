package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Comentario;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Nota;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Respuesta;
import com.bolsadeideas.springboot.backend.apirest.models.services.Methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class Controlles {

    @Autowired
    private Methods methods;

    @GetMapping("/nota")
    public ArrayList<Nota> obtenerNota(){
        return (ArrayList<Nota>) methods.obtenerNota();
    }

    @GetMapping("/nota/{id}")
    public Optional<Nota> obtenerPorId(@PathVariable Long id){
        return methods.obtenerPorId(id);
    }

	@Secured("ROLE_ADMIN")
    @PostMapping("/nota")
    public Nota guardarNota(@RequestBody Nota nota){
        return methods.guardarNota(nota);
    }
    
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/respuesta/{id}")
    public Respuesta guardarRespuesta(@RequestBody Respuesta respuesta, @PathVariable Long id){
        return methods.guardarRespuesta(respuesta, id);
    }

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/comentario/{id}")
    public Comentario guardarComentario(@RequestBody Comentario comentario, @PathVariable Long id){
        return methods.guardarComentario(comentario, id);
    }

  
}
