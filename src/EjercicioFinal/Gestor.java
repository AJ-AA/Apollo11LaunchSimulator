package EjercicioFinal;


import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.Scanner;

import static EjercicioFinal.ColeccionCoches.almacenCoches;
import static EjercicioFinal.ColeccionCoches.añadirCoche;


public class Gestor {

    //METODO MAIN
    public static void main(String[] args) {

        //CREACIONDE UN OBJETO COLLECIONCOCHES

        ColeccionCoches misCoches = new ColeccionCoches();

        //ENTRADA POR TECLADO
        Scanner teclado = new Scanner(System.in);

        //TIPO ENTERO PARA LA OPCION

        int option;

        //BUCLE DEL MENU
        do {
            System.out.println("##############_MENU_DE_OPCIONES_############\n" +
                    "|                                          |\n" +
                    "|    1. Mostrar coches                     |\n" +///SE MUESTRA POR PANTALLA UN MENU DE OPCIONES BASICO
                    "|    2. Añadir coche                       |\n" +
                    "|    3. Borrar coche                       |\n" +
                    "|    4. Consultar coche más antiguo        |\n" +
                    "|    5. Consultar coches por kilometraje   |\n" +
                    "|    6. Terminar                           |\n" +
                    "|    7. Recuperar                          |\n" +
                    "|                                          |\n" +
                    "############################################\n\n" +
                    "Introduce una opción:");

            option = teclado.nextInt();//SE ELIGE LA OPCION
            switch (option) {
                case 1:
                    //OPCION 1 SE MUESTRAN LOS DATOS DEL ARRAY
                    System.out.println("LISTADO:");
                    System.out.println(Arrays.toString(almacenCoches));

                    break;
                case 2:
                    //OPCION 2 SE AÑADE UN NUEVO COCHE PRIMERO PIDIENDO LA FECHA DE MATRICULACION
                    System.out.println("Introduce el día de matriculación: ");
                    int dia1 = teclado.nextInt();

                    System.out.println("Introduce el mes de matriculación: ");

                    int mes1 = teclado.nextInt();
                    System.out.println("Introduce el año de matriculación: ");

                    int año1 = teclado.nextInt();

                    // SE COMPRUEBA SI ES VALIDA LA FECHA
                    if (Fecha.sonDatosValidos(dia1, mes1, año1)) {
                        //EN CASO AFIRMATIVO SE INTRODUCE EL KILOMETRAJE
                        System.out.println("Introduce numero de kilometros: ");

                        int kilometross = teclado.nextInt();
                        //SE INTRODUCE UN NUMERO IDENTIFICADOR UNICO
                        System.out.println("Introduce numero de identificador: ");
                        int identificador = teclado.nextInt();

                        //SE CREA UN OBJETO FECHA
                        Fecha fecha1 = new Fecha(dia1, mes1, año1);

                        //SE CREA UN OBJETO COCHE
                        Coche nuevo = new Coche(fecha1, kilometross, identificador);

                        //SE UTILIZA EL METODO PARA AÑADIR EL OBJETO COCHE
                        ColeccionCoches.añadirCoche(nuevo);

                    } else {//IMPRIMIMOS POR PANTALLA SI NO ES CORRECTO
                        System.out.println("la fecha no es valida, intentelo de nuevo, mas tarde. ");

                    }//IMPRIMIMOS SI ES CORRECTO
                    System.out.println("Coche añadido satisfactoriamente.");
                    break;

                case 3://OPCION 3 PARA BORRAR UN OBJETO DADO SU ID
                    System.out.println("Se leerá del teclado un valor para el identificador del \n" +
                            "coche para borrar: ");

                    int identificador = teclado.nextInt();
                    boolean borrado = misCoches.borrarCoche(identificador);

                    if (borrado) {
                        System.out.println("Coche borrado correctamente.");
                    } else {
                        System.out.println("Coche no borrado.");
                    }
                    break;

                case 4://OPCION 4 QUE USA EL METODO MOSTRAR MAS ANTIGUA.
                    try {
                        System.out.println("La matricula mas antigua es: ");
                        misCoches.mostrarMasAntigua();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5: // OPCION 5 DADO UN PARAMETRO QUE NOS PIDE POR TECLADO LO COMPARA Y MUESTRA CUANTOS COCHES TIENEN MENOS KILOMETRAJE DEL PARAMETRO INTRODUCIDO
                    System.out.println("Leerá del teclado un valor para el \n" +
                            "mínimo de kilometros: ");
                    int minimo = teclado.nextInt();
                    ColeccionCoches.mostrarPorKilometros(minimo);
                case 6://OPCION 6 DONDE SE REALIZA UN VOLCADO DE DATOS A UN DOCUMENTO DATOS.TXT
                    System.out.println("Ha finalizado el programa. A continuación se guardaran los datos.");

                    try {
                        FileWriter writer = new FileWriter("datos.txt");

                        for (int i = 0; i < almacenCoches.length; i++) {
                            Coche cocheActual = almacenCoches[i];
                            if (cocheActual != null) {
                                writer.write(cocheActual.toString());
                                writer.write(System.lineSeparator());
                            }
                        }
                        writer.close();
                    } catch (IOException e) {//SE MUESTRA UNA EXCEPCION
                        System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
                    }
                    System.out.println("Datos guardados. Continua el programa. ");
                case 7://OPCION 7 DONDE SE INTENTA EXTRAER EL FICHERO PARA DEVOLVERLO AL ARRAY DE OBJETOS

            }
        } while ((option < 8) && (option > 0));//CONDICION PARA QUE EL MENU SE SIGA REPITIENDO

    }
}

//fin del trabajo final
//Alumno: Antonio José Arenal Armesto
//CP:141350

