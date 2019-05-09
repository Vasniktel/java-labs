package ua.kpi.java.lab1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.java.lab1.formatter.TableFormatter;
import ua.kpi.java.lab1.reader.FileReader;
import ua.kpi.java.lab1.validator.ModeIntegerValidator;
import ua.kpi.java.lab1.view.ConsoleView;
import ua.kpi.java.lab1.writer.FileWriter;

public final class Main {
  private static final Logger logger = LogManager.getLogger();

  public static void main(String[] args) {
    logger.traceEntry();
    var reader = new FileReader("data/in.txt", ":");
    var writer = new FileWriter("data/out.txt");
    var view = new ConsoleView(reader, new ModeIntegerValidator());
    new Controller(new TableFormatter(), view, writer).run();
    logger.traceExit();
  }
}
