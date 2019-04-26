package ua.kpi.java.lab4;

import ua.kpi.java.lab4.exceptions.InvalidValueException;
import ua.kpi.java.lab4.handler.DataSource;
import ua.kpi.java.lab4.model.Model;
import ua.kpi.java.lab4.view.View;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public final class Controller implements Runnable {
  private final DataSource<List<Integer>> handler;
  private final View view;

  public Controller(DataSource<List<Integer>> handler, View view) {
    this.handler = handler;
    this.view = view;
  }

  @Override
  public void run() {
    try {
      view.writeln("Loading data...");
      view.writeln();

      List<Integer> data = handler.getData();

      if (data.isEmpty()) {
        return;
      }

      view.writeln("Loaded the following data: " + data);

      var model = Model.fromList(data);

      view.writeln("Applying comparator...");
      model.sort(Comparator.reverseOrder());

      view.writeln("Sorted result:");
      view.writeln("\t- data before zero: " + model.getBeforeZero());
      view.writeln("\t- data after zero: " + model.getAfterZero());
    } catch (IOException e) {
      view.writeln("Exception while reading data: " + e.getMessage());
    } catch (InvalidValueException e) {
      view.writeln("Error occurred while reading data: " + e.getMessage());
    }
  }
}
