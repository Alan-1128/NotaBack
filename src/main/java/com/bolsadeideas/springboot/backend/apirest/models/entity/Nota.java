package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@Entity
@Table(name = "notas")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(name = "msj_nota", length = 2000)
    private String msjNota;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nota", cascade = CascadeType.ALL)
  	private Set<Comentario> comentarios;

    @PrePersist
    public void fecha() {
        this.createAt = new Date();
    }


    
    

    

}
