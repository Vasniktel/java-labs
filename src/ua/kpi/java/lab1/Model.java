package ua.kpi.java.lab1;

import java.util.function.Predicate;

public final class Model {
  private Student[] students;

  public Model(Student[] students) {
    this.students = students.clone();
  }

  public Student[] filter(Predicate<? super Student> predicate) {
    Student[] result = new Student[1];
    int position = 0;

    for (var student : students) {
      if (predicate.test(student)) {
        if (position == result.length) {
          result = resize(result, result.length * 2);
        }

        result[position++] = student;
      }
    }

    if (position != result.length) {
      result = resize(result, position);
    }

    return result;
  }

  private static Student[] resize(Student[] arr, int size) {
    if (size < 0) {
      throw new IllegalArgumentException("Size can't be < 0");
    }

    Student[] result = new Student[size];
    System.arraycopy(arr, 0, result, 0, Math.min(arr.length, size));
    return result;
  }
}
