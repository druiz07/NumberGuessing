import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎯 Bienvenido al Number Guessing Game!");
        Game game= new Game();
        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("Seleccione dificultad:");
        System.out.println("1. Fácil (1-10)");
        System.out.println("2. Medio (1-50)");
        System.out.println("3. Difícil (1-100)");
        int option= scanner.nextInt();
        game.start(option);
        boolean hasGuessedCorrectly = false;
        while (!hasGuessedCorrectly) {
            System.out.print("Introduce tu intento: ");
            int guess = scanner.nextInt();

            String result = game.makeGuess(guess);
            System.out.println(result);

            if (result.contains("Felicidades")) {
                hasGuessedCorrectly = true;  // El jugador ha adivinado correctamente
            }
        }
        // Mostrar los intentos realizados
        System.out.println("Historial de intentos: " + game.getAttempts());

        scanner.close();
    }
}
