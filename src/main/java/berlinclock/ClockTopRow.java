package berlinclock;

import static berlinclock.LampState.RED_LAMP;

import java.time.LocalTime;

public class ClockTopRow extends ClockRows {
  private static final String TOP_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";

  private int numberOfLampsToSwitchOn;

  public ClockTopRow(LocalTime time) {
    numberOfLampsToSwitchOn = time.getHour() / FIVE_HOURS;
  }

  public String get() {
    return populateARowWithLamps(numberOfLampsToSwitchOn, RED_LAMP, TOP_ROW_FORMATTER);
  }
}
