package Feedback1;

public class Perfil {

    //ATRIBUTOS DE PERFIL
    private int valor;
    private int carisma;
    private int suerte;

    //CONSTRUCTOR DE PERFIL CON 3 PARAMETROS TIPO INT
    public Perfil(int valor, int carisma, int suerte) {
        this.valor = valor;
        this.carisma = carisma;
        this.suerte = suerte;
    }

    //GETTERS Y SETTERS AUTOMATICOS
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getSuerte() {
        return suerte;
    }

    public void setSuerte(int suerte) {
        this.suerte = suerte;
    }

    //METODO TOSTRING CON FORMATO DETERMINADO
    @Override
    public String toString() {
        return "\nValor:   " + valor +
                "\nCarisma: " + carisma +
                "\nSuerte:  " + suerte;
    }

    //METODO PARA OBTENER EL NIVEL DE PERFIL DESDE LA CLASE PERFIL QUE DEVUELVE UN INT
    public int nivelPerfil() {
        int nivel;
        nivel = getCarisma() + getSuerte() + getValor();
        return nivel;
    }
}
//FIN