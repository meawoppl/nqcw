package nqcw;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.OptionalInt;
import java.util.Set;

public abstract class QueensSolver {
  abstract boolean isBoardValid(Board board);

  public Set<Board> allSoultionsForBoardOfSize(int size){
    return solutionsForBoard(Board.ofSize(size));
  }

  public Set<Board> solutionsForBoard(Board board) {
    Preconditions.checkArgument(
        isBoardValid(board), "Recursive call passed already invalid configuration");

    // Determine the first free column
    OptionalInt workColumn = board.unoccupiedCols().stream().mapToInt(i -> i).min();

    // Handle the fully populated board state
    if (workColumn.isEmpty()) {
      if (isBoardWinning(board)) return Sets.newHashSet(board);
      else return Sets.newHashSet();
    }

    // Populate the next free column
    int col = workColumn.getAsInt();

    Set<Board> solutions = Sets.newHashSet();
    board
        .unoccupiedRows()
        .stream()
        .mapToInt(i -> i)
        .sorted()
        .forEach(
            (row) -> {
              Board newConfiguration = board.adding(row, col);
              if (isBoardValid(newConfiguration))
                solutions.addAll(solutionsForBoard(newConfiguration));
            });

    return solutions;
  }

  /**
   * This method returns true iff:
   *
   * <ol>
   *   <li>{@code isBoardValid(board)}
   *   <li>The number of placed queens is equal to the board size
   * </ol>
   *
   * @param board to analyse
   * @return boolean value indicating validity of current state as a solution.
   */
  public boolean isBoardWinning(Board board) {
    boolean fullQueenCount = board.getPositions().size() == board.getBoardSize();
    return isBoardValid(board) && fullQueenCount;
  }
}
