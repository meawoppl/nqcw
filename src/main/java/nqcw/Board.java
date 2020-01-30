package nqcw;

import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Board {
  public static final Board STANDARD_EMPTY = Board.ofSize(8);

  private int boardSize;
  private Set<Position> positions;

  private Board(int boardSize, Collection<Position> positions) {
    Preconditions.checkArgument(boardSize > 0, "Expected boardSize > 0");
    this.boardSize = boardSize;
    this.positions = new HashSet<>(positions);
  }

  public static Board ofSize(int size) {
    return new Board(size, new HashSet<>());
  }

  private void checkBounded(Position position) {
    Preconditions.checkArgument(
        position.row >= 0 && position.row < boardSize, "Row %s is OOB", position.row);
    Preconditions.checkArgument(
        position.col >= 0 && position.col < boardSize, "Col %s is OOB", position.col);
  }

  public Board adding(Position position) {
    checkBounded(position);
    Preconditions.checkArgument(!positions.contains(position));

    ArrayList<Position> positions = new ArrayList<>(this.positions);
    positions.add(position);
    return new Board(boardSize, positions);
  }

  public Board adding(int row, int col) {
    return adding(Position.at(row, col));
  }

  private Set<Integer> validRowColRange() {
    Set<Integer> results = new HashSet<>();
    for (int i = 0; i < boardSize; i++) {
      results.add(i);
    }
    return results;
  }

  public Set<Integer> unoccupiedRows() {
    Set<Integer> results = validRowColRange();
    positions.forEach((pos) -> results.remove(pos.row));
    return results;
  }

  public Set<Integer> unoccupiedCols() {
    Set<Integer> results = validRowColRange();
    positions.forEach((pos) -> results.remove(pos.col));
    return results;
  }

  public Set<Position> getPositions() {
    return positions;
  }

  public int getBoardSize() {
    return boardSize;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        if (positions.contains(Position.at(row, col))) {
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
