import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Apollo11LaunchSimulator {
    private static final int COUNTDOWN_PHASES = 4;

    private final JFrame frame;
    private final JLabel countdownLabel;
    private final JProgressBar progressBar;
    private final JButton startButton;
    private final JButton cancelButton;

    private boolean countdownActive;
    private boolean launchCancelled;

    public Apollo11LaunchSimulator() {
        frame = new JFrame("Apollo 11 Launch Simulator");
        countdownLabel = new JLabel("APOLLO 11 LAUNCH:");
        progressBar = new JProgressBar(0, 100);
        startButton = new JButton("Iniciar");
        cancelButton = new JButton("Cancelar");
        countdownActive = false;
        launchCancelled = false;

        setupUI();
        addListeners();
    }

    private void setupUI() {
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

    private void addListeners() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!countdownActive) {
                    int seconds = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad de segundos:"));

                    startCountdown(seconds);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchCancelled = true;
            }
        });
    }

    private void startCountdown(int seconds) {
        countdownActive = true;
        launchCancelled = false;

        Thread countdownThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = seconds; i >= 0; i--) {
                    if (launchCancelled) {
                        JOptionPane.showMessageDialog(frame, "Lanzamiento cancelado.");
                        resetUI();
                        return;
                    }

                    updateUI(i, seconds);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(frame, "¡Lanzamiento exitoso!");
                resetUI();
            }
        });

        Thread monitorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (countdownActive) {
                    if (launchCancelled) {
                        // Simulación de registro de condiciones del lanzamiento
                        System.out.println("Estado: Cancelado");
                    } else {
                        // Simulación de registro de condiciones del lanzamiento
                        System.out.println("Estado: Activo");
                    }

                    try {
                        Thread.sleep(500); // Espera para verificar el estado
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        countdownThread.start();
        monitorThread.start();
    }

    private void updateUI(int remainingSeconds, int totalSeconds) {
        double progress = (double) remainingSeconds / totalSeconds * 100;
        progressBar.setValue((int) progress);
        countdownLabel.setText("Cuenta regresiva: " + remainingSeconds + " segundos restantes");
    }

    private void resetUI() {
        countdownActive = false;
        progressBar.setValue(0);
        countdownLabel.setText("Ingrese la cantidad de segundos:");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Apollo11LaunchSimulator();
            }
        });
    }
}

