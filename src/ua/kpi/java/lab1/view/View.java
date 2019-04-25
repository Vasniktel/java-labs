package ua.kpi.java.lab1.view;

import ua.kpi.java.lab1.model.Mode;
import ua.kpi.java.lab1.model.Student;

import java.io.IOException;

public interface View {
  Mode readMode();
  Student[] readData() throws IOException;
  void write(String data);

  default void writeln(String data) {
    write(data + "\n");
  }

  default void writeln() {
    write("\n");
  }
}
