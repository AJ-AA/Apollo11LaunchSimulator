package EjercicioFinal;

import java.util.Date;

public class Coche {

    //DECLARACION DE LOS ATRIBUTOS DE COCHE, TIPO FECHA Y 2 ENTEROS.
    Fecha fecha;
    int kilometros;
    int identificador;


    //CONSTRUCTOR DE LA CLASE CON PARAMETROS
    Coche(Fecha fecha, int kilometros, int identificador) {
        this.fecha = fecha;
        this.kilometros = kilometros;
        this.identificador = identificador;
    }

    //METODO TOSTRING SEPARADO POR COMAS
    @Override
    public String toString() {
        return fecha.toString() + ", " + kilometros + ", " + identificador;
    }

    //CREACION DE GETTERS Y SETTERS DE FORMA AUTOMATICA
    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}

//fin del trabajo final
//Alumno: Antonio José Arenal Armesto
//CP:141350


