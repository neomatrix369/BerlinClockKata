package berlinclock;

import static berlinclock.LampState.YELLOW_LAMP;

public class ClockBottomRow extends ClockRows {
  public static final String BOTTOM_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int minutes;

  public ClockBottomRow(int minutes) {
    this.minutes = minutes;
  }

  public String get() {
    return populateARowWithLamps(minutes % FIVE_MINUTES, YELLOW_LAMP, BOTTOM_ROW_FORMATTER);
  }
}
