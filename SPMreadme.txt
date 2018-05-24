Description: This assisgnment is to output the shortest path from char s to f. The spaces represent open spots while '*' represents
the walls.

Contribution: Solver.JAVA, and testFunctions.JAVA

My solution: I decided to make a 2d array of integers that has the same dimension of the char grid. From here, I used the Graph class
to connect and place an edge to all the characters, in this case integers, that are not a '*'. After connecting each integer, I utilized
the BreadthFirstPath class to find the shortest path. Using this spits out integers of the shortest path from s to f. From here, I needed
to translate these integers to either U,D,R, or L. 
Up = if + grid.length from current iteration
Down = if + grid.length from current iteration
right = f + 1 from current iteration
Left = if - 1 from current iteration
The return value is a string concatenation of each movement

Example:
			
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

Expected output: DRRRDDDDDDDDRRRRRR