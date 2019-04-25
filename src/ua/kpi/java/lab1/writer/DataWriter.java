package ua.kpi.java.lab1.writer;

import ua.kpi.java.lab1.formatter.Formatter;
import ua.kpi.java.lab1.model.Model;

import java.io.IOException;

public interface DataWriter {
  void writeData(Formatter formatter, Model model) throws IOException;
}
