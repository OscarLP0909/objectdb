package org.example;

import static org.example.service.DataService.*;

/**
 * Clase principal para ejecutar la aplicación.
 */
public class Main {
    public static void main(String[] args) {

        limpiarBaseDeDatos();

        // Pruebas
        registrarUsuario("usuario1@mail.com", "Usuario Uno");
        registrarUsuario("usuario2@mail.com", "Usuario Dos");
        System.out.println("Usuarios registrados");

        añadirComentario("usuario1@mail.com", "Excelente película", 9);
        añadirComentario("usuario2@mail.com", "No me gustó mucho", 6);
        añadirComentario("usuario1@mail.com", "La banda sonora es increíble", 10);
        System.out.println("Comentarios añadidos");

        System.out.println("Comentarios con valoración >= 8:");
        listarMejoresComentarios(8);

        System.out.println("Eliminando usuario1@mail.com...");
        eliminarUsuario("usuario1@mail.com");

        System.out.println("Comentarios después de eliminar usuario1:");
        listarMejoresComentarios(0);
    }
}