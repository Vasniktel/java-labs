package ua.kpi.java1.lab1.model;

import java.util.function.Predicate;

public enum Mode {
  FINISH(student -> {
    throw new AssertionError("Unlikely to happen");
  }),

  FIRST(student -> student.getYear() == 2 &&
      student.getMark() == Student.Mark.GREAT),

  SECOND(student -> student.getOrigin() == Person.Origin.FOREIGNER &&
      student.getMark() != Student.Mark.BAD);

  private Predicate<? super Student> predicate;

  Mode(Predicate<? super Student> predicate) {
    this.predicate = predicate;
  }

  public Predicate<? super Student> getPredicate() {
    return predicate;
  }
}
