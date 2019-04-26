package ua.kpi.java.lab4.exceptions;

public class InvalidValueException extends RuntimeException {
  public InvalidValueException(String message) {
    super(message);
  }

  public InvalidValueException(String message, Throwable cause) {
    super(message, cause);
  }
}
