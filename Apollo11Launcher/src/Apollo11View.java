//NP:141350 Arenal Armesto Antonio José
//Feedback 1 Apollo 11 Launcher


import java.awt.*;
import javax.swing.*;

public class Apollo11View {

    //DECLARACION DE VARIABLES
    public final JFrame frame;
    public final JLabel countdownLabel;
    public final JProgressBar progressBar;
    public final JButton startButton;
    public final JButton cancelButton;
    private static final String IN_PROGRESS_MESSAGE = "Fase %d en progreso";
    private static final String STOP_COMPLETE_MESSAGE = "Cuenta regresiva detenida o completada";
    private int phaseIndex;
    private int progress;

    //CONSTRUCTOR
    public Apollo11View() {
        frame = new JFrame("Apollo 11 Launch Simulator");
        countdownLabel = new JLabel("APOLLO 11 LAUNCH:");
        progressBar = new JProgressBar(0, 100);
        startButton = new JButton("Iniciar");
        cancelButton = new JButton("Cancelar");
        setupUI();


    }

    //ACTTUALIZACION DEL ESTADO DE LA CUENTA ATRAS
    public void updateCountdownStatus(boolean countdownActive) {
        SwingUtilities.invokeLater(() -> {
            if (countdownActive) {
                updateCountdownInProgress();
            } else {
                updateCountdownStoppedOrCompleted();
            }
        });
    }

    //ACTUALIZACION DE LA CUENTA ATRAS EN EL PROGRESO DE LAS FASES
    private void updateCountdownInProgress() {
        countdownLabel.setText(String.format(IN_PROGRESS_MESSAGE, (phaseIndex + 1)));
        progressBar.setValue(progress);
    }

    //ACTUALIZACION DE LA CUENTA ATRAS SI ES DETENIDA O COMPLETADA
    private void updateCountdownStoppedOrCompleted() {
        countdownLabel.setText(STOP_COMPLETE_MESSAGE);
        progressBar.setValue(0);
    }

    //METODOS PARA EL CONTROL DE LA VISTA Y EL MONITOREO
    public JFrame getFrame() {
        return frame;
    }

    public JLabel getCountdownLabel() {
        return countdownLabel;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    //SETUPUI SUPER IMPORNTANTE
    public void setupUI() {
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(countdownLabel);
        panel1.add(progressBar);

        JPanel panel2 = new JPanel();
        panel2.add(startButton);
        panel2.add(cancelButton);

        frame.add(panel1);
        frame.add(panel2);

        frame.pack();
        frame.setVisible(true);
    }

    //MOSTRAR MENSAJE DE EXITO CON AUDIO E IMAGEN
    public void showLaunchSuccessfulDialog() {
        Apollo11Model.playWavAudio("/resources/FRASE.wav");

        Icon imagen3 = new ImageIcon(getClass().getResource("/resources/EXITO.png"));

        JOptionPane.showMessageDialog(null, "¡Lanzamiento exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE, imagen3);
        Apollo11Model.writeSuccessLaunchLog();
        System.exit(0);
    }
    //MOSTRAR MENSAJE DE CANCELACION CON IMAGEN
    public void showCancellationDialog() {
        System.out.println("Estado: Cancelado");
        Icon imagen2 = new ImageIcon(getClass().getResource("/resources/CANCELADO.jpg"));
        JOptionPane.showMessageDialog(null, "Lanzamiento cancelado.", "Cancelación", JOptionPane.INFORMATION_MESSAGE, imagen2);
        Apollo11Model.writeFailedLaunchLog();
        System.exit(0);

    }

    //PANEL Y MENSAJE DE INTRO CON IMAGEN
    public void introDialog(){
        Icon imagen1 = new ImageIcon(getClass().getResource("/resources/PRESENTACION.jpg"));


        String mensaje = "<html><div style='text-align: justify; width: 250px;'>" +
                "<strong>Bienvenido al simulador de lanzamiento Apollo 11.</strong><br><br>" +
                "Apolo 11 fue la quinta misión tripulada del Programa Apolo de los Estados Unidos y la " +
                "primera de la historia en lograr que un ser humano llegara a la Luna. La nave Apolo de " +
                "la misión se envió al espacio el 16 de julio de 1969, realizó su alunizaje el 20 de julio " +
                "de ese mismo año y al día siguiente dos astronautas (Armstrong y Aldrin) se " +
                "convirtieron en los primeros en caminar sobre la superficie lunar. El Apolo 11 fue " +
                "impulsado por un cohete Saturno V desde la plataforma LC 39A y lanzado a las " +
                "13:32 UTC del complejo de cabo Kennedy, en Florida (EE. UU.). Oficialmente se " +
                "conoció a la misión como AS-506. La misión fue un hito decisivo de la NASA contra el " +
                "programa espacial de la Unión Soviética durante la carrera espacial y está " +
                "considerada como uno de los momentos más significativos en la historia de la " +
                "humanidad.<br><br>" +
                "Por favor, ingrese la cantidad de segundos para el lanzamiento." +
                "</div></html>";

        JOptionPane.showMessageDialog(null, mensaje, "Información del Lanzamiento", JOptionPane.INFORMATION_MESSAGE, imagen1);

    }

    //PANEL Y MENSAJE DE INTRODUCIR TIEMPO CON IMAGEN
    public String introduceTimeDialog(){
        Icon imagen3 = new ImageIcon(getClass().getResource("/resources/INICIO.jpg"));

        String mensaje2 = "<html><div style='text-align: justify; width: 250px;'>" +
                "El tiempo que introduzca será utilizado para simular las cuatro fases del lanzamiento del Apollo 11 de manera proporcional. " +
                "Cada fase del lanzamiento se dividirá en segmentos iguales basados en el tiempo total que usted especifique, proporcionando así " +
                "una representación cronometrada y secuencial de los eventos desde la preparación inicial hasta el despegue final.<br><br>" +
                "Ingrese la cantidad de segundos:" +
                "</div></html>";
        String input = (String) JOptionPane.showInputDialog(
                null,
                mensaje2,
                "Tiempo de Lanzamiento",
                JOptionPane.QUESTION_MESSAGE,
                imagen3,
                null,
                "");
        return input;
    }
}
