import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * La clase Game gestiona la lógica del juego de adivinar el número.
 * Permite generar un número aleatorio, iniciar el temporizador y procesar los intentos del jugador.
 */
public class Game {
    private int randomNumber;
    private GameTimer timer;
    private List<String>attemps;
    private  int maxRange = 0;

    /**
     * Constructor de la clase Game.
     * Inicializa el número aleatorio, la lista de intentos y el temporizador.
     */
    public Game()
    {
       this.randomNumber=0;
       this.attemps= new ArrayList<>();
       this.timer= new GameTimer();

    }
    /**
     * Obtiene el temporizador asociado al juego.
     * @return El temporizador del juego.
     */
    public GameTimer getTimer()
    {
        return this.timer;
    }

    /**
     * Obtiene el número aleatorio generado.
     * @return El número aleatorio generado para adivinar.
     */
    public int getRandomNumber()
    {
        return this.randomNumber;
    }
    /**
     * Inicia el juego con un nivel de dificultad determinado.
     * @param difficulty El nivel de dificultad seleccionado (1, 2 o 3).
     * @throws InvalidDifficultyException Si el nivel de dificultad es inválido.
     */
    public void start(int difficulty) throws InvalidDifficultyException  ,TimerException{


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
                maxRange = 10;
                throw new InvalidDifficultyException("Nivel de dificultad inválido. Selecciona 1, 2 o 3.");

        }
        generateRandomNumber();
        System.out.println("🔢 Se ha generado un número aleatorio. ¡Intenta adivinarlo!");
    }

    /**
     * Genera un número aleatorio dentro del rango especificado.
     */
    private void generateRandomNumber() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(maxRange) + 1;
    }

    /**
     * Verifica si un número es divisible por 3.
     * @param number El número a verificar.
     * @return true si el número es divisible por 3, false en caso contrario.
     */
    public boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    /**
     * Verifica si un número es un cuadrado perfecto.
     * @param number El número a verificar.
     * @return true si el número es un cuadrado perfecto, false en caso contrario.
     */
    public boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }

    /**
     * Devuelve el rango en el que se encuentra un número.
     * @param number El número a verificar.
     * @return El rango en forma de cadena.
     */
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

    /**
     * Verifica si un número es primo.
     * @param number El número a verificar.
     * @return true si el número es primo, false en caso contrario.
     */
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

    /**
     * Verifica si un número es par.
     * @param number El número a verificar.
     * @return true si el número es par, false en caso contrario.
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    /**
     * Verifica si un número está cerca de un múltiplo de 10.
     * @param number El número a verificar.
     * @return true si el número está cerca de un múltiplo de 10, false en caso contrario.
     */
    public boolean isCloseToMultipleOf10(int number) {
        return Math.abs(number % 10) <= 3;
    }
    /**
     * Obtiene el tiempo restante en el temporizador.
     * @return Una cadena con el tiempo restante o un mensaje si el tiempo se agotó.
     */
    public String getTimeRemaining() {
        if (timer.isTimeUp()) {
            return "El tiempo se agotó.";
        }
        return "Tiempo restante: " + timer.getTimeLeft() + " segundos";
    }
    /**
     * Realiza un intento del jugador.
     * @param guess El número que el jugador intenta adivinar.
     * @return El resultado del intento, indicando si el número es mayor, menor o correcto.
     * @throws InvalidGuessException Si el número ingresado está fuera del rango permitido.
     */
    public String makeGuess(int guess) throws InvalidGuessException{
        if (guess < 1 || guess > maxRange) {
            throw new InvalidGuessException("La apuesta debe estar entre 1 y " + maxRange);
        }
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
        return result.toString();
    }

    /**
     * Obtiene el historial de intentos realizados.
     * @return La lista de intentos como una lista de cadenas.
     */

    public List<String> getAttempts() {
        return this.attemps;
    }
}

