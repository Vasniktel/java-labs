package ua.kpi.java2.lab1;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    try {
      var parsed = new ArgumentsValidator().validate(args);
      var searcher = new Searcher(5);
      searcher.search(parsed.getPath());
      Thread.sleep(5000);
      searcher.finish();
    } catch (ValidationException e) {
      System.out.println(e.getMessage());
    }
  }
}
