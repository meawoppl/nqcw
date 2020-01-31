package nqcw;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BoardTest extends Assertions {

  public static Board KNOWN_4X4_SOLUTION =
      Board.ofSize(4).adding(0, 2).adding(1, 0).adding(2, 3).adding(3, 1);

  @Test
  public void testFormatter() {
    for (int i = 3; i < 12; i++) {
      String result = Board.ofSize(i).toString();
      // Make sure it is the right length (8 cols + newline) * 8 rows
      assertThat(result.length()).isEqualTo((i + 1) * i);

      assertThat(result).doesNotContain("Q");
      assertThat(result).contains("█ █");
    }

    assertThat(Board.STANDARD_EMPTY.adding(1, 1).toString()).contains("█Q█");
  }

  @Test
  public void testUnoccupied() {
    assertThat(Board.STANDARD_EMPTY.unoccupiedCols()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7);
    assertThat(Board.STANDARD_EMPTY.unoccupiedRows()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7);

    assertThat(Board.STANDARD_EMPTY.adding(2, 3).unoccupiedRows())
        .containsExactly(0, 1, 3, 4, 5, 6, 7);
    assertThat(Board.STANDARD_EMPTY.adding(2, 3).unoccupiedCols())
        .containsExactly(0, 1, 2, 4, 5, 6, 7);

    assertThat(KNOWN_4X4_SOLUTION.unoccupiedCols()).isEmpty();
    assertThat(KNOWN_4X4_SOLUTION.unoccupiedRows()).isEmpty();
  }
}
