package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClock {
  public static String displayTimeFor(LocalTime time) {
    return format("[O]      [O]      [O]      [O]\n[O]      [O]      [O]      [O]\n[O][O][O][O][O][O][O][O][O][O][O]\n[%s]      [%s]      [%s]      [%s]\n", bottomRowLights(time.getMinute()));
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
}
