package nqcw;

import com.google.common.annotations.VisibleForTesting;

import java.util.TreeSet;

public class ColinearSolver extends TraditionalSolver {

  /**
   * Compute the greatest common denominator between a and b
   */
  @VisibleForTesting
  protected static int gcd(int a, int b){
    return b == 0 ? a : gcd(b, a % b);
  }

  @Override
  public boolean isBoardValid(Board board) {
    // First enforce all the base problem rules
    if (!super.isBoardValid(board)) return false;

    // Iterate over the _ordered_ set of position permutations
    // We order them so we can only look in the "positive" rows direction
    TreeSet<Position> positions = new TreeSet<>(board.getPositions());

    for (Position p1 : positions) {
      for (Position p2 : positions.tailSet(p1, false)) {
        // Compute the rise/run between these two queens
        int rowStep = p2.row - p1.row;
        int colStep = p2.col - p1.col;

        // Reduce to the minimum step size
        int multiple = Math.abs(gcd(rowStep, colStep));
        rowStep /= multiple;
        colStep /= multiple;

        // Search along that axis until we reach OOB
        Position next = p2;
        while(true) {
          next = Position.at(next.row + rowStep, next.col + colStep);

          if(!board.bounds(next))
            break;
          if (board.hasQueenAt(next)) return false;
        }
      }
    }

    return true;
  }
}
