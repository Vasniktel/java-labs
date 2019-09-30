package ua.kpi.java1.lab1.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.java1.lab1.exceptions.FileFormatException;
import ua.kpi.java1.lab1.model.Person;
import ua.kpi.java1.lab1.model.Student;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader implements DataReader {
  private static final Logger logger = LogManager.getLogger();

  private final File file;
  private final String delimiter;

  public FileReader(File file, String delimiter) {
    logger.traceEntry("Parameters: {}, {}", file, delimiter);
    this.file = file;
    this.delimiter = delimiter;
  }

  public FileReader(String path, String delimiter) {
    this(new File(path), delimiter);
  }

  private Student parseLine(int id, String line) {
    var splitted = line.split(delimiter);
    var name = splitted[0];
    var sex = Person.Sex.valueOf(splitted[1]);
    var origin = Person.Origin.valueOf(splitted[2]);
    var mark = Student.Mark.valueOf(splitted[3]);
    var year = Integer.parseInt(splitted[4]);
    var person = new Person(name, sex, origin);
    return new Student(id, person, mark, year);
  }

  @Override
  public Student[] readData() throws IOException {
    logger.traceEntry();
    Student[] result = new Student[1];
    int position = 0;

    try (var scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        if (position == result.length) {
          result = Arrays.copyOf(result, result.length * 2);
        }

        result[position++] = parseLine(position, scanner.nextLine());
      }
    } catch (IllegalArgumentException e) {
      throw logger.throwing(new FileFormatException("Exception while reading from file", e));
    }

    return logger.traceExit(position != result.length ? Arrays.copyOf(result, position) : result);
  }
}
