package berlinclock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.lang.Integer.valueOf;
import static java.time.LocalTime.MIDNIGHT;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.Arrays.asList;
import static berlinclock.BerlinClockConverter.displayTimeFor;

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
                "00:00",
                          "[O]      [O]      [O]      [O]\n" +
                          "[O]      [O]      [O]      [O]\n" +
                          "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                          "[O]      [O]      [O]      [O]\n"
            },
            {
                "00:01",
                          "[O]      [O]      [O]      [O]\n" +
                          "[O]      [O]      [O]      [O]\n" +
                          "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                          "[Y]      [O]      [O]      [O]\n"
            },
            {
                "00:04",
                         "[O]      [O]      [O]      [O]\n" +
                         "[O]      [O]      [O]      [O]\n" +
                         "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                         "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                "00:05",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][O][O][O][O][O][O][O][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                "00:06",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][O][O][O][O][O][O][O][O][O][O]\n" +
                        "[Y]      [O]      [O]      [O]\n"
            },
            {
                "00:11",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][O][O][O][O][O][O][O][O][O]\n" +
                        "[Y]      [O]      [O]      [O]\n"
            },
            {
                "00:15",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][O][O][O][O][O][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                "00:22",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][O][O][O][O][O][O][O]\n" +
                        "[Y]      [Y]      [O]      [O]\n"
            },
            {
                "00:30",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                "00:33",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                        "[Y]      [Y]      [Y]      [O]\n"
            },
            {
                "00:40",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][O][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                "00:45",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][O][O]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                "00:47",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][O][O]\n" +
                        "[Y]      [Y]      [O]      [O]\n"
            },
            {
                "00:55",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                        "[O]      [O]      [O]      [O]\n"
            },
            {
                "00:59",
                        "[O]      [O]      [O]      [O]\n" +
                        "[O]      [O]      [O]      [O]\n" +
                        "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                        "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                "01:10",
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[Y][Y][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "02:30",
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "03:00",
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "03:15",
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[Y][Y][R][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "04:25",
                    "[O]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [R]\n" +
                    "[Y][Y][R][Y][Y][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "05:00",
                    "[R]      [O]      [O]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "06:00",
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "06:45",
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][Y][Y][R][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "09:00",
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [R]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "09:34",
                    "[R]      [O]      [O]      [O]\n" +
                    "[R]      [R]      [R]      [R]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                "11:59",
                    "[R]      [R]      [O]      [O]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                    "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                "12:00",
                    "[R]      [R]      [O]      [O]\n" +
                    "[R]      [R]      [O]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "12:30",
                    "[R]      [R]      [O]      [O]\n" +
                    "[R]      [R]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "15:30",
                    "[R]      [R]      [R]      [O]\n" +
                    "[O]      [O]      [O]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "18:00",
                    "[R]      [R]      [R]      [O]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "21:00",
                    "[R]      [R]      [R]      [R]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "21:17",
                    "[R]      [R]      [R]      [R]\n" +
                    "[R]      [O]      [O]      [O]\n" +
                    "[Y][Y][R][O][O][O][O][O][O][O][O]\n" +
                    "[Y]      [Y]      [O]      [O]\n"
            },
            {
                "23:00",
                    "[R]      [R]      [R]      [R]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "23:04",
                    "[R]      [R]      [R]      [R]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[O][O][O][O][O][O][O][O][O][O][O]\n" +
                    "[Y]      [Y]      [Y]      [Y]\n"
            },
            {
                "23:55",
                    "[R]      [R]      [R]      [R]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                    "[O]      [O]      [O]      [O]\n"
            },
            {
                "23:59",
                    "[R]      [R]      [R]      [R]\n" +
                    "[R]      [R]      [R]      [O]\n" +
                    "[Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]\n" +
                    "[Y]      [Y]      [Y]      [Y]\n"
            }

        }
    );
  }

  public BerlinClockConverterShould(String givenTime, String displayClock) {
    this.givenTime = convertStringToLocalTime(givenTime);
    this.displayClock = displayClock;
  }

  @Test public void
  show_an_equivalent_clock_display_for_the_given_time() {
    assertThat(displayTimeFor(givenTime), is(displayClock));
  }

  private LocalTime convertStringToLocalTime(String timeAsString) {
    String[] splitTime = timeAsString.split(":");
    int hours = valueOf(splitTime[0]);
    int minutes = valueOf(splitTime[1]);
    return MIDNIGHT.plus(hours, HOURS).plus(minutes, MINUTES);
  }
}
