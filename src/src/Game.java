import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int randomNumber;
    private GameTimer timer;
    private List<String>attemps;
    private  int maxRange = 0;
    public Game()
    {
       this.randomNumber=0;
       this.attemps= new ArrayList<>();
       this.timer= new GameTimer();

    }
    public GameTimer getTimer()
    {
        return this.timer;
    }
    public int getRandomNumber()
    {
        return this.randomNumber;
    }
    public void start(int difficulty) {


        switch (difficulty) {
            case 1:
                maxRange = 10;
                timer.startTimer(30);
                break;
            case 2:
                maxRange = 50;
                timer.startTimer(45);
                break;
            case 3:
                maxRange = 100;
                timer.startTimer(60);
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
        this.randomNumber = rand.nextInt(maxRange) + 1;
    }

    public boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }


    public boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }


    public String getRange(int number) {
        if (number <= 10) {
            return "El número está entre 1 y 10.";
        } else if (number <= 20) {
            return "El número está entre 11 y 20.";
        } else if (number <= 50) {
            return "El número está entre 21 y 50.";
        } else if (number <= 75) {
            return "El número está entre 51 y 75.";
        } else {
            return "El número está entre 76 y 100.";
        }
    }


    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    public boolean isCloseToMultipleOf10(int number) {
        return Math.abs(number % 10) <= 3;
    }
    public String getTimeRemaining() {
        if (timer.isTimeUp()) {
            return "El tiempo se agotó.";
        }
        return "Tiempo restante: " + timer.getTimeLeft() + " segundos";
    }

    public String makeGuess(int guess) {
        StringBuilder result = new StringBuilder();

        if (timer.isTimeUp()) {
            return "¡El tiempo se agotó! El número era " + this.randomNumber;
        }

        if (guess < this.randomNumber) {
            result.append("El número es mayor. ");
        } else if (guess > this.randomNumber) {
            result.append("El número es menor. ");
        } else {
            result.append("¡Felicidades! Has adivinado el número. ");
        }

        if (guess != this.randomNumber) {
            if (guess > this.randomNumber) {
                result.append(" ¡Te has pasado! ");
            } else {
                result.append(" ¡Te has quedado corto! ");
            }

            if (isEven(this.randomNumber)) {
                result.append(" El número es par. ");
            } else {
                result.append(" El número es impar. ");
            }

            if (isPrime(this.randomNumber)) {
                result.append(" El número es primo. ");
            } else {
                result.append(" El número no es primo. ");
            }

            if (Math.abs(this.randomNumber - guess) <= 5) {
                result.append(" ¡Estás muy cerca! ");
            }

            if (isDivisibleBy3(this.randomNumber)) {
                result.append(" El número es divisible por 3. ");
            }

            if (isPerfectSquare(this.randomNumber)) {
                result.append(" El número es un cuadrado perfecto. ");
            }

            result.append(" ").append(getRange(this.randomNumber));

            if (isCloseToMultipleOf10(this.randomNumber)) {
                result.append(" El número está cerca de un múltiplo de 10. ");
            }
        }

        this.attemps.add("Intento: " + guess);
        return result.toString(); // Convierte el StringBuilder a un String
    }

    public List<String> getAttempts() {
        return this.attemps;
    }
}

