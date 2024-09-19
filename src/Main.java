import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      // Variables básicas
      String accountNumber = "123456789";
      double balance = 1500.75;
      int correctPin = 1234;

      // Array de montos de transacciones
      int[] transactionAmounts = {200, -100, 50};

      // Operaciones con variables
      balance += transactionAmounts[0]; // Depósito

      // Variables de entrada
      System.out.println("Ingresa tu pin: ");
      Scanner scanner = new Scanner(System.in);
      int userPin = scanner.nextInt();

      if (balance > 0 && userPin == correctPin) { 
        System.out.println("Acceso Concedido");
      } else {
        System.out.println("Acceso Denegado");

        System.exit(0);
      }

      scanner.close();

      // Uso de operadores
      balance++; // Incremento
      String status = (balance < 0) ? "Deuda" : "Crédito";
      System.out.println("Estado de cuenta: " + status);
  }
}

