package berlinclock.rows;

import static berlinclock.lamps.LampState.LAMP_OFF;
import static berlinclock.lamps.LampState.RED_LAMP;
import static berlinclock.lamps.LampState.YELLOW_LAMP;

import java.time.LocalTime;

import berlinclock.lamps.LampState;
import berlinclock.lamps.Lamps;

public class ClockSecondMiddleRow extends ClockRows {
  private static final String SECOND_MIDDLE_ROW_FORMATTER =
      "[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]";

  private static final int THIRD_POSITION = 2;
  private static final int SIXTH_POSITION = 5;
  private static final int NINTH_POSITION = 8;

  private final int minutes;
  private final int numberOfLampsToSwitchOn;

  public ClockSecondMiddleRow(LocalTime time) {
    minutes = time.getMinute();
    numberOfLampsToSwitchOn = minutes / FIVE_MINUTES;
  }

  protected int getMaximumLampsPerRow() {return 11;}

  public String get() {
    return new Lamps(
        numberOfLampsToSwitchOn, getMaximumLampsPerRow(),
        minutes < FIVE_MINUTES
            ? index -> LAMP_OFF
            : this::evaluateLampAt,
        SECOND_MIDDLE_ROW_FORMATTER
    ).get();
  }

  private LampState evaluateLampAt(int index) {
    return index < numberOfLampsToSwitchOn
      ? replace3rd6thAnd9thPositionsWithRed(index)
          ? RED_LAMP
          : YELLOW_LAMP
      : LAMP_OFF;
  }

  private boolean replace3rd6thAnd9thPositionsWithRed(int index) {
    return
        (index == THIRD_POSITION) ||
        (index == SIXTH_POSITION) ||
        (index == NINTH_POSITION);
  }
}
