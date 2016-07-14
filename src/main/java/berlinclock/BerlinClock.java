package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClock {
  public static String displayTimeFor(LocalTime time) {
    if (time.getMinute() == 1) {
      return getFormattedClockFor(bottomRowLights(1));
    }

    if (time.getMinute() == 4) {
      return getFormattedClockFor(bottomRowLights(4));
    }

    return getFormattedClockFor(bottomRowLights(0));
  }

  private static String[] bottomRowLights(int value) {

    final String[] row = {"O", "O", "O", "O"};
    for (int index=0; index<row.length; index++) {
      if (index < value) {
        row[index] = "Y";
      }
    }
    return row;
  }

  private static String getFormattedClockFor(String... state) {
    return format("[O]      [O]      [O]      [O]\n[O]      [O]      [O]      [O]\n[O][O][O][O][O][O][O][O][O][O][O]\n[%s]      [%s]      [%s]      [%s]\n", state);
  }
}
