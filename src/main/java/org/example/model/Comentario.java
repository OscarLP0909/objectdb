package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private Long id;

    // Getters y setters
    @Setter
    @Getter
    private String contenido;
    @Setter
    @Getter
    private int valoracion;

    @ManyToOne
    private Usuario usuario;

    public Comentario() {}

    public Comentario(String contenido, int valoracion) {
        this.contenido = contenido;
        this.valoracion = valoracion;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
