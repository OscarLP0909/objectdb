package org.example.service;

import javax.persistence.*;
import java.util.List;
import org.example.model.Usuario;
import org.example.model.Comentario;

/**
 * Servicio para gestionar operaciones de datos.
 */
public class DataService {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/usuarios.odb");

    /**
     * Registra un nuevo usuario.
     *
     * @param correo el correo del usuario
     * @param nombre el nombre del usuario
     */
    public static void registrarUsuario(String correo, String nombre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = new Usuario(correo, nombre);
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Lista los comentarios con una valoración mínima.
     *
     * @param valoracionMinima la valoración mínima
     */
    public static void listarMejoresComentarios(int valoracionMinima) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comentario> query = em.createQuery(
                "SELECT c FROM Comentario c WHERE c.valoracion >= :valoracion", Comentario.class);
        query.setParameter("valoracion", valoracionMinima);

        List<Comentario> comentarios = query.getResultList();
        for (Comentario c : comentarios) {
            System.out.println("Comentario: " + c.getContenido() + ", Valoración: " + c.getValoracion());
        }
        em.close();
    }

    /**
     * Añade un comentario a un usuario.
     *
     * @param correoUsuario el correo del usuario
     * @param contenido el contenido del comentario
     * @param valoracion la valoración del comentario
     */
    public static void añadirComentario(String correoUsuario, String contenido, int valoracion) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, correoUsuario);

        if (usuario != null) {
            Comentario comentario = new Comentario(contenido, valoracion);
            usuario.añadirComentario(comentario);
            em.persist(comentario);
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Elimina un usuario por su correo.
     *
     * @param correoUsuario el correo del usuario
     */
    public static void eliminarUsuario(String correoUsuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, correoUsuario);

        if (usuario != null) {
            em.remove(usuario);
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Limpia la base de datos eliminando todos los usuarios y comentarios.
     */
    public static void limpiarBaseDeDatos() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("DELETE FROM Comentario").executeUpdate();
        em.createQuery("DELETE FROM Usuario").executeUpdate();

        em.getTransaction().commit();
        em.close();
        System.out.println("Base de datos limpiada.");
    }
}