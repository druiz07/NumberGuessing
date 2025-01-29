// AbstractTimer.java
public abstract class AbstractTimer {
    protected int timeLimit;
    protected boolean timeUp;

    public abstract void startTimer(int timeLimit);

    public abstract void stopTimer();

    public abstract boolean isTimeUp();

    public abstract long getTimeLeft();
}
