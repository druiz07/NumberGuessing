import java.util.Scanner;

/**
 * Clase principal que ejecuta el juego de adivinar el número.
 * Este método maneja la interacción con el jugador, permitiendo seleccionar la dificultad,
 * hacer intentos para adivinar el número y gestionar el tiempo de juego.
 * También se encargará de mostrar el historial de intentos y preguntar si el jugador desea
 * jugar otra ronda.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        System.out.println("🎯 Bienvenido al Number Guessing Game!");

        do {
            try {
                System.out.println("¡Bienvenido al juego de adivinar el número!");
                System.out.println("Seleccione dificultad:");
                System.out.println("1. Fácil (1-10)");
                System.out.println("2. Medio (1-50)");
                System.out.println("3. Difícil (1-100)");
                int option = scanner.nextInt();

                Game game = new Game();
                String timeUsed = game.getTimeRemaining();
                game.start(option);
                boolean hasGuessedCorrectly = false;

                while (!hasGuessedCorrectly) {
                    System.out.println(game.getTimeRemaining());

                    System.out.print("Introduce tu intento: ");
                    int guess = scanner.nextInt();

                    String result = game.makeGuess(guess);
                    System.out.println(result);

                    if (result.contains("Felicidades")) {
                        hasGuessedCorrectly = true;
                        timeUsed = game.getTimeRemaining();
                    }

                    if (game.getTimer().isTimeUp()) {
                        System.out.println("¡El tiempo se agotó! El número era: " + game.getRandomNumber());
                        break;
                    }
                }

                System.out.println("Tiempo empleado: " + timeUsed);
                System.out.println("Historial de intentos: " + game.getAttempts());

                System.out.println("¿Quieres jugar otra ronda? (sí/no): ");
                playAgain = scanner.next().toLowerCase();

            } catch (InvalidDifficultyException | InvalidGuessException e) {
                System.out.println("Error: " + e.getMessage());
                playAgain = "si";
            }
            catch (TimerException e) {
                System.out.println("Error con el temporizador: " + e.getMessage());
                playAgain = "no";
            } catch (Exception e) {

                System.out.println("Se ha producido un error inesperado: " + e.getMessage());
                playAgain = "no";
            }


        } while(playAgain.equals("sí")||playAgain.equals("si"));

        System.out.println("¡Gracias por jugar!");
        scanner.close();
}
}
