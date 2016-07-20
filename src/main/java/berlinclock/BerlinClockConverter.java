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

  private static final int THIRD_POSITION = 2;
  private static final int SIXTH_POSITION = 5;
  private static final int NINTH_POSITION = 8;

  public static String displayTimeFor(LocalTime time) {
    int hours = time.getHour();
    int minutes = time.getMinute();

    return format(FOUR_ROWS_OF_THE_CLOCK,
        getTopRow(hours),
        getFirstMiddleRowLights(hours),
        secondMiddleRowLights(minutes),
        bottomRowLights(minutes)
    );
  }

  private static String getTopRow(int hours) {
    return getTheRowWithFourLamps(hours / FIVE_HOURS, RED_LIGHT, TOP_ROW_FORMATTER);
  }

  private static String getFirstMiddleRowLights(int hours) {
    return getTheRowWithFourLamps(hours % FIVE_HOURS, RED_LIGHT, FIRST_MIDDLE_ROW_FORMATTER);
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
      toggleLamp(row, index, YELLOW_LIGHT);
      if (replace1369thPositionsWithRed(index)) {
        toggleLamp(row, index, RED_LIGHT);
      }
    }
  }

  private static boolean replace1369thPositionsWithRed(int index) {
    return  (index == THIRD_POSITION) ||
            (index == SIXTH_POSITION) ||
            (index == NINTH_POSITION);
  }

  private static String bottomRowLights(int minutes) {
    return getTheRowWithFourLamps(minutes % FIVE_MINUTES, YELLOW_LIGHT, BOTTOM_ROW_FORMATTER);
  }

  private static String getTheRowWithFourLamps(int count, String lampColour, String rowFormatter) {
    String[] row = new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};

    for (int index=0; index<row.length; index++) {
      toggleLamp(row, index, count, lampColour);
    }

    return format(rowFormatter, row);
  }

  private static void toggleLamp(String[] row, int index, String lampColour) {row[index] = lampColour;}

  private static void toggleLamp(String[] row, int index, int count, String lampColour) {
    if (index < count) {
      row[index] = lampColour;
    }
  }
}
