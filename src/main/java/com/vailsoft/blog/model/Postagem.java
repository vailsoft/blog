package com.vailsoft.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "tb_postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 100)
    private String titulo;

    @NotNull
    @Size(min = 5, max = 500)
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());

    @ManyToOne
    @JsonIgnoreProperties("postagens")
    @JoinColumn(name = "tema_id")
    @NotNull
    private Tema tema;


    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Date getData() {
        return data;
    }
    public void setDate(Date data) {
        this.data = data;
    }
    public void setTema(Tema tema) { this.tema = tema; }
    public Tema getTema() { return tema; }

}
