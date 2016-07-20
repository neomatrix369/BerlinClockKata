package berlinclock;

import static berlinclock.LampState.YELLOW_LAMP;

public class ClockBottomRow extends ClockRows {
  public static final String BOTTOM_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int minutes;
  private final int count;

  public ClockBottomRow(int minutes) {
    this.minutes = minutes;
    count = minutes % FIVE_MINUTES;
  }

  public String get() {
    return populateARowWithLamps(count, YELLOW_LAMP, BOTTOM_ROW_FORMATTER);
  }
}
