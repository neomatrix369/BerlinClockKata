package berlinclock;

import static berlinclock.LampState.RED_LAMP;

public class ClockRowsTopRow extends ClockRows {
  private static final String TOP_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private int hours;

  public ClockRowsTopRow(int hours) {
    this.hours = hours;
  }

  public String get() {
    return populateARowWithLamps(hours / FIVE_HOURS, RED_LAMP, TOP_ROW_FORMATTER);
  }
}
