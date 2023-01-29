package Feedback2;

import java.util.Scanner;

public class Triangulo {
    static int lado1, lado2, lado3;


    public static void main(String[] args) {

        //-----------------------EJERCICIO 1---------------------------

        Scanner sc = new Scanner(System.in); // crear un objeto Scanner

        System.out.println("Todos los valores introducidos para este ejercicio, han de ser un numero par entre 2 y 20 inclusivamente\n"); //enunciado

        do {

            System.out.println("Introduce el lado 1: "); //introducir datos por pantalla
            lado1 = sc.nextInt();
            System.out.println("Introduce el lado 2: ");
            lado2 = sc.nextInt();
            System.out.println("Introduce el lado 3: ");
            lado3 = sc.nextInt();

            //condicion de numero par entre 2 o 20
        } while ((lado1 < 2 || lado1 > 20 || lado1 % 2 != 0) || (lado2 < 2 || lado2 > 20 || lado2 % 2 != 0) || (lado3 < 2 || lado3 > 20 || lado3 % 2 != 0));

        if ((lado1 + lado2 > lado3) && (lado2 + lado3 > lado1) && (lado1 + lado3 > lado2)) {
            System.out.print("Se trata de un triángulo");
        } else {
            System.out.print("NO es un triángulo");
        }

        //-----------------------EJERCICIO 2---------------------------

        System.out.print("\n\n\n\n"); //El programa escribe cuatro líneas en blanco para separar del siguiente ejercicio

        //-----------------------EJERCICIO 3---------------------------

        //Declaracion de variables

        int mayor = 10, menor = 5;

        //bucle For para imprimir el paralilepípedo formado de asteriscos

        for (int i = 0; i < menor; i++) {
            System.out.print("\n");
            mayor = mayor - 1;

            for (int j = 0; j < mayor + menor; j++) {
                System.out.print("*"); //El programa escribe por pantalla los asteriscos
            }
        }

        //-----------------------EJERCICIO 4---------------------------

        System.out.println("\n\n\n\n"); //El programa escribe cuatro líneas en blanco para separar del siguiente ejercicio

        //-----------------------EJERCICIO 5---------------------------

        //declaración de variables


        int dia1, mes1, anio1, dia2, mes2, anio2;

        //parte de dia1mes1anio1

        do {
            System.out.println("Introduce dia1: "); //introducir datos por pantalla
            dia1 = sc.nextInt();
        } while (dia1 < 1 || dia1 > 31);

        do {
            do {
                System.out.println("Introduce mes1: "); //introducir datos por pantalla
                mes1 = sc.nextInt();

            } while (mes1 < 1 || mes1 > 12 || (dia1 == 31 && (mes1 == 2 || mes1 == 4 || mes1 == 6 || mes1 == 9 || mes1 == 11)));//condición para ver que meses tienen 31 dias.

            do {
                System.out.println("Introduce anio1: "); //introducir datos por pantalla
                anio1 = sc.nextInt();

            } while (anio1 < 1);

        } while ((dia1 == 29 && mes1 == 2 && anio1 % 4 != 0 && anio1 % 100 != 0 && anio1 % 400 != 0)); //Condición para evaluar si el 29/2 existe en el año bisiesto

        //Parte de dia2mes2anio2

        do {
            System.out.println("Introduce dia2: "); //introducir datos por pantalla
            dia2 = sc.nextInt();
        } while (dia2 < 1 || dia2 > 31);

        do {
            do {
                System.out.println("Introduce mes2: "); //introducir datos por pantalla
                mes2 = sc.nextInt();

            } while (mes2 < 1 || mes2 > 12 || (dia2 == 31 && (mes2 == 2 || mes2 == 4 || mes2 == 6 || mes2 == 9 || mes2 == 11)));//condición para ver que meses tienen 31 dias.

            do {
                System.out.println("Introduce año2: "); //introducir datos por pantalla
                anio2 = sc.nextInt();

            } while (anio2 < 1);

        } while ((dia2 == 29 && mes2 == 2 && anio2 % 4 != 0 && anio2 % 100 != 0 && anio2 % 400 != 0));//Condición para evaluar si el 29/2 existe en el año bisiesto

        //Muestra por pantalla que fecha es más antigua

        //ifs anidados para ver que fecha es más antigua atendiendo primero a los años, meses y por último dias

        if (anio1 < anio2) {
            System.out.println("La fecha: " + dia1 + "/" + mes1 + "/" + anio1 + " es mas antigua que " + dia2 + "/" + mes2 + "/" + anio2);
        } else if (anio1 > anio2) {
            System.out.println("La fecha: " + dia2 + "/" + mes2 + "/" + anio2 + " es mas antigua que " + dia1 + "/" + mes1 + "/" + anio1);
        } else {
            if (mes1 < mes2) {
                System.out.println("La fecha: " + dia1 + "/" + mes1 + "/" + anio1 + " es mas antigua que " + dia2 + "/" + mes2 + "/" + anio2);
            } else if (mes1 > mes2) {
                System.out.println("La fecha: " + dia2 + "/" + mes2 + "/" + anio2 + " es mas antigua que " + dia1 + "/" + mes1 + "/" + anio1);
            } else {
                if (dia1 < dia2) {
                    System.out.println("La fecha: " + dia1 + "/" + mes1 + "/" + anio1 + " es mas antigua que " + dia2 + "/" + mes2 + "/" + anio2);
                } else if (dia1 > dia2) {
                    System.out.println("La fecha: " + dia2 + "/" + mes2 + "/" + anio2 + " es mas antigua que " + dia1 + "/" + mes1 + "/" + anio1);

                } else {
                    System.out.println("las fechas son iguales");
                }
            }
        }
        //-----------------------EJERCICIO 6---------------------------

        int numero;

        do {
            System.out.println("Introduce un número impar entre 20 y 50: "); //El programa pide por pantalla un número
            numero = sc.nextInt();

        } while ((numero < 20 || numero > 50) || (numero % 2 == 0));////Condición de que el número sea IMPAR y entre 20 y 50.

        //-----------------------EJERCICIO 7---------------------------

        //Declaración de un array de misNúmeros

        int[] misNumeros = new int[100];

        //-----------------------EJERCICIO 8---------------------------

        //rellenar el array con el método random de la clase MATH.

        for (int i = 0; i < misNumeros.length; i++) {
            misNumeros[i] = (int) (Math.random() * 100);
            System.out.println(misNumeros[i]);
        }

        //-----------------------EJERCICIO 9---------------------------

        //Calculamos la media de todos los valores del array misNúmeros
        int total = 0;

        for (int i = 0; i < misNumeros.length; i++) {

            total = total + misNumeros[i];

        }
        int media;
        media = total / misNumeros.length;

        //El programa muestra por pantalla la media de la misma.

        System.out.println("La media del array es: " + media);


        //-----------------------EJERCICIO 10---------------------------

        ///contador de pares e impares

        int cantidadPares = 0, cantidadImpares = 0;

        for (int i = 0; i < misNumeros.length; i++) {
            if (misNumeros[i] % 2 == 0) {
                cantidadPares++;
            }
            cantidadImpares = misNumeros.length - cantidadPares;
        }

        System.out.println("La cantidad de números pares es: " + cantidadPares); //Muestra por pantalla la cantidad
        System.out.println("La cantidad de números impares es: " + cantidadImpares);

        //-----------------------EJERCICIO 11---------------------------

        //Recorremos el array guardando el mayor y el menor en las variables

        for (int i = 0; i < misNumeros.length; i++) {

            if (misNumeros[i] > mayor) {
                mayor = misNumeros[i];
            } else if (misNumeros[i] < menor) {
                menor = misNumeros[i];
            }


        }
        //El programa escribe por pantalla los valores de Mayor y Menor

        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);

