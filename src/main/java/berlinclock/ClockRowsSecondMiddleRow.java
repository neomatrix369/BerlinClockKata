package berlinclock;

import static berlinclock.LampState.LAMP_OFF;
import static berlinclock.LampState.RED_LAMP;
import static berlinclock.LampState.YELLOW_LAMP;

import java.util.ArrayList;
import java.util.List;

public class ClockRowsSecondMiddleRow extends ClockRows {
  private static final String SECOND_MIDDLE_ROW_FORMATTER =
      "[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]";

  private static final int THIRD_POSITION = 2;
  private static final int SIXTH_POSITION = 5;
  private static final int NINTH_POSITION = 8;

  private static final int MAX_LAMPS_PER_ROW = 11;

  private final int minutes;

  public ClockRowsSecondMiddleRow(int minutes) {
    this.minutes = minutes;
  }

  public String get() {
    final List<LampState> row = new ArrayList<>();

    if (minutes < FIVE_MINUTES) {
      int index = 0;
      while (index < MAX_LAMPS_PER_ROW) {
        row.add(LAMP_OFF);
        index++;
      }
    } else {
      int count = minutes / FIVE_MINUTES;

      int index = 0;
      while (index < MAX_LAMPS_PER_ROW) {
        row.add(index < count
            ? replace1369thPositionsWithRed(index)
                  ? RED_LAMP
                  : YELLOW_LAMP
            : LAMP_OFF);
        index++;
      }
    }

    return String.format(SECOND_MIDDLE_ROW_FORMATTER, row.toArray());
  }

  private boolean replace1369thPositionsWithRed(int index) {
    return (index == THIRD_POSITION) ||
        (index == SIXTH_POSITION) ||
        (index == NINTH_POSITION);
  }
}
