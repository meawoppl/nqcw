package nqcw;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ColinearSolverTest extends Assertions {
  @Test
  public void testGCD() {
    assertThat(ColinearSolver.gcd(1, 1)).isEqualTo(1);
    assertThat(ColinearSolver.gcd(4, 2)).isEqualTo(2);
    assertThat(ColinearSolver.gcd(2, 3)).isEqualTo(1);
    assertThat(ColinearSolver.gcd(4, 4)).isEqualTo(4);
    assertThat(ColinearSolver.gcd(11, 22)).isEqualTo(11);
  }

  @Test
  public void testColinearSolver() {
    ColinearSolver solver = new ColinearSolver();

    Set<Board> solutions = solver.allSolutionsForBoardOfSize(8);
    solutions.forEach(board -> System.out.println(board + "\n"));

    System.out.println(solutions.size());
  }

  @Test
  public void testIsValidImpl() {
    Board invalidConfig1 = Board.ofSize(8).adding(0, 0).adding(1, 2).adding(2, 4);
    Board invalidConfig2 = Board.ofSize(8).adding(0, 0).adding(2, 1).adding(4, 2);
    Board invalidConfig3 = Board.ofSize(8).adding(0, 0).adding(2, 4).adding(3, 6);

    ColinearSolver solver = new ColinearSolver();
    assertThat(solver.isBoardValid(invalidConfig1)).isFalse();
    assertThat(solver.isBoardValid(invalidConfig2)).isFalse();
    assertThat(solver.isBoardValid(invalidConfig3)).isFalse();

    assertThat(solver.isBoardValid(BoardTest.KNOWN_4X4_SOLUTION)).isTrue();
    assertThat(solver.isBoardValid(Board.ofSize(100))).isTrue();
  }

  @Test
  public void testSolutionsSubset() {
    // Solutions provided by this are a subset of solutions for the parent problem
    for (int i = 3; i < 9; i++) {
      Set<Board> solutionsParent = new TraditionalSolver().allSolutionsForBoardOfSize(i);
      Set<Board> solutionsChild = new TraditionalSolver().allSolutionsForBoardOfSize(i);

      solutionsChild.forEach(s -> assertThat(solutionsParent).contains(s));
    }
  }
}
