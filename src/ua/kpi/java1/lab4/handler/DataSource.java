package ua.kpi.java1.lab4.handler;

import java.io.IOException;

public interface DataSource<T> {
  T getData() throws IOException;
}
