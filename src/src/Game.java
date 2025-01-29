
import java.util.Random;

public class Game {
    private int randomNumber;
    private final int possibleNumbers=100;
    public Game()
    {
       this.randomNumber=0;

    }
    public void start() {
        generateRandomNumber();
        System.out.println("🔢 Se ha generado un número aleatorio. ¡Intenta adivinarlo!");
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(100) + 1; // Número entre 1 y 100
    }
}

