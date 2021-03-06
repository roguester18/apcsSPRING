import java.io.*;
import java.util.*;

public class Maze {
    private char[][] board;
    private int maxX;
    private int maxY;
    private char wall = ' ';
    private char exit='$';
    private char path='#';
    private char me = 'L';
    private char visited='.';
    private boolean solved=false;

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
    public Maze() {
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
	
	try {
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext())
		{
		    String line = sc.nextLine();
		    for (int i=0;i<maxX;i++)
			{
			    board[i][j] = line.charAt(i);
			}
		    j++;
		}
	}
	catch (Exception e)
	    {
	    }
	
    }
	
    public String toString(){
	String s = "[2J\n";
	for (int y=0;y<maxY;y++)
	    {
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	
	return s;
    }
    
    
    public void solve(int x, int y){
	if (board[x][y]==exit){
	    System.out.println(this);
	    solved=true;
	}
	if (board[x][y] != path)
	    return;
	delay(100);
	System.out.println(this);
	board[x][y]=me;
	solve(x+1,y);
	solve(x-1,y);
	solve(x,y+1);
	solve(x,y-1);
	board[x][y]=path;
	if (!solved){
	    board[x][y]=visited;
	}
    }
    
    public void bfs(int x, int y){
	Frontier f=new Frontier();
	
	//add initial Node to the frontier
	f.add(new Node(x,y));
	
	board[x][y]='x';
	Node current =null;
       
	while(!f.isEmpty()){
	    current =f.remove();
	    int cx = current.getX();
	    int cy = current.getY();
	    
	    board[cx][cy] = 'z';
	    Node tmp;
	    
	    int tx = cx +1;
	    int ty = cy;
	    if (board[tx][ty]=='#'|| board[tx][ty]=='$'){
		tmp = new Node (tx,ty);
		f.add(tmp);
	    }
	    tx = cx;
	    ty = cy-1;
	    if (board[tx][ty]=='#'|| board[tx][ty]=='$'){
		tmp = new Node (tx,ty);
		f.add(tmp);
	    }

	    delay(50);
	    System.out.println(this);
	    
	}
    }

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
        m.solve(1,1);
	
    }
    
}

