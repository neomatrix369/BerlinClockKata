package berlinclock;

import static java.lang.String.format;
import static berlinclock.LampState.LAMP_OFF;

import java.util.ArrayList;
import java.util.List;

public class Lamps {
  private static final int MAX_LAMPS_PER_ROW = 4;

  private final int numberOfLampsToSwitchOn;
  private final LampState lampState;
  private final String rowFormatter;

  public Lamps(int numberOfLampsToSwitchOn, LampState lampState, String rowFormatter) {
    this.numberOfLampsToSwitchOn = numberOfLampsToSwitchOn;
    this.lampState = lampState;
    this.rowFormatter = rowFormatter;
  }

  public String getRow() {
    final List<LampState> lamps = new ArrayList<>();

    int index = 0;
    while (index < MAX_LAMPS_PER_ROW) {
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
