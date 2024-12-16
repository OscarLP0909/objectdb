package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entidad que representa un comentario.
 */
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

    /**
     * Constructor por defecto.
     */
    public Comentario() {}

    /**
     * Constructor con parámetros.
     *
     * @param contenido el contenido del comentario
     * @param valoracion la valoración del comentario
     */
    public Comentario(String contenido, int valoracion) {
        this.contenido = contenido;
        this.valoracion = valoracion;
    }

    /**
     * Obtiene el usuario asociado al comentario.
     *
     * @return el usuario asociado
     */
    public Usuario getUsuario() { return usuario; }

    /**
     * Establece el usuario asociado al comentario.
     *
     * @param usuario el usuario a asociar
     */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}