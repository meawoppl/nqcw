package nqcw;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PositionTest extends Assertions {

  @Test
  public void testComparisons() {
    List<Position> unsorted =
        Lists.newArrayList(
            Position.at(1, 0), Position.at(1, 1), Position.at(0, 1), Position.at(0, 0));

    List<Position> sorted =
        unsorted.stream().sorted(Position::compareTo).collect(Collectors.toList());

    assertThat(sorted)
        .containsExactly(
            Position.at(0, 0), Position.at(0, 1), Position.at(1, 0), Position.at(1, 1));
  }
}
