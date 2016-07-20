package berlinclock;

import static berlinclock.LampState.RED_LAMP;

public class ClockFirstMiddleRow extends ClockRows {
  private static final String FIRST_MIDDLE_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int count;

  public ClockFirstMiddleRow(int hours) {
    count = hours % FIVE_HOURS;
  }

  public String get() {
    return populateARowWithLamps(count, RED_LAMP, FIRST_MIDDLE_ROW_FORMATTER);
  }
}
