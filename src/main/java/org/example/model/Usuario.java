package org.example.model;

import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un usuario.
 */
@Entity
public class Usuario {
    @Setter
    @Id
    private String correo;

    @Setter
    private String nombre;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public Usuario() {}

    /**
     * Constructor con parámetros.
     *
     * @param correo el correo del usuario
     * @param nombre el nombre del usuario
     */
    public Usuario(String correo, String nombre) {
        this.correo = correo;
        this.nombre = nombre;
    }

    /**
     * Añade un comentario al usuario.
     *
     * @param c el comentario a añadir
     */
    public void añadirComentario(Comentario c) {
        c.setUsuario(this);
        comentarios.add(c);
    }

    /**
     * Obtiene el correo del usuario.
     *
     * @return el correo del usuario
     */
    public String getCorreo() { return correo; }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene la lista de comentarios del usuario.
     *
     * @return la lista de comentarios
     */
    public List<Comentario> getComentarios() { return comentarios; }
}