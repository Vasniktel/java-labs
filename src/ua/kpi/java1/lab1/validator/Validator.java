package ua.kpi.java1.lab1.validator;

@FunctionalInterface
public interface Validator<T> {
  boolean validate(T value);
}
