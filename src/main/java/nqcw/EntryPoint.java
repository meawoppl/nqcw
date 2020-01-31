package nqcw;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;

public class EntryPoint {
  public static void main(String[] args) {
    List<String> argList = Lists.newArrayList(args);

    QueensSolver solver;

    if(argList.contains("-t")){
      argList.remove("-t");
      solver = new TraditionalSolver();
      System.out.println("Solving traditional N-Queens problem");
    } else {
      solver = new ColinearSolver();
      System.out.println("Solving N-Queens problem with colinearity restriction");
    }

    int boardSize = 8;
    if(argList.size() == 1) {
      boardSize = Integer.parseInt(argList.get(0));
    }

    Set<Board> solutions = solver.allSolutionsForBoardOfSize(boardSize);
    solutions.forEach(System.out::println);

    System.out.println(String.format("%d solutions found for board of size %d", solutions.size(), boardSize));
  }
}
