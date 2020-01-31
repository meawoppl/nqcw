package nqcw;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;

public class ColinearSolverTest extends Assertions {
  @Test
  public void testGCD(){
    assertThat(ColinearSolver.gcd(1, 1)).isEqualTo(1);
    assertThat(ColinearSolver.gcd(4, 2)).isEqualTo(2);
    assertThat(ColinearSolver.gcd(2, 3)).isEqualTo(1);
    assertThat(ColinearSolver.gcd(4, 4)).isEqualTo(4);
    assertThat(ColinearSolver.gcd(11, 22)).isEqualTo(11);
  }

  @Test
  public void testColinearSolver(){
    ColinearSolver solver = new ColinearSolver();

    Set<Board> solutions = solver.allSoultionsForBoardOfSize(8);
    solutions.forEach(board -> System.out.println(board + "\n"));

    System.out.println(solutions.size());
  }


}