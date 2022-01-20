package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "respuestas")
public class Respuesta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "msj_respuesta", length = 1000)
    private String msjRespuesta;

    @Column(name = "create_At")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuesta_id")
	private Comentario comentario;

    @PrePersist
    public void fecha() {
        this.createAt = new Date();
    }

    public Respuesta() {
    }

    public Respuesta(String msjRespuesta, Date createAt, Comentario comentario) {
        this.msjRespuesta = msjRespuesta;
        this.createAt = createAt;
        this.comentario = comentario;
    }

    

    
}
