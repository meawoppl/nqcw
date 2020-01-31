package nqcw;

import java.util.Set;

/** This class provides the solution method to the traditional N-Queens problem. */
public class TraditionalSolver extends QueensSolver {

  @Override
  public boolean isBoardValid(Board board) {
    // Check all unique cols
    Set<Position> positions = board.getPositions();
    if (positions.stream().mapToInt(p -> p.col).distinct().count() < positions.size()) return false;

    // Check all unique rows
    if (positions.stream().mapToInt(p -> p.row).distinct().count() < positions.size()) return false;

    // Check the \ diagonal
    if (positions.stream().mapToInt(p -> p.row - p.col).distinct().count() < positions.size())
      return false;

    // Check the / diagonal
    if (positions.stream().mapToInt(p -> p.col - (board.getBoardSize() - p.row)).distinct().count()
        < positions.size()) return false;

    return true;
  }
}
