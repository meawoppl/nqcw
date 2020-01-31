/**
 * This is a package contains a set of solutions to the CompilerWorks interview question:
 *
 * <blockquote>
 *
 * Place N queens on an NxN chess board so that none of them attack each other (the classic n-queens
 * problem).
 *
 * <p>Additionally, please make sure that no three queens are in a straight line at ANY angle, so
 * queens on A1, C2 and E3, despite not attacking each other, form a straight line at some angle.
 *
 * </blockquote>
 *
 * <h2>Process Ramble</h2>
 *
 * I decided to get the traditional N-Queens problem right before adding the additional constraints.
 *
 * <p>I first wrote a class to model board state {@code Board}. I opted for a sparse matrix like
 * representation of board state as the later colinearity restriction suggested to me that there
 * might be some cleverness in linear-algebra I can do later on.
 *
 * <p>I then wrote {@code TraditionalSolver} to embody the N-Queens rules, as well as the
 * backtracking recursive descent loop. Using the wikipedia page which enumerates the answer count
 * for various board sizes makes up the test case which seems to check out ok.
 *
 * <p>From there, I spent a bit of time making the descent algorithm maximally intuitive, and moved
 * a fair bit of utility methods onto the {@code Board} class (finding empty rows/columns etc)
 *
 * <p>Satisfied with that I moved to the more restrictive problem, which first necessitated
 * abstracting the descent algorithm into a parent {@code QueensSolver}, then implementing the
 * colinearity restriction.
 *
 */
package nqcw;
