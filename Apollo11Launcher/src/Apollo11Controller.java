//NP:141350 Arenal Armesto Antonio José
//Feedback 1 Apollo 11 Launcher


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Apollo11Controller {

    //DECLARACION DE VARIABLES
    private final Apollo11Model model;
    private final Apollo11View view;


    //CONSTRUCTOR
    public Apollo11Controller(Apollo11Model model, Apollo11View view) {
        this.model = model;
        this.view = view;
        setupListeners();
    }

    //LISTENERS
    private void setupListeners() {
        view.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCountdownWithInput();
            }
        });
        view.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.cancelLaunch();
            }
        });

    }

    //EMPIEZA LA CUENTA ATRAS
    private void startCountdownWithInput() {
        int totalSeconds = getInputSeconds();
        if (totalSeconds > -1) {
            try {
                initiateCountdown(totalSeconds);
            } catch (InterruptedException ex) {
                handleInterruptedException(ex);
            }
        }
    }

    private void initiateCountdown(int totalSeconds) throws InterruptedException {
        model.startCountdown(totalSeconds, view);
        view.updateCountdownStatus(model.isCountdownActive());

        String logMessage = "Lanzamiento exitoso (o cancelado) con " + totalSeconds + " segundos.";
    }

    private void handleInterruptedException(InterruptedException ex) {
        throw new RuntimeException(ex);
    }

    //INTRODUCION DE SEGUNDOS
    private int getInputSeconds() {

        view.introDialog();
        String input=view.introduceTimeDialog();


        if (input != null && !input.isEmpty()) { //COMPROBACION DE QUE NO ESTA VACIO
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view.getFrame(), "Por favor, ingrese un número válido.");
            }
        }
        return -1;
    }
}