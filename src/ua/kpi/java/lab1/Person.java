package ua.kpi.java.lab1;

public class Person {
  protected final String initials;
  protected final Sex sex;
  protected final Origin origin;

  public Person(String initials, Sex sex, Origin origin) {
    this.initials = initials;
    this.sex = sex;
    this.origin = origin;
  }

  public String getInitials() {
    return initials;
  }

  public Sex getSex() {
    return sex;
  }

  public Origin getOrigin() {
    return origin;
  }

  public enum Sex {
    MALE, FEMALE
  }

  public enum Origin {
    NATIVE, FOREIGNER
  }
}
