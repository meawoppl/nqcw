package nqcw;

import java.util.Objects;

class Position {
  public final int row;
  public final int col;

  private Position(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public static Position at(int row, int col) {
    return new Position(row, col);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return row == position.row && col == position.col;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, col);
  }
}
