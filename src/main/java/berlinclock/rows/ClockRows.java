package berlinclock.rows;

public abstract class ClockRows {
  protected static final int FIVE_HOURS = 5;
  protected static final int FIVE_MINUTES = 5;

  protected abstract String get();

  protected int getMaximumLampsPerRow() {
    return 4;
  }
}
