package ua.kpi.java2.lab1;

import java.nio.file.Files;
import java.nio.file.Path;

public class ArgumentsValidator {
  public Arguments validate(String[] args) {
    if (args.length != 1) {
      throw new ValidationException("Wrong number of arguments");
    }

    var path = args[0];

    if (!Files.exists(Path.of(path))) {
      throw new ValidationException("Invalid path given");
    }

    return new Arguments(path);
  }
}
