package berlinclock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.time.LocalTime.MIDNIGHT;
import static java.time.temporal.ChronoUnit.MINUTES;

import org.junit.Test;

public class BerlinClockPresenterShould {
  @Test public void
  show_a_dimmed_clock_for_midnight() {
    assertThat(BerlinClock.displayTimeFor(MIDNIGHT),
          is("[O]      [O]      [O]      [O]\n" +
             "[O]      [O]      [O]      [O]\n" +
             "[O][O][O][O][O][O][O][O][O][O][O]\n" +
             "[O]      [O]      [O]      [O]\n"));
  }

  @Test public void
  show_the_appropriate_clock_for_one_minute_past_midnight() {
    assertThat(BerlinClock.displayTimeFor(MIDNIGHT.plus(1, MINUTES)),
        is("[O]      [O]      [O]      [O]\n" +
           "[O]      [O]      [O]      [O]\n" +
           "[O][O][O][O][O][O][O][O][O][O][O]\n" +
           "[Y]      [O]      [O]      [O]\n"));
  }


  @Test public void
  show_clock_with_last_row_lit_up_for_four_minutes_past_midnight() {
    assertThat(BerlinClock.displayTimeFor(MIDNIGHT.plus(4, MINUTES)),
        is("[O]      [O]      [O]      [O]\n" +
           "[O]      [O]      [O]      [O]\n" +
           "[O][O][O][O][O][O][O][O][O][O][O]\n" +
           "[Y]      [Y]      [Y]      [Y]\n"));
  }

  @Test public void
  show_clock_with_the_first_part_of_the_third_row_lit_up_for_15_minutes_past_midnight() {
    assertThat(BerlinClock.displayTimeFor(MIDNIGHT.plus(15, MINUTES)),
        is("[O]      [O]      [O]      [O]\n" +
            "[O]      [O]      [O]      [O]\n" +
            "[R][Y][Y][O][O][O][O][O][O][O][O]\n" +
            "[O]      [O]      [O]      [O]\n"));
  }

  @Test public void
  show_clock_with_the_1st_and_2nd_parts_of_the_third_row_lit_up_for_30_minutes_past_midnight() {
    assertThat(BerlinClock.displayTimeFor(MIDNIGHT.plus(30, MINUTES)),
        is("[O]      [O]      [O]      [O]\n" +
            "[O]      [O]      [O]      [O]\n" +
            "[R][Y][Y][R][Y][Y][O][O][O][O][O]\n" +
            "[O]      [O]      [O]      [O]\n"));
  }
}
