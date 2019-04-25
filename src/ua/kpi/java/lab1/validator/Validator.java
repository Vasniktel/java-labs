package ua.kpi.java.lab1.validator;

@FunctionalInterface
public interface Validator<T> {
  boolean validate(T value);
}
