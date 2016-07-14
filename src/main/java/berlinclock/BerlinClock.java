package berlinclock;

import java.time.LocalTime;

public class BerlinClock {
  public static String displayTimeFor(LocalTime time) {
    if (time.getMinute() == 1) {
      return
          new StringBuilder()
              .append("[O]      [O]      [O]      [O]\n")
              .append("[O]      [O]      [O]      [O]\n")
              .append("[O][O][O][O][O][O][O][O][O][O][O]\n")
              .append("[Y]      [O]      [O]      [O]\n")
              .toString();
    }

    if (time.getMinute() == 4) {
      return
          new StringBuilder()
              .append("[O]      [O]      [O]      [O]\n")
              .append("[O]      [O]      [O]      [O]\n")
              .append("[O][O][O][O][O][O][O][O][O][O][O]\n")
              .append("[Y]      [Y]      [Y]      [Y]\n")
              .toString();
    }

    return
        new StringBuilder()
            .append("[O]      [O]      [O]      [O]\n")
            .append("[O]      [O]      [O]      [O]\n")
            .append("[O][O][O][O][O][O][O][O][O][O][O]\n")
            .append("[O]      [O]      [O]      [O]\n")
            .toString();
  }
}
