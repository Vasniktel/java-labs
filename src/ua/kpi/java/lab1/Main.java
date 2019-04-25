package ua.kpi.java.lab1;

import ua.kpi.java.lab1.formatter.TableFormatter;
import ua.kpi.java.lab1.reader.FileReader;
import ua.kpi.java.lab1.validator.ModeIntegerValidator;
import ua.kpi.java.lab1.view.ConsoleView;
import ua.kpi.java.lab1.writer.FileWriter;

public final class Main {
  public static void main(String[] args) {
    var reader = new FileReader("data/in.txt", ":");
    var writer = new FileWriter("data/out.txt");
    //var writer = new Serializer("data/out.ser");
    var view = new ConsoleView(reader, new ModeIntegerValidator());
    new Controller(new TableFormatter(), view, writer).run();
  }
}
