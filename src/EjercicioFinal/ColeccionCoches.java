package EjercicioFinal;


//CLASE COLLECION COCHES
public class ColeccionCoches {


    //CREACION DE ATRIBUTOS, UNA CONSTANTE DE TIPO FINAL ENTERO, OTRA DE TIPO ENTERO VARIABLE Y UN
    //ARRAY DE OBJETOS COCHE CON NOMBRE ALMACENDECOCHES
    static Coche[] almacenCoches;
    static int cuantosCoches;
    static final int MAX = 10;

    //CONSTRUCTOR QUE INICIALIZA EL ARRAY Y EL CONTADOR A 0
    ColeccionCoches() {
        almacenCoches = new Coche[MAX];
        cuantosCoches = 0;

    }

    //METODO STRING CON 50 PUNTITOS QUE MUESTRA LOS DATOS DE CADA COCHE
    @Override
    public String toString() {
        String puntos = "";
        String todo = "";

        for (int i = 0; i < 50; i++) {
            puntos += ".";
        }

        for (int i = 0; i < MAX; i++) {
            if (almacenCoches[i] != null) {
                todo = almacenCoches[i].toString() + "\n" + puntos + "\n";
            }
        }
        return todo;
    }

    //METODO PARA AÑADIR OBJETOS COCHE AL ARRAY
    public static void añadirCoche(Coche coche) {

        if (cuantosCoches < MAX) {
            ColeccionCoches.almacenCoches[cuantosCoches] = coche;
            cuantosCoches++;
            System.out.println("se ha añadido con exito");
        }
    }

    //METODO PARA BORRAR OBJETOS DE TIPO COCHE DEL ARRAY INTRODUCIENDO UN ID POR PARAMETROS
    public boolean borrarCoche(int identificador) {
        for (int i = 0; i < almacenCoches.length; i++) {
            if (almacenCoches[i] != null && almacenCoches[i].getIdentificador() == identificador) {
                almacenCoches[i] = null;
                cuantosCoches--;
                return true;
            }
        }
        return false;
    }


    //METODO QUE COMPARA QUE FECHA DE MATRICULACION ES MAS ANTIGUA. NO CONTEMPLA FECHAS IGUALES
    public String mostrarMasAntigua() {

        String antiguo = null;

        for (int i = 0; i < almacenCoches.length; i++) {

            if (almacenCoches[i].getFecha().getAño() > almacenCoches[i].getFecha().getAño()) {
                antiguo = String.valueOf(almacenCoches[i]);
                if (almacenCoches[i].getFecha().getMes() > almacenCoches[i].getFecha().getMes()) {
                    antiguo = String.valueOf(almacenCoches[i]);
                    if (almacenCoches[i].getFecha().getDia() > almacenCoches[i].getFecha().getDia()) {
                        antiguo = String.valueOf(almacenCoches[i]);
                    }
                }
            }
        }
        return antiguo;
    }


    //DADO UN KILOMETRAJE POR PARAMETRO DICE CUANTOS COCHES HAY EN EL ARRAY CON MENOS KILOMETROS QUE EL PARAMETRO
    public static int mostrarPorKilometros(int kilometros) {
        int contador = 0;
        for (int i = 0; i < almacenCoches.length; i++) {
            if (almacenCoches[i].getKilometros() > kilometros) {
                contador++;
            }
        }

        return contador;
    }
}

//fin del trabajo final
//Alumno: Antonio José Arenal Armesto
//CP:141350