package ua.kpi.java.lab4.view;

import java.util.Scanner;

public class ConsoleView implements View {
  private final Scanner scanner = new Scanner(System.in);

  @Override
  public boolean hasInt() {
    return scanner.hasNextInt();
  }

  @Override
  public int readInt() {
    return scanner.nextInt();
  }

  @Override
  public void write(String data) {
    System.out.print(data);
  }
}
