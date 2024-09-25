public class Transaction {

  /**
   * Método para consultar el saldo de la cuenta.
   * Este método imprime en la consola el saldo actual de la cuenta proporcionada.
   * El Account es el objeto que representa la cuenta. EJ: String o int
   *
   * @param account La cuenta de la que se quiere consultar el saldo.
   */
  public void checkBalance(Account account) {
    System.out.println("Su saldo actual es: " + account.getBalance());
  }

  /**
   * Método para depositar dinero en la cuenta.
   * Este método permite al usuario depositar una cantidad específica de dinero en
   * la cuenta.
   * Si la cantidad es válida (mayor que 0), se suma al saldo actual.
   * Si la cantidad es inválida, se muestra un mensaje de error.
   *
   * @param account La cuenta en la que se desea realizar el depósito.
   * @param amount  La cantidad de dinero que se desea depositar.
   */
  public void deposit(Account account, double amount) {
    if (amount > 0) {
      // Actualiza el balance de la cuenta sumando la cantidad depositada.
      account.setBalance(account.getBalance() + amount);
      System.out.println("Depósito exitoso. Su nuevo saldo es: " + account.getBalance());
    } else {
      // Muestra un mensaje de error si la cantidad es inválida.
      System.out.println("Cantidad inválida. Intente de nuevo.");
    }
  }

  /**
   * Método para retirar dinero de la cuenta.
   * Este método permite al usuario retirar una cantidad específica de dinero de
   * la cuenta.
   * Verifica si la cantidad es válida y si hay suficientes fondos.
   * Si se retira exitosamente, se actualiza el saldo.
   * Si no hay fondos suficientes o la cantidad es inválida, se muestra un mensaje
   * de error.
   *
   * @param account La cuenta de la que se desea retirar el dinero.
   * @param amount  La cantidad de dinero que se desea retirar.
   */
  public void withdraw(Account account, double amount) {
    // Verifica que la cantidad sea mayor que 0 y que haya fondos suficientes para
    // realizar el retiro.
    if (amount > 0 && account.getBalance() >= amount) {
      // Actualiza el balance de la cuenta restando la cantidad retirada.
      account.setBalance(account.getBalance() - amount);
      System.out.println("Retiro exitoso. Su nuevo saldo es: " + account.getBalance());
    } else if (amount > 0 && account.getBalance() < amount) {
      // Muestra un mensaje de error si no hay suficientes fondos.
      System.out.println("Fondos insuficientes. No se puede retirar la cantidad solicitada.");
    } else {
      // Muestra un mensaje de error si la cantidad es inválida.
      System.out.println("Cantidad inválida. Intente de nuevo.");
    }
  }
}
