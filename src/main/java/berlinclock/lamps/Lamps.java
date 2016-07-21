package berlinclock.lamps;

import static java.lang.String.format;

import static berlinclock.lamps.LampState.*;

import java.util.ArrayList;
import java.util.List;

public class Lamps {
  private final int numberOfLampsToSwitchOn;
  private final EvaluateLamp evaluateLamp;
  private final String rowFormatter;
  private int maximumLampsPerRow;

  public Lamps(int numberOfLampsToSwitchOn,
      int maximumLampsPerRow,
      EvaluateLamp evaluateLamp,
      String rowFormatter) {
    this.numberOfLampsToSwitchOn = numberOfLampsToSwitchOn;
    this.evaluateLamp = evaluateLamp;
    this.rowFormatter = rowFormatter;
    this.maximumLampsPerRow = maximumLampsPerRow;
  }

  public String get() {
    final List<LampState> lamps = new ArrayList<>();

    int index = 0;
    while (index < maximumLampsPerRow) {
      lamps.add(
          index < numberOfLampsToSwitchOn
          ? evaluateLamp.apply(index)
          : LAMP_OFF
      );
      index++;
    }

    return format(rowFormatter, lamps.toArray());
  }
}
