package ua.kpi.java.lab1.writer;

import ua.kpi.java.lab1.formatter.Formatter;
import ua.kpi.java.lab1.model.Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer implements DataWriter {
  private final File file;

  public Serializer(File file) {
    this.file = file;
  }

  public Serializer(String path) {
    this(new File(path));
  }

  @Override
  public void writeData(Formatter ignored, Model model) throws IOException {
    try (var out = new ObjectOutputStream(new FileOutputStream(file))) {
      out.writeObject(model.getData());
    }
  }
}
