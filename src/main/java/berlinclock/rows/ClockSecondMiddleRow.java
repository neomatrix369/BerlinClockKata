package berlinclock.rows;

import static berlinclock.lamps.LampState.OFF;
import static berlinclock.lamps.LampState.RED;
import static berlinclock.lamps.LampState.YELLOW;

import java.time.LocalTime;

import berlinclock.lamps.EvaluateLamp;
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
        numberOfLampsToSwitchOn,
        getMaximumLampsPerRow(),
        toggleLampsOnOrOff(),
        SECOND_MIDDLE_ROW_FORMATTER
    ).get();
  }

  private EvaluateLamp toggleLampsOnOrOff() {
    return minutes < FIVE_MINUTES
        ? lampIndex -> OFF
        : this::evaluateLampAt;
  }

  private LampState evaluateLampAt(int index) {
    return index < numberOfLampsToSwitchOn
      ? isItThe3rd6thOr9thPosition(index)
          ? RED
          : YELLOW
      : OFF;
  }

  private boolean isItThe3rd6thOr9thPosition(int lampIndex) {
    return
        (lampIndex == THIRD_POSITION) ||
        (lampIndex == SIXTH_POSITION) ||
        (lampIndex == NINTH_POSITION);
  }
}
