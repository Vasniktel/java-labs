package ua.kpi.java.lab1.view;

import ua.kpi.java.lab1.exceptions.IllegalInputException;
import ua.kpi.java.lab1.model.Mode;
import ua.kpi.java.lab1.model.Student;
import ua.kpi.java.lab1.reader.DataReader;
import ua.kpi.java.lab1.validator.Validator;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleView implements View {
  private final DataReader source;
  private final Scanner input;
  private final Validator<String> validator;

  public ConsoleView(DataReader source, Validator<String> validator) {
    this.source = source;
    this.input = new Scanner(System.in);
    this.validator = validator;
  }

  @Override
  public Mode readMode() {
    try {
      var value = input.next();

      if (!validator.validate(value)) {
        throw new IllegalInputException("Illegal value was entered");
      }

      switch (Integer.parseInt(value)) {
        case 1:
          return Mode.FIRST;
        case 2:
          return Mode.SECOND;
        case 0:
          return Mode.FINISH;
        default:
          throw new AssertionError("Should not happen");
      }
    } catch (NoSuchElementException e) {
      return Mode.FINISH;
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
