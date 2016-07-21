package berlinclock;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static java.lang.String.format;
import static berlinclock.BerlinClock.LAMP_STATE_FORMATTER;
import static berlinclock.lamps.LampState.OFF;
import static berlinclock.lamps.LampState.YELLOW;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import berlinclock.ui.Console;

public class BerlinClockShould {
  private Console console;
  private BerlinClock berlinClock;
  private InOrder inOrder;

  @Before
  public void initialise() {
    console = mock(Console.class);
    inOrder = inOrder(console);

    berlinClock = new BerlinClock(console);
  }

  @Test public void
  display_on_indicator_in_yellow_on_its_first_tick() {
    berlinClock.tick(); // YELLOW

    inOrder.verify(console).display(format(LAMP_STATE_FORMATTER, YELLOW));
  }

  @Test public void
  display_off_indicator_on_when_it_ticks_twice_the_first_time() {
    berlinClock.tick(); // YELLOW
    berlinClock.tick(); // OFF

    inOrder.verify(console).display(format(LAMP_STATE_FORMATTER, YELLOW));
    inOrder.verify(console).display(format(LAMP_STATE_FORMATTER, OFF));
  }

  @Test public void
  display_on_indicator_when_it_ticks_a_few_times_the_first_time() {
    berlinClock.tick(); // YELLOW
    berlinClock.tick(); // OFF
    berlinClock.tick(); // YELLOW

    System.out.println();
    inOrder.verify(console).display(format(LAMP_STATE_FORMATTER, YELLOW));
    inOrder.verify(console).display(format(LAMP_STATE_FORMATTER, OFF));
    inOrder.verify(console).display(format(LAMP_STATE_FORMATTER, YELLOW));
  }
}
