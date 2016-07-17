package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClock {
  private static final int FIVE_MINUTES = 5;

  private static final String RED_LIGHT = "R";
  private static final String YELLOW_LIGHT = "Y";
  private static final String LIGHT_OFF = "O";

  public static final String TOP_ROW_FORMATTER =
      format("[%s]      [%s]      [%s]      [%s]", LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF);
  public static final String FIRST_MIDDLE_ROW_FORMATTER =
      format("[%s]      [%s]      [%s]      [%s]", LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF);
  public static final String SECOND_MIDDLE_ROW_FORMATTER =
      "[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]";

  public static String displayTimeFor(LocalTime time) {
    int minutes = time.getMinute();

    final String secondMiddleRow = secondMiddleRowLights(minutes);
    final String bottomRow = bottomRowLights(minutes % FIVE_MINUTES);

    return format("%s\n%s\n%s\n%s\n",
        TOP_ROW_FORMATTER,
        FIRST_MIDDLE_ROW_FORMATTER,
        secondMiddleRow,
        bottomRow);
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
      if (replace1369thPositionsWithRed(index)) {
        row[index] = RED_LIGHT;
      } else  {
        row[index] = YELLOW_LIGHT;
      }
    }
  }

  private static String getFormattedMiddle(String[] row) {return format(SECOND_MIDDLE_ROW_FORMATTER, row);}

  private static boolean replace1369thPositionsWithRed(int index) {
    return (index == 0) ||
        (index % 3 == 0) ||
        (index % 6 == 0) ||
        (index % 9 == 0);
  }

  private static String bottomRowLights(int minutes) {
    final String[] row = {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};
    for (int index=0; index<row.length; index++) {
      if (index < minutes) {
        row[index] = YELLOW_LIGHT;
      }
    }
    return format("[%s]      [%s]      [%s]      [%s]", row);
  }
}
