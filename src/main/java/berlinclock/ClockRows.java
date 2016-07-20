package berlinclock;

import static java.lang.String.format;

public abstract class ClockRows {
  protected static final int FIVE_HOURS = 5;
  protected static final int FIVE_MINUTES = 5;

  protected static final String LAMP_OFF = "O";
  protected static final String RED_LAMP = "R";
  protected static final String YELLOW_LAMP = "Y";

  protected String populateARowWithLamps(int count, String lampColour, String rowFormatter) {
    String[] row = new String[] {LAMP_OFF, LAMP_OFF, LAMP_OFF, LAMP_OFF};

    for (int index=0; index<row.length; index++) {
      if (index < count) {
        row[index] = lampColour;
      }
    }

    return format(rowFormatter, row);
  }

  public abstract String get();
}
