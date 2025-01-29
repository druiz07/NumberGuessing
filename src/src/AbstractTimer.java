/**
 * Clase timer absstracta timer que contiene los metodos que se definen en el timer
 * */
public abstract class AbstractTimer {
    protected int timeLimit;
    protected boolean timeUp;

    public abstract void startTimer(int timeLimit) throws TimerException;

    public abstract void stopTimer();

    public abstract boolean isTimeUp();

    public abstract long getTimeLeft();
}
