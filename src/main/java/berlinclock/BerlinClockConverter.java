package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClockConverter {
  private static final int FIVE_HOURS = 5;
  private static final int FIVE_MINUTES = 5;

  private static final String RED_LIGHT = "R";
  private static final String YELLOW_LIGHT = "Y";
  private static final String LIGHT_OFF = "O";

  private static final String FOUR_ROWS_OF_THE_CLOCK = "%s\n%s\n%s\n%s\n";

  private static final String TOP_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";
  private static final String FIRST_MIDDLE_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";
  private static final String SECOND_MIDDLE_ROW_FORMATTER =
      "[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]";
  private static final String BOTTOM_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  public static String displayTimeFor(LocalTime time) {
    int hours = time.getHour();
    int minutes = time.getMinute();

    final String topRow = getTopRow(hours);
    final String firstMiddleRow = getFirstMiddleRowLights(hours);
    final String secondMiddleRow = secondMiddleRowLights(minutes);
    final String bottomRow = bottomRowLights(minutes);

    return format(FOUR_ROWS_OF_THE_CLOCK,
        topRow,
        firstMiddleRow,
        secondMiddleRow,
        bottomRow
    );
  }

  private static String getTopRow(int hours) {
    int count = hours / FIVE_HOURS;

    String[] row = new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};
    for (int index=0; index<count && index<row.length; index++) {
      row[index] = RED_LIGHT;
    }

    return format(TOP_ROW_FORMATTER, row);
  }

  private static String getFirstMiddleRowLights(int hours) {
    int count = hours % FIVE_HOURS;

    String row[] = new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};
    for (int index=0; index<row.length; index++) {
      if (index < count) {
        row[index] = RED_LIGHT;
      }
    }

    return format(FIRST_MIDDLE_ROW_FORMATTER, row);
  }

  private static String secondMiddleRowLights(int minutes) {
    final String[] row =
        new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF,
        LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};
    if (minutes < FIVE_MINUTES) return format(SECOND_MIDDLE_ROW_FORMATTER, row);

    switchBlocksInTheMiddleRowOnOrOff(row, minutes);

    return format(SECOND_MIDDLE_ROW_FORMATTER, row);
  }

  private static void switchBlocksInTheMiddleRowOnOrOff(String[] row, int minutes) {
    int count = minutes / FIVE_MINUTES;

    for (int index = 0; index<count && index < row.length; index++) {
      row[index] = YELLOW_LIGHT;
      if (replace1369thPositionsWithRed(index)) {
        row[index] = RED_LIGHT;
      }
    }
  }

  private static boolean replace1369thPositionsWithRed(int index) {
    return  (index == 2) ||
            (index == 5) ||
            (index == 8);
  }

  private static String bottomRowLights(int minutes) {
    int count = minutes % FIVE_MINUTES;

    final String[] row = {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};
    for (int index=0; index<row.length; index++) {
      if (index < count) {
        row[index] = YELLOW_LIGHT;
      }
    }
    return format(BOTTOM_ROW_FORMATTER, row);
  }
}
