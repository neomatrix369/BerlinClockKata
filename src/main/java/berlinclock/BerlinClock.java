package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClock {
  public static String displayTimeFor(LocalTime time) {
    final String topRow         = "[O]      [O]      [O]      [O]";
    final String firstMiddleRow = "[O]      [O]      [O]      [O]";

    int minutes = time.getMinute();
    String secondMiddleRow;
    if (minutes > 4) {
      secondMiddleRow = secondMiddleRowLights(minutes);
      minutes = 0;
    } else {
      secondMiddleRow = secondMiddleRowLights(0);
    }

    final String bottomRow = bottomRowLights(minutes);

    return format("%s\n%s\n%s\n%s\n",
        topRow,
        firstMiddleRow,
        secondMiddleRow,
        bottomRow);
  }

  private static String secondMiddleRowLights(int minutes) {
    final String[] row = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
    if (minutes == 0) return getFormattedMiddle(row);

    for (int index=0; index<row.length; index++) {
      if ((intoMinutes(index)) >= minutes) return getFormattedMiddle(row);

      if (replace1369thPositionsWithRed(index)) {
        row[index] = "R";
      } else if (intoMinutes(index) < minutes) {
        row[index] = "Y";
      }
    }
    return getFormattedMiddle(row);
  }

  private static String getFormattedMiddle(String[] row) {return format("[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]", row);}

  private static int intoMinutes(int index) {return 5 * index + 1;}

  private static boolean replace1369thPositionsWithRed(int index) {
    return (index == 0) ||
        (index % 3 == 0) ||
        (index % 6 == 0) ||
        (index % 9 == 0);
  }

  private static String bottomRowLights(int minutes) {
    final String[] row = {"O", "O", "O", "O"};
    for (int index=0; index<row.length; index++) {
      if (index < minutes) {
        row[index] = "Y";
      }
    }
    return format("[%s]      [%s]      [%s]      [%s]", row);
  }
}
