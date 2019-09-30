package ua.kpi.java2.lab1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

public class Worker implements Callable<Void> {
  private final Path path;
  private final Searcher searcher;

  public Worker(Path path, Searcher searcher) {
    this.path = path;
    this.searcher = searcher;
  }

  @Override
  public Void call() throws IOException {
    if (Files.isDirectory(path)) {
      try (var content = Files.list(path)) {
        content.forEach(searcher::search);
      }
    } else if (path.toString().endsWith(".java")) {
      process(path);
      System.out.println(path);
    }

    return null;
  }

  private static void process(Path path) throws IOException {
    var content = new StringBuilder();

    try (var lines = Files.lines(path)) {
      lines.forEach((line) -> {
        int i = 0, j = line.indexOf(' ', 1), n = line.length();
        if (j == -1) {
          j = n;
        }

        while (i < n) {
          if (j - i > 3) {
            content.append(line.substring(i, j).toUpperCase());
          } else {
            content.append(line, i, j);
          }

          i = j;
          j = line.indexOf(' ', i + 1);
          if (j == -1) {
            j = n;
          }
        }
      });
    }

    try (var printer = new PrintWriter(new FileOutputStream(path.toFile()))) {
      printer.println(content.toString());
    }
  }
}
