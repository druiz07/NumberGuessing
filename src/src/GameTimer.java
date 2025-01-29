import java.util.Timer;
import java.util.TimerTask;

public class GameTimer extends AbstractTimer {
    private Timer timer;
    private long startTime;  // Variable para almacenar el tiempo de inicio
    private long elapsedTime;  // Variable para almacenar el tiempo transcurrido

    public GameTimer() {
        this.timer = new Timer();
        this.timeUp = false;
        this.elapsedTime = 0;
    }


    // Implementación del método startTimer
    @Override
    public void startTimer(int timeLimit) {
        this.timeLimit = timeLimit;
        this.timeUp = false;
        this.elapsedTime = 0;  // Reseteamos el tiempo transcurrido

        // Guardamos el tiempo de inicio cuando comenzamos el temporizador
        this.startTime = System.currentTimeMillis();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
            }
        }, timeLimit * 1000);  // El tiempo de ejecución se da en milisegundos
    }

    @Override
    public void stopTimer() {
        timer.cancel();
    }

    @Override
    public boolean isTimeUp() {
        return timeUp;
    }

    // Método para obtener el tiempo restante
    @Override
    public long getTimeLeft() {
        if (timeUp) {
            return 0;
        }

        // Calculamos el tiempo transcurrido en segundos
        elapsedTime = (System.currentTimeMillis() - startTime) / 1000;

        // Calculamos el tiempo restante
        long timeLeft = timeLimit - elapsedTime;
        return Math.max(timeLeft, 0);  // Aseguramos que no sea negativo
    }
}
