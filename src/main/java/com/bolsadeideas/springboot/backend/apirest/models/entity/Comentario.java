package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "comentarios")
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "msj_comentario", length = 1000)
    private String msjComentario;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nota_id")
	private Nota nota;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comentario", cascade = CascadeType.ALL)
  	private Set<Respuesta> respuestas;

    @PrePersist
    public void fecha() {
        this.createAt = new Date();
    }


    public Comentario() {
    }

    public Comentario(String msjComentario, Date createAt, Nota nota) {
        this.msjComentario = msjComentario;
        this.createAt = createAt;
        this.nota = nota;
    }


    

    
}
