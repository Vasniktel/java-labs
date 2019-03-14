package ua.kpi.java.lab1;

public interface View {
  Mode readMode();
  Student[] readData();
  void write(String data);

  default void writeln(String data) {
    write(data + "\n");
  }

  default void writeln() {
    write("\n");
  }
}
