package ua.kpi.java1.lab1.exceptions;

import java.io.IOException;

public class FileFormatException extends IOException {
  public FileFormatException() {
    super();
  }

  public FileFormatException(String message) {
    super(message);
  }

  public FileFormatException(String message, Throwable cause) {
    super(message, cause);
  }

  public FileFormatException(Throwable cause) {
    super(cause);
  }
}
