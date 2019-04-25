package ua.kpi.java.lab1.writer;

import ua.kpi.java.lab1.formatter.Formatter;
import ua.kpi.java.lab1.model.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public final class FileWriter implements DataWriter {
  private final File file;

  public FileWriter(File file) {
    this.file = file;
  }

  public FileWriter(String path) {
    this(new File(path));
  }

  @Override
  public void writeData(Formatter formatter, Model model) throws FileNotFoundException {
    try (var writer = new PrintWriter(file)) {
      writer.println(formatter.format(model.getData()));
    }
  }
}
