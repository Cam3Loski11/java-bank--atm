public class Account {
  private int accountNumber;
  private double balance;
  private double pin;

  /**
   * Constructor de la cuenta
   * 
   * @param accountNumber El número de cuenta que se asignará a esta instancia.
   * @param balance       El saldo inicial de la cuenta. Debe ser un valor no
   *                      negativo.
   * @param pin           El PIN de la cuenta. Debe ser un número de 4 dígitos (o
   *                      según el formato que desees).
   */
  public Account(int accountNumber, double balance, double pin) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.pin = pin;
  }

  /**
   * Método para obtener el número de cuenta.
   * 
   * @return El número de cuenta de esta instancia.
   */
  public int getAccountNumber() {
    return accountNumber;
  }

  /**
   * Método para verificar el PIN.
   * 
   * @param enteredPin El PIN ingresado que se desea verificar.
   * @return true si el PIN ingresado es correcto, false en caso contrario.
   */
  public boolean verifyPin(double enteredPin) {
    return this.pin == enteredPin;
  }

  /**
   * Método para obtener el saldo.
   * 
   * @return El saldo de la cuenta de esta instancia.
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Método para establecer el saldo después de una transacción.
   * 
   * @param balance El nuevo saldo de la cuenta. Debe ser un valor no negativo.
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }
}
