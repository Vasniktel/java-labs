package ua.kpi.java.lab1;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.java.lab1.exceptions.IllegalInputException;
import ua.kpi.java.lab1.formatter.Formatter;
import ua.kpi.java.lab1.model.Mode;
import ua.kpi.java.lab1.model.Model;
import ua.kpi.java.lab1.view.View;
import ua.kpi.java.lab1.writer.DataWriter;

import java.io.IOException;

public final class Controller implements Runnable {
  private static final Logger logger = LogManager.getLogger();

  private final Formatter formatter;
  private final View view;
  private final DataWriter writer;

  public Controller(Formatter formatter, View view, DataWriter writer) {
    logger.traceEntry("Parameters: {}, {}, {}", formatter, view, writer);
    this.formatter = formatter;
    this.view = view;
    this.writer = writer;
  }

  @Override
  public void run() {
    logger.traceEntry();
    try {
      view.writeln("Started the application");
      view.writeln();

      var data = view.readData();
      logger.trace("Read data: {}", (Object) data);
      view.writeln("Loaded the following data:");
      view.writeln(formatter.format(data));

      var model = new Model(data);
      logger.trace("Created model");
      writer.writeData(formatter, model);
      view.writeln("Start inputting one of the following commands:");
      view.writeln("\t1 - get all 2-year students with great marks");
      view.writeln("\t2 - get all foreign students with intermediate marks");
      view.writeln("\t0 - exit (Ctrl-D also works)");
      view.writeln();

      while (true) {
        try {
          for (var mode = view.readMode(); mode != Mode.FINISH; mode = view.readMode()) {
            logger.trace("Read mode: {}", mode);
            var students = model.filter(mode.getPredicate());
            logger.trace("Filtered data: {}", (Object) students);
            view.writeln("Got these results:");
            view.writeln(formatter.format(students));
            view.writeln();
          }

          break;
        } catch (IllegalInputException e) {
          logger.catching(Level.ERROR, e);
          view.writeln("Error: " + e.getMessage());
          view.writeln("Try again");
          view.writeln();
        }
      }
    } catch (IOException e) {
      logger.catching(Level.FATAL, e);
      view.writeln("Exception was thrown: " + e.getMessage());
    }
    logger.traceExit();
  }
}
