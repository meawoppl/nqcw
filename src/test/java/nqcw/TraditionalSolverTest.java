package nqcw;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TraditionalSolverTest extends Assertions {

  @Test
  public void isBoardValid() {
    TraditionalSolver solver = new TraditionalSolver();

    assertThat(solver.isBoardValid(Board.STANDARD_EMPTY)).isTrue();

    // Row col check
    assertThat(solver.isBoardValid(Board.STANDARD_EMPTY.adding(0, 0).adding(1, 0))).isFalse();
    assertThat(solver.isBoardValid(Board.STANDARD_EMPTY.adding(0, 0).adding(0, 1))).isFalse();

    // Pos diagonal
    assertThat(solver.isBoardValid(Board.STANDARD_EMPTY.adding(0, 0).adding(3, 3))).isFalse();

    // Neg diagonal
    assertThat(solver.isBoardValid(Board.STANDARD_EMPTY.adding(3, 0).adding(0, 3))).isFalse();

    assertThat(solver.isBoardValid(BoardTest.KNOWN_4X4_SOLUTION)).isTrue();
  }

  @Test
  public void isBoardWinning() {
    TraditionalSolver solver = new TraditionalSolver();

    assertThat(solver.isBoardWinning(Board.STANDARD_EMPTY)).isFalse();
    assertThat(solver.isBoardWinning(Board.STANDARD_EMPTY.adding(0, 0).adding(1, 0))).isFalse();
    assertThat(solver.isBoardWinning(Board.STANDARD_EMPTY.adding(0, 0).adding(0, 1))).isFalse();

    assertThat(solver.isBoardWinning(BoardTest.KNOWN_4X4_SOLUTION)).isTrue();
  }

  // https://en.wikipedia.org/wiki/Eight_queens_puzzle#Counting_solutions
  public static int[] EXPECTED_SOLUTION_COUNT = new int[] {-1, 1, 0, 0, 2, 10, 4, 40, 92, 352};

  @Test
  public void testSolutionsForBoard() {
    TraditionalSolver solver = new TraditionalSolver();

    for (int boardSize = 1; boardSize < EXPECTED_SOLUTION_COUNT.length; boardSize++) {
      Set<Board> solutions = solver.solutionsForBoard(Board.ofSize(boardSize));
      assertThat(solutions.size()).isEqualTo(EXPECTED_SOLUTION_COUNT[boardSize]);

      System.out.print(String.format("Solutions for size=%d", boardSize));
      for (Board b : solutions) {
        System.out.println();
        System.out.println(b);
      }
    }
  }
}
