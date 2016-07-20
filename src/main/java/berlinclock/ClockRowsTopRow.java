package berlinclock;

public class ClockRowsTopRow extends ClockRows {
  private static final String TOP_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private int hours;

  public ClockRowsTopRow(int hours) {
    this.hours = hours;
  }

  public String get() {
    return populateARowWithLamps(hours / FIVE_HOURS, RED_LIGHT, TOP_ROW_FORMATTER);
  }
}
