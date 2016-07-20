package berlinclock;

import static java.lang.String.format;

public abstract class ClockBody {
  protected static final int FIVE_HOURS = 5;
  protected static final int FIVE_MINUTES = 5;

  protected static final String LIGHT_OFF = "O";
  protected static final String RED_LIGHT = "R";
  protected static final String YELLOW_LIGHT = "Y";

  protected String getARowWithFourLamps(int count, String lampColour, String rowFormatter) {
    String[] row = new String[] {LIGHT_OFF, LIGHT_OFF, LIGHT_OFF, LIGHT_OFF};

    for (int index=0; index<row.length; index++) {
      if (index < count) {
        row[index] = lampColour;
      }
    }

    return format(rowFormatter, row);
  }

  public abstract String get();
}
