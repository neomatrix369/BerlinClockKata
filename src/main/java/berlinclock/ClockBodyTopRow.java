package berlinclock;

public class ClockBodyTopRow extends ClockBody {
  private static final String TOP_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private int hours;

  public ClockBodyTopRow(int hours) {
    this.hours = hours;
  }

  public String get() {
    return getARowWithFourLamps(hours / FIVE_HOURS, RED_LIGHT, TOP_ROW_FORMATTER);
  }
}
