Maze Solver:
	Depth-first Search
	Maze was a 2D-array, ' ' was a wall, '#' was the path, 'z' self, '$' exit, '.' visited
	Solved with recursion; previous locations stored on the call stack

Breadth-first Search

Given a maze:
	  #	  B	
	  #	  C
	######	DEAFGH
	  #	  I
	  ###	  JKL

Letters represent x,y coordinates;
A is the starting point
"frontier": a way to store data that is to be explored next

I. Place the start node on the frontier (enqueue the node)
	A is on the 'frontier'
II. mark the frontier
	A is on 'current'
III. expand
	[C,E,F,I] are on the frontier
	C is at the front of the list
IV. repeat 
	A is no longer current, C is current
	B is on the frontier
	B is after I on the frontier
	go down the list of frontiers
	frontier = [E,F,I,B]

***the frontier is a queue

Note: 	if the frontier is a Queue: we have breadth-first search
	if the frontier is a Stack: we have depth-first search

Queue frontier = new Queue();
while (!q.empty()){
	I. current = remove first node from the frontier (dequeue)
	current = frontier.dequeue();
	if (board[current.getX(),current.getY()] == 'exit') {
		System.exit(0);
	}
	II. mark current as visited
	III. for each unprocessed neighbor N of current (enqueue)
		mark neighbor = processed //processed = add to the frontier
		add N to the frontier
		q.enqueue(N);
}

classes:
frontier -- add, remove
node -- x, y
