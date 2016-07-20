package berlinclock;

public class ClockBodyBottomRow extends ClockBody {
  public static final String BOTTOM_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int minutes;

  public ClockBodyBottomRow(int minutes) {
    this.minutes = minutes;
  }

  public String get() {
    return getARowWithFourLamps(minutes % FIVE_MINUTES, YELLOW_LIGHT, BOTTOM_ROW_FORMATTER);
  }
}
