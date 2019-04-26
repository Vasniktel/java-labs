package ua.kpi.java.lab4.view;

public interface View {
  boolean hasInt();
  int readInt();
  void write(String data);

  default void writeln(String data) {
    write(data + "\n");
  }

  default void writeln() {
    write("\n");
  }
}
