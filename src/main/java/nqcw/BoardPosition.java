package nqcw;

import java.util.Objects;

class BoardPosition {
  public final int row;
  public final int col;

  private BoardPosition(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public static BoardPosition at(int row, int col) {
    return new BoardPosition(row, col);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BoardPosition position = (BoardPosition) o;
    return row == position.row && col == position.col;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, col);
  }
}
