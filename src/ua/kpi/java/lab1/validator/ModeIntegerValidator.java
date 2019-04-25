package ua.kpi.java.lab1.validator;

import java.util.regex.Pattern;

public class ModeIntegerValidator implements Validator<String> {
  @Override
  public boolean validate(String value) {
    return Pattern.matches("[0-2]", value);
  }
}
