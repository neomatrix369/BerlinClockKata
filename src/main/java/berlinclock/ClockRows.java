package berlinclock;

abstract class ClockRows {
  static final int FIVE_HOURS = 5;
  static final int FIVE_MINUTES = 5;

  protected int MAX_LAMPS_PER_ROW = 4;

  public abstract String get();
}
