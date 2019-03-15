package ua.kpi.java.lab1;

import java.util.Arrays;
import java.util.function.Predicate;

public final class Model {
  private final Student[] students;

  public Model(Student[] students) {
    this.students = students.clone();
  }

  public Student[] filter(Predicate<? super Student> predicate) {
    Student[] result = new Student[1];
    int position = 0;

    for (var student : students) {
      if (predicate.test(student)) {
        if (position == result.length) {
          result = Arrays.copyOf(result, result.length * 2);
        }

        result[position++] = student;
      }
    }

    return position != result.length ? Arrays.copyOf(result, position) : result;
  }
}
