import java.util.Scanner;

public class ATM {
  private Account account; // La cuenta asociada a este cajero automático
  private Transaction transaction = new Transaction(); // Objeto para manejar transacciones (depósitos y retiros)
  private final Scanner scanner = new Scanner(System.in); // Escáner para leer la entrada del usuario
  boolean exit = false; // Controla si el usuario quiere salir del cajero automático

  /**
   * Método para iniciar el funcionamiento del cajero automático.
   * Presenta un menú al usuario y permite realizar operaciones en la cuenta.
   */
  public void start() {

    System.out.println("Bienvenido a JavaBank ATM.");

    // Revisamos si el numero de la cuenta existe
    if (!checkAccountNumber()) {
      System.out.println("La cuenta no existe. Terminando sesión.");
      return; // Sale del método si la cuenta no existe
    }

    // Autentica al usuario antes de continuar
    if (!authenticate()) {
      System.out.println("PIN incorrecto. Terminando sesión.");
      return; // Sale del método si el PIN es incorrecto
    }

    // Una vez autenticado, comienza a manejar la cuenta
    if (account instanceof SavingAccount) {
      // Si es una cuenta de ahorro, maneja la cuenta de ahorro
      SavingAccount savingAccount = (SavingAccount) account;
      savingAccount.payMaintenanceFee(); // Estas operaciones ocurren después de autenticarse
      savingAccount.addInterest();
      handleSavingAccount(savingAccount); // Lógica para manejar la cuenta de ahorro
    } else {
      // Si es una cuenta corriente, maneja la cuenta normalmente
      handleCurrentAccount();
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
   * Método para verificar si el número de cuenta existe y asignar la cuenta.
   */
  public boolean checkAccountNumber() {
    // Crea dos cuentas como base de datos temporal
    SavingAccount savingsAccount = new SavingAccount(123456789, 1000.00, 1234, 0.2, 10); // Cuenta de ahorro
    Account currentAccount = new Account(987654321, 2000.00, 4321); // Cuenta corriente

    System.out.println("Ingrese el número de su cuenta: ");
    double enteredAccountNumber = scanner.nextInt(); // Número de cuenta ingresado por el usuario

    // Verificar si el número de cuenta coincide con alguna de las cuentas
    if (enteredAccountNumber == savingsAccount.getAccountNumber()) {
      this.account = savingsAccount; // Asigna la cuenta de ahorro si coincide
      return true;
    } else if (enteredAccountNumber == currentAccount.getAccountNumber()) {
      this.account = currentAccount; // Asigna la cuenta corriente si coincide
      return true;
    }
    return false; // Retorna falso si no coincide con ninguna cuenta
  }

  /**
   * Maneja las opciones específicas de la cuenta de ahorro.
   */
  public void handleSavingAccount(SavingAccount savingsAccount) {
    while (!exit) {
      System.out.println("----------------------------------");
      System.out.println("Seleccione una opción: ");
      System.out.println("1. Ver saldo");
      System.out.println("2. Depositar dinero");
      System.out.println("3. Retirar dinero");
      System.out.println("4. Ver reglas de la cuenta");
      System.out.println("0. Salir");
      System.out.println("----------------------------------");
      int choice = scanner.nextInt(); // Lee la opción elegida por el usuario

      // Ejecuta la acción correspondiente según la opción seleccionada
      switch (choice) {
        case 1 -> transaction.checkBalance(account); // Muestra el saldo de la cuenta
        case 2 -> deposit(); // Llama al método de depósito
        case 3 -> withdraw(); // Llama al método de retiro
        case 4 -> savingsAccount.showAccountRules(); // Muestra las reglas de la cuenta
        case 0 -> exit = true; // Cambia el estado de exit
        default -> System.out.println("Selección no válida."); // Manejo de selección no válida
      }
    }
  }

  /**
   * Maneja las opciones específicas de la cuenta corriente.
   */
  public void handleCurrentAccount() {
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
        case 0 -> exit = true; // Cambia el estado de exit
        default -> System.out.println("Selección no válida."); // Manejo de selección no válida
      }
    }
  }

  /**
   * Método para depositar dinero en la cuenta.
   */
  public void deposit() {
    System.out.println("Ingrese el monto a depositar: ");
    double amount = scanner.nextDouble(); // Lee la cantidad a depositar
    transaction.deposit(account, amount); // Realiza el depósito
  }

  /**
   * Método para retirar dinero de la cuenta.
   */
  public void withdraw() {
    System.out.println("Ingrese el monto a retirar: ");
    double amount = scanner.nextDouble(); // Lee la cantidad a retirar
    transaction.withdraw(account, amount); // Realiza el retiro
  }

  /**
   * Método principal para ejecutar el cajero automático.
   */
  public static void main(String[] args) {
    ATM atm = new ATM(); // Crea una instancia de ATM
    atm.start(); // Inicia el funcionamiento del cajero automático
  }
}
