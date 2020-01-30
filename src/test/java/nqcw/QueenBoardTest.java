package nqcw;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class QueenBoardTest extends Assertions {
  @Test
  public void testFormatter() {
    String result = QueenBoard.STANDARD_EMPTY.toString();
    // Make sure it is the right length
    assertThat(result.length()).isEqualTo((8 + 1) * 8);

    assertThat(result).doesNotContain("Q");


    QueenBoard.STANDARD_EMPTY
  }
}
