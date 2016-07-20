package berlinclock;

import static java.lang.String.format;
import static berlinclock.LampState.LAMP_OFF;

import java.util.ArrayList;
import java.util.List;

public abstract class ClockRows {
  protected static final int FIVE_HOURS = 5;
  protected static final int FIVE_MINUTES = 5;

  private static final int MAX_LAMPS_PER_ROW = 4;

  protected String populateARowWithLamps(int count, LampState lampState, String rowFormatter) {
    List<LampState> lamps = new ArrayList<>();

    int index = 0;
    while (index < MAX_LAMPS_PER_ROW) {
      lamps.add(index < count ? lampState : LAMP_OFF);
      index++;
    }

    return format(rowFormatter, lamps.toArray());
  }

  public abstract String get();
}
