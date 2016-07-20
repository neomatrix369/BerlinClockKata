package berlinclock;

import static berlinclock.LampState.YELLOW_LAMP;

import java.time.LocalTime;

public class ClockBottomRow extends ClockRows {
  public static final String BOTTOM_ROW_FORMATTER =
      "[%s]      [%s]      [%s]      [%s]";
  
  private final int numberOfLampsToSwitchOn;

  public ClockBottomRow(LocalTime time) {
    numberOfLampsToSwitchOn = time.getMinute() % FIVE_MINUTES;
  }

  public String get() {
    return populateARowWithLamps(numberOfLampsToSwitchOn, YELLOW_LAMP, BOTTOM_ROW_FORMATTER);
  }
}
