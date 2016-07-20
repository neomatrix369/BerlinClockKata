package berlinclock;

import static java.lang.String.format;
import static berlinclock.LampState.LAMP_OFF;

import java.util.ArrayList;
import java.util.List;

public class Lamps {
  private final int numberOfLampsToSwitchOn;
  private final LampState lampState;
  private final String rowFormatter;
  private int maximumLampsPerRow;

  public Lamps(int numberOfLampsToSwitchOn, int maximumLampsPerRow, LampState lampState, String rowFormatter) {
    this.numberOfLampsToSwitchOn = numberOfLampsToSwitchOn;
    this.lampState = lampState;
    this.rowFormatter = rowFormatter;
    this.maximumLampsPerRow = maximumLampsPerRow;
  }

  public String getRow() {
    final List<LampState> lamps = new ArrayList<>();

    int index = 0;
    while (index < maximumLampsPerRow) {
      lamps.add(
          index < numberOfLampsToSwitchOn
          ? lampState
          : LAMP_OFF
      );
      index++;
    }

    return format(rowFormatter, lamps.toArray());
  }
}
