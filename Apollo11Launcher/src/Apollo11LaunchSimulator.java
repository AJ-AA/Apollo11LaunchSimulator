//NP:141350 Arenal Armesto Antonio José
//Feedback 1 Apollo 11 Launcher


import javax.swing.SwingUtilities;

public class Apollo11LaunchSimulator {
    public static void main(String[] args) {
        //METODO MAIN
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //SE INICIALIZA EL MODELO VISTA-CONTROLADOR
                //-------->>MVC<<<-----------

                Apollo11Model model = new Apollo11Model();
                Apollo11View view = new Apollo11View();
                Apollo11Controller controller = new Apollo11Controller(model, view);
            }
        });
    }
}
