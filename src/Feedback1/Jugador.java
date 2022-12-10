package Feedback1;

public class Jugador {

    //ATRIBUTOS DE JUGADOR
    String nombre;
    String personaje;
    Perfil perfil;

    //MÉTODO CONSTRUCTOR CON 2 PARAMETROS
    public Jugador(String nombre, String personaje) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.perfil = new Perfil(0, 0, 0);

    }

    //METODO CAMBIAR PERFIL
    public void cambiarPerfil(int i, int i1, int i2) {
        this.perfil = new Perfil(i, i1, i2);
    }

    //METODO TOSTRING
    @Override
    public String toString() {
        return
                "\n" + nombre + ", " + personaje +
                        "\n" + perfil;
    }

    //METODO PARA CAMBIAR LOS PERSONAJES DE ELFO A ENANO Y VICEVERSA
    public void intercambiaraPersonajes(Jugador j) {

        if (j.getPersonaje().equals("Elfo")) {
            this.setPersonaje("Elfo");
            j.setPersonaje(("Enano"));
        } else if (j.getPersonaje().equals("Enano")) {
            this.setPersonaje("Enano");
            j.setPersonaje(("Elfo"));
        }

    }

    //GETTERS Y SETTERS DE FORMA AUTOMATICA
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    //METODO PARA OBTENER EL NIVEL DEL PERFIL DESDE LA CLASE JUGADOR DE UN JUGADOR QUE DEVUELVE UN INT
    public int nivelPerfil() {
        int nivel;
        nivel = getPerfil().getCarisma() + getPerfil().getSuerte() + getPerfil().getValor();
        return nivel;
    }

    //METODO NO ABREVIADO PARA VALORAR QUE JUGADOR TIENE MAS NIVEL DE PERFIL DEVUELVE UN BOOLEAN
    public boolean ganaAJugador(Jugador j) {
        int nivel = perfil.nivelPerfil();
        boolean combate = false;
        if (j.nivelPerfil() < nivel) {
            combate = true;
        }
        return combate;
    }
}
//FIN