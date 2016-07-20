package berlinclock;

import static java.lang.String.format;
import static berlinclock.LampState.LAMP_OFF;

public abstract class ClockRows {
  protected static final int FIVE_HOURS = 5;
  protected static final int FIVE_MINUTES = 5;

  protected String populateARowWithLamps(int count, LampState lampState, String rowFormatter) {
    LampState[] row = new LampState[] {LAMP_OFF, LAMP_OFF, LAMP_OFF, LAMP_OFF};

    for (int index=0; index<row.length; index++) {
      if (index < count) {
        row[index] = lampState;
      }
    }

    return format(rowFormatter, row);
  }

  public abstract String get();
}
