package berlinclock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.time.LocalTime.MIDNIGHT;
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

  @Parameters
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
                    "[R][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(15, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[R][Y][Y][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(30, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[R][Y][Y][R][Y][Y][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                MIDNIGHT.plus(45, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[R][Y][Y][R][Y][Y][R][Y][Y][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
              MIDNIGHT.plus(59, MINUTES),
                    "[O]      [O]      [O]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[R][Y][Y][R][Y][Y][R][Y][Y][R][Y]\n" +
                    "[Y]      [Y]      [Y]      [Y]\n"
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
