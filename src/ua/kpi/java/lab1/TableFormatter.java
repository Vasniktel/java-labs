package ua.kpi.java.lab1;

public class TableFormatter implements Formatter {
  public static final String FORMAT = "%3s|%5s|%20s|%10s|%15s|%10s\n";
  private static final String HEADER = String.format(FORMAT, "id", "year", "initials", "sex", "origin", "mark") +
      "----------------------------------------------------------------------\n";
  private static final String FAILURE =
      "                           /No data was found/                        \n";

  @Override
  public String format(Student[] students) {
    var builder = new StringBuilder(HEADER);

    if (students.length == 0) {
      builder.append(FAILURE);
    } else {
      for (var student : students) {
        builder.append(student);
      }
    }

    return builder.toString();
  }
}
