package shortestPathMaze;

import hw4.LinearProbingHashST;
import hw4.MyString;

public class Solver {
	public static int positionS;
	public static int positionF;
	
	public Solver() {
		positionS = 0;
		positionF = 0;
	}
	
	public static String solve(char[][] grid) {
		int i, j, k = 0, size = grid.length * grid.length, track = 0;
		int[][] gridInt = new int[grid.length][grid.length]; // integer version of grid
		String dir = ""; // return
		Graph graph = new Graph(size);
		
		// makes grid of increasing integer that's the same size as char[][] grid
		for(i = 0; i < grid.length; i++) {
			for(j = 0; j < grid.length; j++) {
				gridInt[i][j] = k;
				k++;
			}
		}
		
		// add edges horizontally, and connects the integers
		for(i = 0; i < grid.length; i++) {
			for(j = 0; j < grid.length; j++) {
				if(grid[i][j] == 's') {
					positionS = gridInt[i][j];
				}
				if(grid[i][j] == 'f') {
					positionF = gridInt[i][j];
				}
				if(grid[i][j] != '*') {
					if(j+1 < grid.length && grid[i][j+1] != '*') {
						graph.addEdge(gridInt[i][j], gridInt[i][j+1]);
					}
				}
			}
		}	
		
		// adds edge vertically, and connects the integers
		for(i = 0; i < grid.length; i++) {
			for(j = 0; j < grid.length; j++) {
				if(grid[j][i] != '*') {
					if(j+1 < grid.length && grid[j+1][i] != '*') {
						graph.addEdge(gridInt[j][i], gridInt[j+1][i]);
					}
				}
			}
		}
		
		BreadthFirstPaths bfs = new BreadthFirstPaths(graph, positionS);
		// returns null if there is no path
		if(!bfs.hasPathTo(positionF)) {
			return null;
		}
		
		// replaces each integer path with direction
		/*
		 * U = up
		 * D = down
		 * R = right
		 * L = left
		 * */
		for(int n : bfs.pathTo(positionF)) {
			if(n == positionS) { // sets tracker
				track = n;
			}
			if(n != positionS) {
				if(n == track + grid.length)	dir += "D";
				if(n == track - grid.length)		dir += "U";
				if(n == track + 1) 					dir += "R";
				if(n == track - 1)  					dir += "L";
				track = n; // new tracker
			}	
		}
		//System.out.println(dir); // uncomment to see results
		return dir;
	}
}
