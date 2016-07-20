package berlinclock;

import static java.lang.String.format;

import java.time.LocalTime;

public class BerlinClockConverter {

  private static final String FOUR_ROWS_OF_THE_CLOCK = "%s\n%s\n%s\n%s\n";

  public static String displayTimeFor(LocalTime time) {
    int hours = time.getHour();
    int minutes = time.getMinute();

    return format(FOUR_ROWS_OF_THE_CLOCK,
        new ClockRowsTopRow(hours).get(),
        new ClockRowsFirstMiddleRow(hours).get(),
        new ClockRowsSecondMiddleRow(minutes).get(),
        new ClockRowsBottomRow(minutes).get()
    );
  }
}
