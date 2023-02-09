package EjercicioFinal;

//CLASE FECHA
public class Fecha {


    //ATRIBUTOS DE TIPO ENTERO PARA DIA MES Y AÑO
    int dia;
    int mes;
    int año;

    //CREACION DE GETTRS Y SETTERS DE FORMA AUTOMATICA
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    //CONSTRUCTOR QUE INICIALIZA LA CLASE CON LOS ATRIBUTOS A CERO
    Fecha() {
        dia = 0;
        mes = 0;
        año = 0;
    }

    //CONSTRUCTOR CON PARAMETROS
    Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;

    }

    //METODO PARA VERIGICAR SI ES VALIDA UNA FECHA PARA VALORES COMPRENDIDOS ENTRE 1 Y 31 PARA LOS DIAS Y 1 Y 12 PARA LOS MESES( AÑO INDIFERENTE)
    public static boolean sonDatosValidos(int dia, int mes, int año) {

        if (dia <= 31 && dia >= 1) {

            if (mes <= 12 && mes >= 1) {
                return true;
            }
        } else {
            return false;
        }
        return true;
    }
//METODO QUE DEVUELVE UN BOOLEANO TRAS PASAR POR PARAMETROS Y DECIR QUE FECHA ES ANTERIOR, TAMBIEN SI SON IGUALES.

    public boolean esAnterior(int dia, int mes, int año) {
        if (this.año < año) {

            return true;

        } else if (this.año == año) {

            if (this.mes < mes) {

                return true;

            } else if (this.mes == mes) {

                return this.dia < dia;

            } else {
                System.out.println("Son iguales las fechas.");
            }
        }
        return false;
    }

    //METODO TOSTRING PARA LAS FECHAS CON SEPARACION DE "/"
    @Override
    public String toString() {
        return "(" +
                dia +
                "/" + mes +
                "/" + año +
                ')';
    }
}

//fin del trabajo final
//Alumno: Antonio José Arenal Armesto
//CP:141350

