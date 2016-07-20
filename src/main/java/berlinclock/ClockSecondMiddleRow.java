package berlinclock;

import static berlinclock.LampState.LAMP_OFF;
import static berlinclock.LampState.RED_LAMP;
import static berlinclock.LampState.YELLOW_LAMP;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ClockSecondMiddleRow extends ClockRows {
  private static final String SECOND_MIDDLE_ROW_FORMATTER =
      "[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]";

  private static final int THIRD_POSITION = 2;
  private static final int SIXTH_POSITION = 5;
  private static final int NINTH_POSITION = 8;

  private static final int MAX_LAMPS_PER_ROW = 11;

  private final int minutes;
  private final int numberOfLampsToSwitchOn;

  public ClockSecondMiddleRow(LocalTime time) {
    minutes = time.getMinute();
    numberOfLampsToSwitchOn = minutes / FIVE_MINUTES;
  }

  public String get() {
    final List<LampState> rowOfLamps = new ArrayList<>();

    if (minutes < FIVE_MINUTES) {
      toggleLampsOnOrOff(rowOfLamps, (index) -> LAMP_OFF);
    } else {
      toggleLampsOnOrOff(rowOfLamps, this::evaluateLamp);
    }

    return String.format(SECOND_MIDDLE_ROW_FORMATTER, rowOfLamps.toArray());
  }

  private void toggleLampsOnOrOff(List<LampState> rowOfLamps, EvaluateLamp evaluateLamp) {
    int index = 0;
    while (index < MAX_LAMPS_PER_ROW) {
      rowOfLamps.add(evaluateLamp.apply(index));
      index++;
    }
  }

  private LampState evaluateLamp(int index) {
    return index < numberOfLampsToSwitchOn
      ? replace1369thPositionsWithRed(index)
          ? RED_LAMP
          : YELLOW_LAMP
      : LAMP_OFF;
  }

  private boolean replace1369thPositionsWithRed(int index) {
    return
        (index == THIRD_POSITION) ||
        (index == SIXTH_POSITION) ||
        (index == NINTH_POSITION);
  }

  interface EvaluateLamp {
    LampState apply(int index);
  }
}
