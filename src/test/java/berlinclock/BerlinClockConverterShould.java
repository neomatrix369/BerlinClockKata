package berlinclock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.time.LocalTime.MIDNIGHT;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.Arrays.asList;
import static berlinclock.BerlinClock.displayTimeFor;

import java.time.LocalTime;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BerlinClockConverterShould {
  private final LocalTime givenTime;
  private final String displayClock;

  @Parameters (name="{index}: for givenTime {0}")
  public static Collection<Object[]> data() {
    return asList(
        new Object[][]{
            {
                MIDNIGHT, "[O]      [O]      [O]      [O]\n" +
                          "[O]      [O]      [O]      [O]\n" +
                          "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                          "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(1, MINUTES),
                          "[O]      [O]      [O]      [O]\n" +
                          "[O]      [O]      [O]      [O]\n" +
                          "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                          "[Y]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(4, MINUTES),
                         "[O]      [O]      [O]      [O]\n" +
                         "[O]      [O]      [O]      [O]\n" +
                         "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                         "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                MIDNIGHT.plus(5, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][O][O][O][O][O][O][O][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(6, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][O][O][O][O][O][O][O][O][O][O]\n" +
                        "[Y]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(11, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][O][O][O][O][O][O][O][O][O]\n" +
                        "[Y]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(15, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][O][O][O][O][O][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(22, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][O][O][O][O][O][O][O]\n" +
                        "[Y]      [Y]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(30, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(33, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                        "[Y]      [Y]      [Y]      [O]\n"
            },
            {
                MIDNIGHT.plus(40, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(45, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(47, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][O][O]\n" +
                        "[Y]      [Y]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(55, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
              MIDNIGHT.plus(59, MINUTES),
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                        "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                MIDNIGHT.plus(1, HOURS).plus(10, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[Y][Y][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(2, HOURS).plus(30, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(3, HOURS),
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(3, HOURS).plus(15, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[Y][Y][R][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(4, HOURS).plus(25, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [R]\n" +
                    "[Y][Y][R][Y][Y][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(5, HOURS),
                    "[R]      [O]      [O]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(6, HOURS),
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(6, HOURS).plus(45, MINUTES),
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][Y][Y][R][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(9, HOURS),
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [R]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(9, HOURS).plus(34, MINUTES),
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [R]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                MIDNIGHT.plus(11, HOURS).plus(59, MINUTES),
                    "[R]      [R]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                    "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                MIDNIGHT.plus(12, HOURS),
                    "[R]      [R]      [O]      [O]\n" +
                    "[R]      [R]      [O]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(12, HOURS).plus(30, MINUTES),
                    "[R]      [R]      [O]      [O]\n" +
                    "[R]      [R]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(15, HOURS).plus(30, MINUTES),
                    "[R]      [R]      [R]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            }

        }
    );
  }

  public BerlinClockConverterShould(LocalTime givenTime, String displayClock) {
    this.givenTime = givenTime;
    this.displayClock = displayClock;
  }

  @Test public void
  show_an_equivalent_clock_display_for_the_given_time() {
    assertThat(displayTimeFor(givenTime), is(displayClock));
  }
}
