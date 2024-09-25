import java.util.Scanner;

public class ATM {
  private Account account; // La cuenta asociada a este cajero automático
  private Transaction transaction = new Transaction(); // Objeto para manejar transacciones (depósitos y retiros)
  private Scanner scanner = new Scanner(System.in); // Escáner para leer la entrada del usuario

  /**
   * Constructor de la clase ATM.
   * 
   * @param account La cuenta que se va a gestionar a través del cajero
   *                automático.
   */
  public ATM(Account account) {
    this.account = account;
  }

  /**
   * Método para iniciar el funcionamiento del cajero automático.
   * Presenta un menú al usuario y permite realizar operaciones en la cuenta.
   */
  public void start() {
    boolean exit = false; // Controla si el usuario quiere salir del cajero automático

    System.out.println("Bienvenido a JavaBank ATM.");
    // Autentica al usuario antes de continuar
    if (!authenticate()) {
      System.out.println("PIN incorrecto. Terminando sesión.");
      return; // Sale del método si el PIN es incorrecto
    }

    while (!exit) {
      System.out.println("----------------------------------");
      System.out.println("Seleccione una opción: ");
      System.out.println("1. Ver saldo");
      System.out.println("2. Depositar dinero");
      System.out.println("3. Retirar dinero");
      System.out.println("0. Salir");
      System.out.println("----------------------------------");
      int choice = scanner.nextInt(); // Lee la opción elegida por el usuario

      // Ejecuta la acción correspondiente según la opción seleccionada
      switch (choice) {
        case 1 -> transaction.checkBalance(account); // Muestra el saldo de la cuenta
        case 2 -> deposit(); // Llama al método de depósito
        case 3 -> withdraw(); // Llama al método de retiro
        case 0 -> exit = true; // Cambia el estado de salida
        default -> System.out.println("Selección no válida."); // Manejo de selección no válida
      }
    }
    scanner.close(); // Cierra el escáner al finalizar
  }

  /**
   * Método para autenticar al usuario mediante su PIN.
   * 
   * @return true si el PIN ingresado es correcto, false en caso contrario.
   */
  public boolean authenticate() {
    System.out.println("Ingrese su PIN: ");
    double pin = scanner.nextDouble(); // Lee el PIN ingresado por el usuario
    return account.verifyPin(pin); // Verifica el PIN con la cuenta
  }

  /**
   * Método para depositar dinero en la cuenta.
   * Pide al usuario que ingrese el monto a depositar y realiza la operación.
   */
  public void deposit() {
    System.out.println("Ingrese el monto a depositar: ");
    double amount = scanner.nextDouble(); // Lee la cantidad a depositar
    transaction.deposit(account, amount); // Realiza el depósito
  }

  /**
   * Método para retirar dinero de la cuenta.
   * Pide al usuario que ingrese el monto a retirar y realiza la operación.
   */
  public void withdraw() {
    System.out.println("Ingrese el monto a retirar: ");
    double amount = scanner.nextDouble(); // Lee la cantidad a retirar
    transaction.withdraw(account, amount); // Realiza el retiro
  }

  /**
   * Método principal para ejecutar el cajero automático.
   * Crea una cuenta de ejemplo y inicia el cajero automático.
   */
  public static void main(String[] args) {
    Account exampleAccount = new Account("123456789", 1000.00, 1234); // Crea una cuenta de ejemplo

    ATM atm = new ATM(exampleAccount); // Crea una instancia de ATM con la cuenta de ejemplo
    atm.start(); // Inicia el funcionamiento del cajero automático
  }
}
