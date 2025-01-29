import java.util.Timer;
import java.util.TimerTask;

/**
 * La clase GameTimer extiende AbstractTimer y gestiona la lógica del temporizador del juego.
 * Permite iniciar, detener y consultar el tiempo restante del temporizador.
 */
public class GameTimer extends AbstractTimer {
    private Timer timer;
    private long startTime;
    private long elapsedTime;

    /**
     * Constructor de la clase GameTimer.
     * Inicializa el temporizador y establece las variables necesarias.
     */
    public GameTimer() {
        this.timer = new Timer();
        this.timeUp = false;
        this.elapsedTime = 0;
    }

    /**
     * Inicia el temporizador con un límite de tiempo especificado.
     * @param timeLimit El tiempo límite en segundos.
     * @throws TimerException Si el tiempo límite es menor o igual a cero o si el temporizador ya está en ejecución.
     */
    @Override
    public void startTimer(int timeLimit) throws TimerException {
        if (timeLimit <= 0) {
            throw new TimerException("El tiempo límite debe ser mayor que cero.");
        }



        this.timeLimit = timeLimit;
        this.timeUp = false;
        this.elapsedTime = 0;


        this.startTime = System.currentTimeMillis();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
            }
        }, timeLimit * 1000);
    }

    /**
     * Detiene el temporizador.
     */
    @Override
    public void stopTimer() {
        timer.cancel();
        this.timeUp = true;
    }

    /**
     * Verifica si el tiempo se ha agotado.
     * @return true si el tiempo ha terminado, false en caso contrario.
     */
    @Override
    public boolean isTimeUp() {
        return timeUp;
    }

    /**
     * Obtiene el tiempo restante en segundos.
     * @return El tiempo restante en segundos. Si el tiempo ya ha pasado, devuelve 0.
     */
    @Override
    public long getTimeLeft() {
        if (timeUp) {
            return 0;
        }


        elapsedTime = (System.currentTimeMillis() - startTime) / 1000;


        long timeLeft = timeLimit - elapsedTime;
        return Math.max(timeLeft, 0);
    }
}
