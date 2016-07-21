package berlinclock.lamps;

public enum LampState {
  LAMP_OFF("O"),
  RED_LAMP("R"),
  YELLOW_LAMP("Y");

  private final String state;

  LampState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return state;
  }
}
