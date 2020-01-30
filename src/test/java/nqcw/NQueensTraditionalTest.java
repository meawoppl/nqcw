package nqcw;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class NQueensTraditionalTest extends Assertions {

  @Test
  public void isBoardValid() {
    assertThat(NQueensTraditional.isBoardValid(Board.STANDARD_EMPTY)).isTrue();

    // Row col check
    assertThat(NQueensTraditional.isBoardValid(Board.STANDARD_EMPTY.adding(0, 0).adding(1, 0))).isFalse();
    assertThat(NQueensTraditional.isBoardValid(Board.STANDARD_EMPTY.adding(0, 0).adding(0, 1))).isFalse();

    // Pos diagonal
    assertThat(NQueensTraditional.isBoardValid(Board.STANDARD_EMPTY.adding(0, 0).adding(3, 3))).isFalse();

    // Neg diagonal
    assertThat(NQueensTraditional.isBoardValid(Board.STANDARD_EMPTY.adding(3, 0).adding(0, 3))).isFalse();


    assertThat(NQueensTraditional.isBoardValid(BoardTest.KNOWN_4X4_SOLUTION)).isTrue();
  }

  @Test
  public void isBoardWinning() {
    assertThat(NQueensTraditional.isBoardWinning(Board.STANDARD_EMPTY)).isFalse();
    assertThat(NQueensTraditional.isBoardWinning(Board.STANDARD_EMPTY.adding(0, 0).adding(1, 0))).isFalse();
    assertThat(NQueensTraditional.isBoardWinning(Board.STANDARD_EMPTY.adding(0, 0).adding(0, 1))).isFalse();

    assertThat(NQueensTraditional.isBoardWinning(BoardTest.KNOWN_4X4_SOLUTION)).isTrue();
  }
}