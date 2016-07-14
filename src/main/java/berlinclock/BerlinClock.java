package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClock {
  public static String displayTimeFor(LocalTime time) {
    if (time.getMinute() == 1) {
      return getFormattedClock("Y", "O", "O", "O");
    }

    if (time.getMinute() == 4) {
      return getFormattedClock("Y", "Y", "Y", "Y");
    }

    return getFormattedClock("O", "O", "O", "O");
  }

  private static String getFormattedClock(String... state) {
    return format("[O]      [O]      [O]      [O]\n[O]      [O]      [O]      [O]\n[O][O][O][O][O][O][O][O][O][O][O]\n[%s]      [%s]      [%s]      [%s]\n", state);
  }
}
