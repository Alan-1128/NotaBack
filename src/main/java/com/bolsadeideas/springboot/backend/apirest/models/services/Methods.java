package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.Optional;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Comentario;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Nota;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Respuesta;

public interface Methods {
    
    public ArrayList<Nota> obtenerNota();
    public Optional<Nota> obtenerPorId(Long id);
    public Nota guardarNota(Nota nota);

    public Respuesta guardarRespuesta(Respuesta respuesta, Long id);
    public Comentario guardarComentario(Comentario comentario, Long id);

}
