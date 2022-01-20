package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.Optional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.ComentarioRepository;
import com.bolsadeideas.springboot.backend.apirest.models.dao.NotaRepository;
import com.bolsadeideas.springboot.backend.apirest.models.dao.RespuestaRepository;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Comentario;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Nota;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Respuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MethodsImpl implements Methods {

    @Autowired
    NotaRepository notaRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    // ---------------------------------------------------------------Agregar y obtener NOTAS
    @Override
    public ArrayList<Nota> obtenerNota(){
        return (ArrayList<Nota>) notaRepository.findAll();
    }

    @Override
    public Optional<Nota> obtenerPorId(Long id){
        return notaRepository.findById(id);
    }

    @Override
    public Nota guardarNota(Nota nota){

        return notaRepository.save(nota);
    }

    // ---------------------------------------------------------------Agregar comentarios
    @Override
    public Comentario guardarComentario(Comentario comentario, Long id){
        Comentario comentario2 = new Comentario();
        comentario2.setMsjComentario(comentario.getMsjComentario());
        comentario2.setId(comentario.getId());

        Optional<Nota> nOptional = notaRepository.findById(id);
        if(nOptional.isPresent()){
            comentario2.setNota( nOptional.get() );
        }
        comentarioRepository.save(comentario2);
        return comentario2;

    }

    // ---------------------------------------------------------------Agregar respuestas
    @Override
    public Respuesta guardarRespuesta(Respuesta respuesta, Long id){
        Respuesta respuesta2 = new Respuesta();
        respuesta2.setMsjRespuesta(respuesta.getMsjRespuesta());
        respuesta2.setId(respuesta.getId());

        Optional<Comentario> nOptional = comentarioRepository.findById(id);
        if(nOptional.isPresent()){
            respuesta2.setComentario(nOptional.get());
        }
  
        respuestaRepository.save(respuesta2);
        return respuesta2;
    }

}
