package nqcw;

import java.util.List;
import java.util.Set;

public class NQueensTraditional {
  public static boolean isBoardValid(Board board){
    // Check all unique cols
    Set<Position> positions = board.getPositions();
    if(positions.stream().mapToInt(p -> p.col).distinct().count() < positions.size())
      return false;

    // Check all unique rows
    if(positions.stream().mapToInt(p -> p.row).distinct().count() < positions.size())
      return false;

    // Check the / diagonal
    if(positions.stream().mapToInt(p -> p.row - p.col).distinct().count() < positions.size())
      return false;

    // Check the \ diagonal
    if(positions.stream().mapToInt(p -> p.col - (board.getBoardSize() - p.row)).distinct().count() < positions.size())
      return false;

    return true;
  }

  public static boolean isBoardWinning(Board board){
    boolean fullQueenCount = board.getPositions().size() == board.getBoardSize();
    return isBoardValid(board) && fullQueenCount;
  }

}
