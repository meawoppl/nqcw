package nqcw;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/** A basic representation of a chessboard which can contain queens */
public class Board {
  public static final Board STANDARD_EMPTY = Board.ofSize(8);

  private int boardSize;
  private Set<Position> positions;

  private Board(int boardSize, Collection<Position> positions) {
    Preconditions.checkArgument(boardSize > 0, "Expected boardSize > 0");
    this.boardSize = boardSize;
    this.positions = new HashSet<>(positions);
  }

  /**
   * Construct an Empty board with (size x size) empty squares.
   *
   * @param size size of the board.
   * @return Empty Board instance of size.
   */
  public static Board ofSize(int size) {
    return new Board(size, new HashSet<>());
  }

  public boolean hasQueenAt(Position position) {
    checkBounded(position);

    return positions.contains(position);
  }

  public boolean bounds(Position position) {
    return position.row >= 0
        && position.row < boardSize
        && position.col >= 0
        && position.col < boardSize;
  }

  private void checkBounded(Position position) {
    Preconditions.checkArgument(
        bounds(position), "Position %s is OOB on board size %s", position, boardSize);
  }

  /**
   * Create a copy of this board with an additional Queen at `position`.
   *
   * @throws IllegalArgumentException if position is already occupied or OOB.
   * @param position to add to the new board instance.
   * @return updated board copy.
   */
  public Board adding(Position position) {
    checkBounded(position);
    Preconditions.checkArgument(!positions.contains(position));

    ArrayList<Position> positions = new ArrayList<>(this.positions);
    positions.add(position);
    return new Board(boardSize, positions);
  }

  /**
   * Shortcut for {@code adding(Position.at(row, col))}
   *
   * @param row to add a queen to
   * @param col to add a queen to
   * @return updated board copy.
   */
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

  /**
   * Calculate the Set of (zero indexed) unoccupied rows of this board instance.
   *
   * @return Set of Integer row indices
   */
  public Set<Integer> unoccupiedRows() {
    Set<Integer> results = validRowColRange();
    positions.forEach((pos) -> results.remove(pos.row));
    return results;
  }

  /**
   * Calculate the Set of (zero indexed) unoccupied columns of this board instance.
   *
   * @return Set of Integer column indices
   */
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

  /**
   * Print and ascii art rendition of this board.
   *
   * @return String representation
   */
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
