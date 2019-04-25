package ua.kpi.java.lab1;

import ua.kpi.java.lab1.exceptions.IllegalInputException;
import ua.kpi.java.lab1.formatter.Formatter;
import ua.kpi.java.lab1.model.Mode;
import ua.kpi.java.lab1.model.Model;
import ua.kpi.java.lab1.view.View;
import ua.kpi.java.lab1.writer.DataWriter;

import java.io.IOException;

public final class Controller implements Runnable {
  private final Formatter formatter;
  private final View view;
  private final DataWriter writer;

  public Controller(Formatter formatter, View view, DataWriter writer) {
    this.formatter = formatter;
    this.view = view;
    this.writer = writer;
  }

  @Override
  public void run() {
    try {
      view.writeln("Started the application");
      view.writeln();

      var data = view.readData();
      view.writeln("Loaded the following data:");
      view.writeln(formatter.format(data));

      var model = new Model(data);
      writer.writeData(formatter, model);
      view.writeln("Start inputting one of the following commands:");
      view.writeln("\t1 - get all 2-year students with great marks");
      view.writeln("\t2 - get all foreign students with intermediate marks");
      view.writeln("\t0 - exit (Ctrl-D also works)");
      view.writeln();

      while (true) {
        try {
          for (var mode = view.readMode(); mode != Mode.FINISH; mode = view.readMode()) {
            var students = model.filter(mode.getPredicate());
            view.writeln("Got these results:");
            view.writeln(formatter.format(students));
            view.writeln();
          }

          break;
        } catch (IllegalInputException e) {
          view.writeln("Error: " + e.getMessage());
          view.writeln("Try again");
          view.writeln();
        }
      }
    } catch (IOException e) {
      view.writeln("Exception was thrown: " + e.getMessage());
    }
  }
}
