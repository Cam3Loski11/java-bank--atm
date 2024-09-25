import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables básicas
        String accountNumber = "123456789";
        double balance = 1500.75;
        String correctPin = "1234";

        // Array de montos de transacciones
        int[] transactionAmounts = {200, -100, 50};

        // Variables de entrada
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu pin: ");
        String userPin = scanner.nextLine();

        // Autenticación de usuario
        if (authenticateUser(userPin, correctPin)) {
            System.out.println("Acceso Concedido");

            // Operaciones con variables
            for (int amount : transactionAmounts) {
                balance += amount; // Sumar cada transacción al saldo
            }

            balance++; // Incremento al saldo
            String status = (balance < 0) ? "Deuda" : "Crédito";
            System.out.println("Estado de cuenta: " + status);
            System.out.println("Saldo actual: " + balance);
        } else {
            System.out.println("Acceso Denegado");
        }

        scanner.close();
    }

    // Método para autenticar al usuario

    /**
     * Recibe el input del usuario y el pin correcto, si son iguales regresa true, si no seguira el ciclo while hasta que o de true o de 3 intentos
     * @param inputPin 
     * @param correctPin
     * @return boolean
     */

    public static boolean authenticateUser(String inputPin, String correctPin) {
        int attempts = 0;
        while (attempts < 3) {
            if (correctPin.equals(inputPin)) {
                return true;
            } else {
                attempts++;
                if (attempts < 3) { // No preguntar de nuevo si ya alcanzó el máximo de intentos
                    System.out.println("PIN incorrecto. Intento " + attempts + " de 3. Inténtalo nuevamente:");
                    Scanner scanner = new Scanner(System.in);
                    inputPin = scanner.nextLine();
                } else {
                    System.out.println("Máximos intentos alcanzados. Acceso Denegado.");
                }
            }
        }
        return false;
    }
}