        //-----------------------EJERCICIO 12---------------------------

        //Guardamos en un String la célebre frase de la película Cyberpunk Bladerunner

        String bladeRunner = "Yo he visto cosas que vosotros no creeríais:\nAtacar naves en llamas más allá de Orión. He visto Rayos-C brillar en la oscuridad cerca de la puerta de Tannhäuser. Todos esos momentos se perderán en el tiempo... como lágrimas en la lluvia. Es hora de morir";

        //-----------------------EJERCICIO 13---------------------------

        //Creamos un array de caracteres con la longitud del String.

        Character[] bladeRunnerArray = new Character[bladeRunner.length()];

        //Recorremos el array rellenando con cada caracter del String

        for (int i = 0; i < bladeRunnerArray.length; i++) {
            bladeRunnerArray[i] = bladeRunner.charAt(i);

        }
        //El programa muestra por pantalla el número de caracteres que tiene

        System.out.println("La cita de la película tiene " + bladeRunnerArray.length + " caracteres.");

        //-----------------------EJERCICIO 14---------------------------

        //creamos las variables de tipo carácter

        Character a = 'a';
        Character e = 'e';
        Character i = 'i';

        //utilizamos el método cuentaLetras para mostrar por pantalla la cantidad de caracteres que hay de "a" "e" e "i".

        System.out.println("En célebre frase de Blade Runner hay: " + cuentaLetras(bladeRunnerArray, a) + " letras 'A'");
        System.out.println("En célebre frase de Blade Runner hay: " + cuentaLetras(bladeRunnerArray, e) + " letras 'E'");
        System.out.println("En célebre frase de Blade Runner hay: " + cuentaLetras(bladeRunnerArray, i) + " letras 'I'");
    }

    //-----------------------EJERCICIO 15---------------------------

    //creación del método cuentaLetras
    public static int cuentaLetras(Character[] array, Character letra) {
        int numerodeveces = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == letra) {
                numerodeveces++;
            }
        }
        return numerodeveces;
    }
}

//fin del feedback
//Alumno: Antonio José Arenal Armesto
//CP:141350






