package ua.kpi.java2.lab1;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Searcher {
  private final ExecutorService pool;

  public Searcher(int threads) {
    this.pool = Executors.newFixedThreadPool(threads);
  }

  public void search(Path path) {
    pool.submit(new Worker(path, this));
  }

  public void finish() {
    pool.shutdown();
  }
}
