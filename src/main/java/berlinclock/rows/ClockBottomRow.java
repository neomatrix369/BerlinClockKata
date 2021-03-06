package berlinclock.rows;

import static berlinclock.lamps.LampState.YELLOW;

import java.time.LocalTime;

import berlinclock.lamps.Lamps;

public class ClockBottomRow extends ClockRows {
  private static final String BOTTOM_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private final int numberOfLampsToSwitchOn;

  public ClockBottomRow(LocalTime time) {
    numberOfLampsToSwitchOn = time.getMinute() % FIVE_MINUTES;
  }

  public String get() {
    return new Lamps(
        numberOfLampsToSwitchOn, getMaximumLampsPerRow(), (lampIndex) -> YELLOW, BOTTOM_ROW_FORMATTER
    ).get();
  }
}
