package ua.kpi.java.lab1;

public final class Main {
  public static void main(String[] args) {
    var view = new ConsoleView(new StaticSource());
    new Controller(new TableFormatter(), view).run();
  }
}
