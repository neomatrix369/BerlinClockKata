package berlinclock;

import static berlinclock.LampState.RED_LAMP;

import java.time.LocalTime;

public class ClockFirstMiddleRow extends ClockRows {
  private static final String FIRST_MIDDLE_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int numberOfLampsToSwitchOn;

  public ClockFirstMiddleRow(LocalTime time) {
    numberOfLampsToSwitchOn = time.getHour() % FIVE_HOURS;
  }

  public String get() {
    return new Lamps(
        numberOfLampsToSwitchOn,
        MAXIMUM_LAMPS_PER_ROW,
        (index) -> RED_LAMP,
        FIRST_MIDDLE_ROW_FORMATTER
    ).getRow();
  }
}
