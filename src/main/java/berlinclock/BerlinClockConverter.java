package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClockConverter {

  private static final String FOUR_ROWS_OF_THE_CLOCK = "%s\n%s\n%s\n%s\n";

  public static String displayTimeFor(LocalTime time) {
    return format(FOUR_ROWS_OF_THE_CLOCK,
        new ClockTopRow(time).get(),
        new ClockFirstMiddleRow(time).get(),
        new ClockSecondMiddleRow(time).get(),
        new ClockBottomRow(time).get()
    );
  }
}
