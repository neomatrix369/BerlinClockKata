package berlinclock;

import static berlinclock.LampState.RED_LAMP;

public class ClockRowsFirstMiddleRow extends ClockRows {
  private static final String FIRST_MIDDLE_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private int hours;

  public ClockRowsFirstMiddleRow(int hours) {this.hours = hours;}

  public String get() {
    return populateARowWithLamps(hours % FIVE_HOURS, RED_LAMP, FIRST_MIDDLE_ROW_FORMATTER);
  }
}
