//NP:141350 Arenal Armesto Antonio José
//Feedback 1 Apollo 11 Launcher


import javax.sound.sampled.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Apollo11Model {

    //DECLARACION DE VARIABLES
    public static final int COUNTDOWN_PHASES = 4;
    public int totalSeconds;
    public boolean countdownActive;
    public boolean launchCancelled;
    public int currentPhaseIndex;
    public int remainingTime;

    //SECUENCIAS DE LANZAMIENTO
    String[] phaseNames = {"Preparación inicial", "Verificación de sistemas", "Secuencia de ignición", "Despegue"};

    //CONSTRUCTOR
    public Apollo11Model() {
        this.countdownActive = false;
        this.launchCancelled = false;
        this.currentPhaseIndex = 0;
        this.remainingTime = 0;
    }


    public void monitorLaunch() {
        //INICIALIZACION DE HILO
        new Thread(() -> {
            while (countdownActive) {

                //DECLARACION Y MUESTRA DEL ESTADO
                String estado = launchCancelled ? "Estado: Cancelado" : "Estado: Activo";
                System.out.println(estado);

                try {
                    Thread.sleep(500); // PAUSA DE MEDIO SEGUNDO
                } catch (InterruptedException e) {
                    System.out.println("Monitoreo interrumpido");
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    //INICIO CUENTA ATRAS SINCRONIZADO
    public synchronized void startCountdown(int totalSeconds, Apollo11View view) throws InterruptedException {
        countdownActive = true;
        launchCancelled = false;
        Thread launchThread = new Thread(() -> {
            try {
                executeLaunch(totalSeconds, view);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        launchThread.start();
    }

    //FASE DE EJECUCION
    private void executePhase(int duration, int totalTime, String phaseDescription, Apollo11View view) throws InterruptedException {
        for (int i = 0; i < duration; i++) {
            if (launchCancelled) {
                SwingUtilities.invokeLater(() -> {
                    view.getCountdownLabel().setText("Lanzamiento cancelado.");
                    view.getProgressBar().setValue(0);
                });
                return;
            }

            remainingTime = totalTime - i;
            int progress = (int) (((double) remainingTime / this.totalSeconds) * 100);
            SwingUtilities.invokeLater(() -> {
                view.getCountdownLabel().setText(phaseDescription + ": " + remainingTime + " segundos restantes");
                view.getProgressBar().setValue(progress);
            });

            Thread.sleep(1000); //ESPERA DE UN SEGUNDO
        }
    }

    //SECUENCIA DE EJECUCION
    private void executeLaunch(int totalSeconds, Apollo11View view) throws InterruptedException {
        this.totalSeconds = totalSeconds;
        int phaseDuration = totalSeconds / COUNTDOWN_PHASES;
        int elapsedTime = 0;
        monitorLaunch();

        for (int phase = 0; phase < COUNTDOWN_PHASES; phase++) {
            if (launchCancelled) {
                break; // SALE DEL BUCLE SI EL LANZAMIENTO SE CANCELA
            }

            if (phase < COUNTDOWN_PHASES - 1) {
                executePhase(phaseDuration, totalSeconds - elapsedTime, phaseNames[phase], view);
            } else {
                executePhase(totalSeconds - elapsedTime, totalSeconds - elapsedTime, phaseNames[phase], view);
            }
            elapsedTime += phaseDuration;
        }

        // MOSTRAR UN CUADRO DE DIALOGO SI SE CANCELA SE USA LA VISTA UN MENSAJE DE CANCELACION
        if (launchCancelled) {
            view.showCancellationDialog();
        } else {
            // SI EL LANZAMIENTO NO SE CANCELA SE USA LA VISTA UN MENSAJE DE EXITO
            view.showLaunchSuccessfulDialog();
        }

        // CIERRE DE LA APP TRAS MOSTRAR EL DIALOGO
        System.exit(0);
    }

    //METODOS DE LA CUENTA ACTIVA O CANCELADA
    public boolean isCountdownActive() {
        return countdownActive;
    }

    public void setCountdownActive(boolean countdownActive) {
        this.countdownActive = countdownActive;
    }
    public void setLaunchCancelled(boolean launchCancelled) {
        this.launchCancelled = launchCancelled;
    }

    //COMPROBACION SI LA CUENTA ATRAS ESTA COMPLETA
    public boolean isCountdownCompleted() {
        return remainingTime == 0;
    }

   //CANCELACION DEL LANZAMIENTO

    public void cancelLaunch() {
        setLaunchCancelled(true);
        setCountdownActive(false);
    }

    //METODO PARA REPRODUCIR UN AUDIO DE EXITO EN EL LANZAMIENTO
    public static void playWavAudio(String resourcePath) {
        try {
            URL audioUrl = Apollo11Model.class.getResource(resourcePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioUrl);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //METODO PARA REALIZAR UN GUARDADO EN UN ARCHIVO LOG DEL LANZAMIENTO CON SU FORMATO FECHA-HORA EN CASO DE EXITO
    public static void writeSuccessLaunchLog() {
        // Obtén la fecha y hora actual
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);

        // Mensaje de éxito con la fecha y hora actual
        String logMessage = formattedDate + " - Lanzamiento exitoso";

        // Obtén la ruta relativa del archivo de registro
        URL logResource = Apollo11Model.class.getResource("/launches/logs.txt");

        if (logResource != null) {
            String filePath = logResource.getFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(logMessage);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error al escribir en el archivo de registro: " + e.getMessage());
            }
        } else {
            System.err.println("No se pudo obtener la ruta del archivo de registro.");
        }
    }
    //METODO PARA REALIZAR UN GUARDADO EN UN ARCHIVO LOG DEL LANZAMIENTO CON SU FORMATO FECHA-HORA EN CASO DE FALLO
    public static void writeFailedLaunchLog() {

        //OBTENEMOS FECHA ACTUAL
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);

        String logMessage = formattedDate + " - Lanzamiento fallido";

        URL logResource = Apollo11Model.class.getResource("/launches/logs.txt");

        if (logResource != null) {
            String filePath = logResource.getFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(logMessage);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                //MENSAJES DE ERROR
                System.err.println("Error al escribir en el archivo de registro: " + e.getMessage());
            }
        } else {
            //MENSAJES DE ERROR
            System.err.println("No se pudo obtener la ruta del archivo de registro.");
        }
    }
}
