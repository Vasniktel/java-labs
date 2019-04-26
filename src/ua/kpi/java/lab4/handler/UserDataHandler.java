package ua.kpi.java.lab4.handler;

import ua.kpi.java.lab4.exceptions.InvalidValueException;
import ua.kpi.java.lab4.view.View;

import java.util.ArrayList;
import java.util.List;

public class UserDataHandler implements DataHandler<List<Integer>> {
  private final View view;

  public UserDataHandler(View view) {
    this.view = view;
  }

  private void greet() {
    view.writeln("Start inputting two sets of integers");
    view.writeln("with zero between them");
    view.writeln("Press any non-digit button to break");
    view.writeln();
  }

  @Override
  public List<Integer> getData() {
    greet();
    var list = new ArrayList<Integer>();

    boolean zeroAdded = false;
    while (view.hasInt()) {
      int input = view.readInt();

      if (input == 0) {
        if (zeroAdded) {
          throw new InvalidValueException("Zero was already added");
        } else {
          zeroAdded = true;
        }
      }

      list.add(input);
    }

    if (!list.isEmpty() && !zeroAdded) {
      throw new InvalidValueException("Zero must be specified");
    }

    return list;
  }

  @Override
  public void putData(List<Integer> data) {
    throw new UnsupportedOperationException("Data can't be saved yet");
  }
}
