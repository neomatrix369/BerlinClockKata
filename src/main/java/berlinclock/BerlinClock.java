package berlinclock;

import static java.lang.String.format;
import static berlinclock.lamps.LampState.OFF;
import static berlinclock.lamps.LampState.YELLOW;

import berlinclock.lamps.LampState;
import berlinclock.ui.Console;

public class BerlinClock {
  public static final String LAMP_STATE_FORMATTER = "[%s]";

  private Console console;
  private LampState lastLampState = OFF;

  public BerlinClock(Console console) {
    this.console = console;
  }

  public void tick() {
    lastLampState =
        lastLampState == YELLOW
        ? OFF
        : YELLOW;
    System.out.println(lastLampState);
    console.display(format(LAMP_STATE_FORMATTER, lastLampState));
  }
}
