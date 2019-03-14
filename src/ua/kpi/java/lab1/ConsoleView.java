package ua.kpi.java.lab1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleView implements View {
  private final DataSource source;
  private final Scanner input;

  public ConsoleView(DataSource source) {
    this.source = source;
    this.input = new Scanner(System.in);
  }

  @Override
  public Mode readMode() {
    try {
      switch (input.next().toLowerCase()) {
        case "first":
          return Mode.FIRST_OPTION;
        case "second":
          return Mode.SECOND_OPTION;
        default:
          return Mode.FINISH;
      }
    } catch (NoSuchElementException e) {
      return Mode.FINISH;
    }
  }

  @Override
  public Student[] readData() {
    return source.getData();
  }

  @Override
  public void write(String data) {
    System.out.print(data);
  }
}
