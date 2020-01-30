package nqcw;

import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;

public class QueenBoard {
  public static final QueenBoard STANDARD_EMPTY = QueenBoard.ofSize(8);

  private int size;
  private Set<BoardPosition> occupation;

  private QueenBoard(int size) {
    Preconditions.checkArgument(size > 0, "Expected size > 0");
    this.size = size;
    this.occupation = new HashSet<>();
  }

  public static QueenBoard ofSize(int size) {
    return new QueenBoard(size);
  }

  public QueenBoard adding(BoardPosition position){
    Preconditions.checkArgument(!occupation.contains(position));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (occupation.contains(BoardPosition.at(row, col))) {
          sb.append("Q");
        } else {
          sb.append((row % 2) == (col % 2) ? " " : "█");
        }
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}
