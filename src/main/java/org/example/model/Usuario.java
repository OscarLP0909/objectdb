package org.example.model;

import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Setter
    @Id
    private String correo;

    @Setter
    private String nombre;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    public Usuario() {}

    public Usuario(String correo, String nombre) {
        this.correo = correo;
        this.nombre = nombre;
    }

    public void añadirComentario(Comentario c) {
        c.setUsuario(this);
        comentarios.add(c);
    }


    public String getCorreo() { return correo; }

    public String getNombre() { return nombre; }

    public List<Comentario> getComentarios() { return comentarios; }
}
