package berlinclock.rows;

import static berlinclock.lamps.LampState.RED;

import java.time.LocalTime;

import berlinclock.lamps.Lamps;

public class ClockFirstMiddleRow extends ClockRows {
  private static final String FIRST_MIDDLE_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int numberOfLampsToSwitchOn;

  public ClockFirstMiddleRow(LocalTime time) {
    numberOfLampsToSwitchOn = time.getHour() % FIVE_HOURS;
  }

  public String get() {
    return new Lamps(
        numberOfLampsToSwitchOn, getMaximumLampsPerRow(), (lampIndex) -> RED, FIRST_MIDDLE_ROW_FORMATTER
    ).get();
  }
}
