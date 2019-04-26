package ua.kpi.java.lab4.handler;

import java.io.IOException;

public interface DataHandler<T> {
  T getData() throws IOException;
  void putData(T data) throws IOException;
}
