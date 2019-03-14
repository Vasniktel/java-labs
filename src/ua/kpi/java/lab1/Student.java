package ua.kpi.java.lab1;

public final class Student extends Person {
  private final int id;
  private final Mark mark;
  private final int year;

  public Student(int id, Person person, Mark mark, int year) {
    super(person.initials, person.sex, person.origin);
    this.id = validateGreaterThanZero(id);
    this.mark = mark;
    this.year = validateGreaterThanZero(year);
  }

  private static int validateGreaterThanZero(int num) {
    if (num <= 0) {
      throw new IllegalArgumentException("Number is <= 0");
    }

    return num;
  }

  public int getId() {
    return id;
  }

  public String getInitials() {
    return initials;
  }

  public Sex getSex() {
    return sex;
  }

  public Mark getMark() {
    return mark;
  }

  @Override
  public String toString() {
    return String.format(TableFormatter.FORMAT, id, year, initials, sex, origin, mark);
  }

  public int getYear() {
    return year;
  }

  public enum Mark {
    GREAT,
    FINE,
    BAD
  }
}
