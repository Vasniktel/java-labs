package ua.kpi.java.lab4;

import ua.kpi.java.lab4.view.ConsoleView;
import ua.kpi.java.lab4.handler.UserDataHandler;

public final class Main {
  public static void main(String[] args) {
    var view = new ConsoleView();
    var handler = new UserDataHandler(view);
    new Controller(handler, view).run();
  }
}
