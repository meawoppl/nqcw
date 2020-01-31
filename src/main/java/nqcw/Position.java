package nqcw;

import com.google.common.collect.ComparisonChain;
import java.util.Objects;

/** Utility class to represent a board position. */
public class Position implements Comparable<Position> {
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
  public int compareTo(Position position) {
    return ComparisonChain.start()
        .compare(this.row, position.row)
        .compare(this.col, position.col)
        .result();
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

  @Override
  public String toString() {
    return String.format("(%d, %d)", row, col);
  }
}
