package ua.kpi.java.lab4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Model {
  private final List<Integer> beforeZero, afterZero;

  private Model(List<Integer> beforeZero, List<Integer> afterZero) {
    this.beforeZero = beforeZero;
    this.afterZero = afterZero;
  }

  public static Model fromList(List<Integer> list) {
    var beforeZero = new ArrayList<Integer>();
    var afterZero = new ArrayList<Integer>();

    int i;
    for (i = 0; i < list.size() && list.get(i) != 0; ++i) {
      beforeZero.add(list.get(i));
    }

    for (i += 1; i < list.size(); ++i) {
      afterZero.add(list.get(i));
    }

    return new Model(beforeZero, afterZero);
  }


  public List<Integer> getBeforeZero() {
    return beforeZero;
  }

  public List<Integer> getAfterZero() {
    return afterZero;
  }

  public void sort(Comparator<? super Integer> comparator) {
    beforeZero.sort(comparator);
    afterZero.sort(comparator);
  }
}
