package ua.kpi.java2.lab1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Arguments {
  private final Path path;

  public Arguments(String path) {
    this.path = Paths.get(path);
  }

  public Path getPath() {
    return path;
  }
}
