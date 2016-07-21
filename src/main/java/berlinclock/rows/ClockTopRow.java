package berlinclock.rows;

import static berlinclock.lamps.LampState.RED_LAMP;

import java.time.LocalTime;

import berlinclock.lamps.Lamps;

public class ClockTopRow extends ClockRows {
  private static final String TOP_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int numberOfLampsToSwitchOn;

  public ClockTopRow(LocalTime time) {
    numberOfLampsToSwitchOn = time.getHour() / FIVE_HOURS;
  }

  public String get() {
    return new Lamps(
        numberOfLampsToSwitchOn, getMaximumLampsPerRow(), (lampIndex) -> RED_LAMP, TOP_ROW_FORMATTER
    ).get();
  }
}
