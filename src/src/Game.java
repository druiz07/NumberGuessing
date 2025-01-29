import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int randomNumber;
    private List<Integer>attemps;
    private  int maxRange = 0;
    public Game()
    {
       this.randomNumber=0;
       this.attemps= new ArrayList<>();

    }
    public void start(int difficulty) {


        switch (difficulty) {
            case 1: // Fácil: 1-10
                maxRange = 10;
                break;
            case 2: // Medio: 1-50
                maxRange = 50;
                break;
            case 3: // Difícil: 1-100
                maxRange = 100;
                break;
            default:
                System.out.println("Opción inválida. Usando rango fácil.");
                maxRange = 10;
                break;
        }
        generateRandomNumber();
        System.out.println("🔢 Se ha generado un número aleatorio. ¡Intenta adivinarlo!");
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(maxRange) + 1; // Número entre 1 y 100
    }
    public String makeGuess(int guess) {
        // Registrar intento
        this.attemps.add(guess);

        // Verificar el intento
        if (guess == this.randomNumber) {
            return "¡Felicidades! Adivinaste el número en " + this.attemps.size() + " intentos.";
        } else if (guess < this.randomNumber) {
            return "El número es más grande. Intenta nuevamente.";
        } else {
            return "El número es más pequeño. Intenta nuevamente.";
        }
    }
    public List<Integer> getAttempts() {
        return this.attemps;
    }
}

