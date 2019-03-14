package ua.kpi.java.lab1;

public class StaticSource implements DataSource {
  @Override
  public Student[] getData() {
    return new Student[] {
        new Student(
            1,
            new Person("Vasyl Teliman", Person.Sex.MALE, Person.Origin.NATIVE),
            Student.Mark.BAD,
            2
        ),

        new Student(
            2,
            new Person("Sherlock Holmes", Person.Sex.MALE, Person.Origin.FOREIGNER),
            Student.Mark.GREAT,
            4
        ),

        new Student(
            3,
            new Person("John Watson", Person.Sex.MALE, Person.Origin.FOREIGNER),
            Student.Mark.FINE,
            1
        ),

        new Student(
            4,
            new Person("Ms. Hudson", Person.Sex.FEMALE, Person.Origin.NATIVE),
            Student.Mark.FINE,
            2
        ),

        new Student(
            5,
            new Person("Albert Einshtein", Person.Sex.MALE, Person.Origin.NATIVE),
            Student.Mark.GREAT,
            3
        ),

        new Student(
            6,
            new Person("Neil deGrasse Tyson", Person.Sex.MALE, Person.Origin.FOREIGNER),
            Student.Mark.GREAT,
            5
        ),

        new Student(
            7,
            new Person("Andrei Alexandrescu", Person.Sex.MALE, Person.Origin.FOREIGNER),
            Student.Mark.FINE,
            2
        ),

        new Student(
            8,
            new Person("Elon Mask", Person.Sex.MALE, Person.Origin.NATIVE),
            Student.Mark.GREAT,
            3
        ),

        new Student(
            9,
            new Person("Bill Gates", Person.Sex.MALE, Person.Origin.FOREIGNER),
            Student.Mark.FINE,
            1
        ),

        new Student(
            10,
            new Person("Mark Zuckerberg", Person.Sex.MALE, Person.Origin.NATIVE),
            Student.Mark.GREAT,
            3
        )
    };
  }
}
