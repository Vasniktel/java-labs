package ua.kpi.java.lab1.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.java.lab1.exceptions.IllegalInputException;
import ua.kpi.java.lab1.model.Mode;
import ua.kpi.java.lab1.model.Student;
import ua.kpi.java.lab1.reader.DataReader;
import ua.kpi.java.lab1.validator.Validator;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleView implements View {
  private static final Logger logger = LogManager.getLogger();

  private final DataReader source;
  private final Scanner input;
  private final Validator<String> validator;

  public ConsoleView(DataReader source, Validator<String> validator) {
    logger.traceEntry("Parameters: {}, {}", source, validator);
    this.source = source;
    this.input = new Scanner(System.in);
    this.validator = validator;
  }

  @Override
  public Mode readMode() {
    logger.traceEntry();
    try {
      var value = input.next();
      logger.trace("Read input: {}", value);

      if (!validator.validate(value)) {
        throw logger.throwing(new IllegalInputException("Illegal value was entered"));
      }

      switch (Integer.parseInt(value)) {
        case 1:
          return logger.traceExit(Mode.FIRST);
        case 2:
          return logger.traceExit(Mode.SECOND);
        case 0:
          return logger.traceExit(Mode.FINISH);
        default:
          throw new AssertionError("Should not happen");
      }
    } catch (NoSuchElementException ignored) {
      return logger.traceExit(Mode.FINISH);
    }
  }

  @Override
  public Student[] readData() throws IOException {
    return source.readData();
  }

  @Override
  public void write(String data) {
    System.out.print(data);
  }
}
