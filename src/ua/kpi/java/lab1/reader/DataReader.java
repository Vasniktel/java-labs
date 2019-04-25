package ua.kpi.java.lab1.reader;

import ua.kpi.java.lab1.model.Student;

import java.io.IOException;

public interface DataReader {
  Student[] readData() throws IOException;
}
