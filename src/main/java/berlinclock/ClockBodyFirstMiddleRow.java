package berlinclock;

public class ClockBodyFirstMiddleRow extends ClockBody {
  private static final String FIRST_MIDDLE_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private int hours;

  public ClockBodyFirstMiddleRow(int hours) {this.hours = hours;}

  public String get() {
    return getARowWithFourLamps(hours % FIVE_HOURS, RED_LIGHT, FIRST_MIDDLE_ROW_FORMATTER);
  }
}
