package ua.kpi.java1.lab1.reader;

import ua.kpi.java1.lab1.model.Student;

import java.io.IOException;

public interface DataReader {
  Student[] readData() throws IOException;
}
