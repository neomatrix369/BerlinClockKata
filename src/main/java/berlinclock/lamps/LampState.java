package berlinclock.lamps;

public enum LampState {
  OFF("O"),
  RED("R"),
  YELLOW("Y");

  private final String state;

  LampState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return state;
  }
}
