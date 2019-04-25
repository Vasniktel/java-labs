package ua.kpi.java.lab1.exceptions;

public class IllegalInputException extends RuntimeException {
  public IllegalInputException() {
    super();
  }

  public IllegalInputException(String message) {
    super(message);
  }

  public IllegalInputException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalInputException(Throwable cause) {
    super(cause);
  }
}
