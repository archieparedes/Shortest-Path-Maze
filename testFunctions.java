package shortestPathMaze;

import static org.junit.Assert.*;

import org.junit.Test;

public class testFunctions {
	
	private void checkSol(char[][] grid, String path, int distance) {
		int size = grid.length;
		int row = -1;
		int col = -1;
		
		// Start at s;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if (grid[i][j] == 's') {
					row = i;
					col = j;
				}
			}
		}
		
		// Move according to path
		for(char c : path.toCharArray()) {
			switch(c) {
			case 'U':
				row -= 1;
				break;
			case 'D':
				row += 1;
				break;
			case 'R':
				col += 1;
				break;
			case 'L':
				col -= 1;
				break;
			default:
				fail("Illegal character in solution: " + c);
			}
			// Make sure you haven't moved outside the grid.
			assertTrue(row >= 0 && row < size && col >= 0 && col < size);
			// Make sure you haven't moved into a '*'
			assertTrue(grid[row][col] != '*');
		}
		// Make sure you end at 'f'
		assertTrue(grid[row][col] == 'f');
		
		// Make sure it is not longer than shortest distance.
		assertTrue(path.length() <= distance);
	}

	@Test
	public void toyTest() {
		System.out.print("TEST 1");
		String[] data = 
			{
					"s         ",
					"          ",
					"  *       ",
					"  *  *****",
					"  *       ",
					"  *       ",
					"  *       ",
					"  *       ",
					"  *       ",
					"  *      f"
			};
		char[][] grid;
		// regular version
		grid = GridUtilities.fromStringArray(data);
		String solution = Solver.solve(grid);
		checkSol(grid, solution, 18);
		
		//  version
		grid = GridUtilities.rotateClockwise(grid);
		solution = Solver.solve(grid);
		checkSol(grid, solution, 18);
		System.out.println(" completed.");
	}
	
	@Test
	public void noPathTest() {
		// 5x5 not working
		System.out.print("TEST 2");
		String[] data = 
			{
					"    *",
					"  s**",
					"  ***",
					"*****",
					"    f"
			};
		char[][] grid;
		// regular version
		grid = GridUtilities.fromStringArray(data);
		String solution = Solver.solve(grid);
		assertNull(solution);
		
		// rotated version
		grid = GridUtilities.rotateClockwise(grid);
		solution = Solver.solve(grid);
		assertNull(solution);
		System.out.println(" completed.");
	}
	
	@Test
	public void testUp() {
		System.out.print("TEST 3");
		String[] data = 
			{
					"s         ",
					"          ",
					"  *       ",
					"  ********",
					"  *       ",
					"  *       ",
					"  *       ",
					"  * *     ",
					"    *     ",
					"  **     f"
			};
		char[][] grid;
		// regular version
		grid = GridUtilities.fromStringArray(data);
		String solution = Solver.solve(grid);
		checkSol(grid, solution, 22);
		
		// rotated version
		grid = GridUtilities.rotateClockwise(grid);
		solution = Solver.solve(grid);
		checkSol(grid, solution, 22);
		System.out.println(" completed.");
	}
	@Test
	public void holeEntrance() {
		System.out.print("TEST 4");
		String[] data = 
			{
					"s         ",
					"          ",
					"  *       ",
					"  ********",
					"  *       ",
					"  *   *   ",
					"  * f *   ",
					"  *****   ",
					"          ",
					"  **      "
			};
		char[][] grid;
		// regular version
		grid = GridUtilities.fromStringArray(data);
		String solution = Solver.solve(grid);
		checkSol(grid, solution, 24);
		
		// rotated version
		grid = GridUtilities.rotateClockwise(grid);
		solution = Solver.solve(grid);
		checkSol(grid, solution, 24);
		System.out.println(" completed.");
	}
	@Test
	public void shortMove() {
		System.out.print("TEST 5");
		String[] data = 
			{
					"s f       ",
					"          ",
					"  *       ",
					"  ********",
					"  *       ",
					"  *   *   ",
					"  *   *   ",
					"  *****   ",
					"          ",
					"  **      "
			};
		char[][] grid;
		// regular version
		grid = GridUtilities.fromStringArray(data);
		String solution = Solver.solve(grid);
		checkSol(grid, solution, 2);
		
		// rotated version
		grid = GridUtilities.rotateClockwise(grid);
		solution = Solver.solve(grid);
		checkSol(grid, solution, 2);
		System.out.println(" completed.");
	}
	@Test
	public void smallGrid() {
		System.out.print("TEST 6");
		String[] data = 
			{
					"s ",
					" f"
			};
		char[][] grid;
		// regular version
		grid = GridUtilities.fromStringArray(data);
		String solution = Solver.solve(grid);
		checkSol(grid, solution, 2);
		
		// rotated version
		grid = GridUtilities.rotateClockwise(grid);
		solution = Solver.solve(grid);
		checkSol(grid, solution, 2);
		System.out.println(" completed.");
	}
	@Test
	public void oneDirection() {
		System.out.print("TEST 7");
		String[] data = 
			{
					"s        f",
					"          ",
					"  *       ",
					"  ********",
					"  *       ",
					"  *   *   ",
					"  *   *   ",
					"  *****   ",
					"          ",
					"  **      "
			};
		char[][] grid;
		// regular version
		grid = GridUtilities.fromStringArray(data);
		String solution = Solver.solve(grid);
		checkSol(grid, solution, 9);
		assertEquals("RRRRRRRRR", solution);
		
		// rotated version
		grid = GridUtilities.rotateClockwise(grid);
		solution = Solver.solve(grid);
		checkSol(grid, solution, 9);
		assertEquals("DDDDDDDDD", solution);
		System.out.println(" completed.");
	}
}
