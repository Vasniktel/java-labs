package ua.kpi.java1.lab1.model;

import java.io.Serializable;

public class Person implements Serializable {
  private static final long serialVersionUID = -7401363662787891047L;

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
