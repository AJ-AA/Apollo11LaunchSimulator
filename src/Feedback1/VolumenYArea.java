package Feedback1;

import java.util.Scanner;

public class VolumenYArea {

//atributos
    static double A;
    static double V;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in); // crear un objeto Scanner

        System.out.print("¿Valor del radio de la esfera? ");

        int r = sc.nextInt();

        A = ((2.0/3.0)*(((2*r*2*Math.PI*r))+(2*Math.PI*r*r)));
        V = ((2.0/3.0)*(Math.PI*r*r*2*r));

        System.out.println("Dada una esfera de radio " + r + " unidades");
        System.out.println("Su volumen es: " + V + " unidades cúbicas");
        System.out.println("Y su área es: " + A + " unidades cuadradas");
//FIN
    }
}

