package Feedback1;

import static java.util.Collections.swap;

public class PruebaJugador {

    public static void main(String[] args) {

        //DECLARACION DE JUGADORES

        Jugador j1;
        Jugador j2;

        //INICIALIZAR JUGADORES CON 2 PARAMETROS STRING
        j1 = new Jugador("Juan", "Enano");
        j2 = new Jugador("Pedro", "Elfo");

        //MOSTRAR POR PANTALLA LOS DATOS DE LOS JUGADORES
        System.out.println("_______Personajes_______\n\nPrimer jugador " + j1 + "\n________________________\n");
        System.out.println("Segundo jugador " + j2 + "\n\n");

        //METODO PARA CAMBIAR LOS VALORES DEL PERFIL DE 0 A LOS PARAMETROS
        j1.cambiarPerfil(3, 4, 5);
        j2.cambiarPerfil(5, 6, 7);

        //SOUT DE LOS VALORES CAMBIADOS
        System.out.println("___Cambio_De_Perfiles___\n\nPrimer jugador " + j1 + "\n________________________\n");
        System.out.println("Segundo jugador " + j2 + "\n\n");

        //METODO PARA CAMBIAR LOS PERSONAJES ENTRE SI
        j1.intercambiaraPersonajes(j2);

        //SOUT DE LOS VALORES CAMBIADOS
        System.out.println("__Cambio_De_Personajes__\n\nPrimer jugador " + j1 + "\n________________________\n");
        System.out.println("Segundo jugador " + j2 + "\n\n");

        //SOUT
        System.out.println("\n_____Gana_A_Jugador_____\n");

        //SOUT DE QUE JUGADOR GANA A QUIEN RETORNANDO UN BOOLEAN
        System.out.println("J2 VS J1: " + j1.ganaAJugador(j2));
        System.out.println("J1 VS J2: " + j2.ganaAJugador(j1));
    }
}

//FIN
