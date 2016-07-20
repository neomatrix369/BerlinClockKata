package berlinclock;

public class ClockRowsBottomRow extends ClockRows {
  public static final String BOTTOM_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int minutes;

  public ClockRowsBottomRow(int minutes) {
    this.minutes = minutes;
  }

  public String get() {
    return populateARowWithLamps(minutes % FIVE_MINUTES, YELLOW_LIGHT, BOTTOM_ROW_FORMATTER);
  }
}
