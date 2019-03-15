package ua.kpi.java.lab1;

public final class Controller implements Runnable {
  private final Formatter formatter;
  private final View view;

  public Controller(Formatter formatter, View view) {
    this.formatter = formatter;
    this.view = view;
  }

  @Override
  public void run() {
    view.writeln("Started the application");
    view.writeln();

    var data = view.readData();
    view.writeln("Loaded the following data:");
    view.writeln(formatter.format(data));

    var model = new Model(data);
    view.writeln("Start inputting one of the following commands:");
    view.writeln("\tfirst  - get all 2-year students with great marks");
    view.writeln("\tsecond - get all foreign students with intermediate marks");
    view.writeln("\t<any>  - exit");
    view.writeln();

    for (var mode = view.readMode(); mode != Mode.FINISH; mode = view.readMode()) {
      var students = model.filter(mode.getPredicate());
      view.writeln("Got these results:");
      view.writeln(formatter.format(students));
      view.writeln();
    }
  }
}
