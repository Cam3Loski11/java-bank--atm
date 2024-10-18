public class SavingAccount extends Account {
  private double interestRate;
  private double maintenanceFee;

  public SavingAccount(int accountNumber, double balance, double pin, double interestRate, double maintenanceFee) {
    super(accountNumber, balance, pin); // Inicializa la clase base Account
    this.interestRate = interestRate;
    this.maintenanceFee = maintenanceFee;
  }

  // Método para añadir interés al saldo de la cuenta
  public void addInterest() {
    double interest = getBalance() * interestRate; // Usa getBalance() de la clase Account
    setBalance(getBalance() + interest); // Usa setBalance() para actualizar el saldo en Account
    System.out.println("Interes: " + interest);
    System.out.println("Nuevo saldo (post interes): " + getBalance());
  }

  // Método para descontar la tarifa de mantenimiento
  public void payMaintenanceFee() {
    setBalance(getBalance() - maintenanceFee); // Usa setBalance() para actualizar el saldo
    System.out.println("Mantenimiento: " + maintenanceFee);
    System.out.println("Nuevo saldo (post mantenimiento): " + getBalance());
  }

  // Método para mostrar las reglas de la cuenta
  public void showAccountRules() {
    System.out.println("Cuenta de ahorros");
    System.out.println("Numero de cuenta: " + getAccountNumber()); // Usa getAccountNumber() de Account
  }
}
