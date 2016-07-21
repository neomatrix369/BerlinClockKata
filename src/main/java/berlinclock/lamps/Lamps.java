package berlinclock.lamps;

import static java.lang.String.format;

import static berlinclock.lamps.LampState.*;

import java.util.ArrayList;
import java.util.List;

public class Lamps {
  private final int numberOfLampsToSwitchOn;
  private final EvaluateLamp evaluateLamp;
  private final String rowFormatter;
  private final int maximumLampsPerRow;

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

    int lampIndex = 0;
    while (lampIndex < maximumLampsPerRow) {
      lamps.add(
          lampIndex < numberOfLampsToSwitchOn
          ? evaluateLamp.apply(lampIndex)
          : OFF
      );
      lampIndex++;
    }

    return format(rowFormatter, lamps.toArray());
  }
}
