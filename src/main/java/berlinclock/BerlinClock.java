package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClock {
  public static final int FIVE_HOURS = 5;
  private static final int FIVE_MINUTES = FIVE_HOURS;

  private static final String RED_LIGHT = "R";
  private static final String YELLOW_LIGHT = "Y";
  private static final String LIGHT_OFF = "O";

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
    final String firstMiddleRow = getFirstMiddleRowLights(hours % FIVE_HOURS);
    final String secondMiddleRow = secondMiddleRowLights(minutes);
    final String bottomRow = bottomRowLights(minutes % FIVE_MINUTES);

    return format("%s\n%s\n%s\n%s\n",
        topRow,
        firstMiddleRow,
        secondMiddleRow,
        bottomRow);
  }

  private static String getTopRow(int hours) {
    String[] topRow = new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};

    int count = hours / FIVE_HOURS;

    for (int index=0; index<count && index<topRow.length; index++) {
      topRow[index] = RED_LIGHT;
    }

    return format(TOP_ROW_FORMATTER, topRow);
  }

  private static String getFirstMiddleRowLights(int hours) {
    String firstMiddleRow[] = new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};

    for (int index=0; index<firstMiddleRow.length; index++) {
      if (index < hours) {
        firstMiddleRow[index] = RED_LIGHT;
      }
    }

    return format(FIRST_MIDDLE_ROW_FORMATTER, firstMiddleRow);
  }

  private static String secondMiddleRowLights(int minutes) {
    final String[] secondMiddleRow = new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF,
        LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};
    if (minutes < FIVE_MINUTES) return getFormattedMiddle(secondMiddleRow);

    switchBlocksInTheMiddleRowOnOrOff(secondMiddleRow, minutes);

    return getFormattedMiddle(secondMiddleRow);
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

  private static String getFormattedMiddle(String[] row) {return format(SECOND_MIDDLE_ROW_FORMATTER, row);}

  private static boolean replace1369thPositionsWithRed(int index) {
    return  (index == 2) ||
            (index == 5) ||
            (index == 8);
  }

  private static String bottomRowLights(int minutes) {
    final String[] row = {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};
    for (int index=0; index<row.length; index++) {
      if (index < minutes) {
        row[index] = YELLOW_LIGHT;
      }
    }
    return format(BOTTOM_ROW_FORMATTER, row);
  }
}
