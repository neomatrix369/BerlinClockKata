package berlinclock;

public class ClockBodySecondMiddleRow extends ClockBody {
  private static final String SECOND_MIDDLE_ROW_FORMATTER =
      "[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]";

  private static final int THIRD_POSITION = 2;
  private static final int SIXTH_POSITION = 5;
  private static final int NINTH_POSITION = 8;

  private final int minutes;

  public ClockBodySecondMiddleRow(int minutes) {
    this.minutes = minutes;
  }

  public String get() {
    final String[] row =
        new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF,
            LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};

    if (minutes < FIVE_MINUTES)
      return String.format(SECOND_MIDDLE_ROW_FORMATTER, row);

    switchBlocksInTheMiddleRowOnOrOff(row, minutes);

    return String.format(SECOND_MIDDLE_ROW_FORMATTER, row);
  }

  private void switchBlocksInTheMiddleRowOnOrOff(String[] row, int minutes) {
    int count = minutes / FIVE_MINUTES;

    for (int index = 0; index < count && index < row.length; index++) {
      row[index] = YELLOW_LIGHT;
      if (replace1369thPositionsWithRed(index)) {
        row[index] = RED_LIGHT;
      }
    }
  }

  private boolean replace1369thPositionsWithRed(int index) {
    return (index == THIRD_POSITION) ||
        (index == SIXTH_POSITION) ||
        (index == NINTH_POSITION);
  }
}
