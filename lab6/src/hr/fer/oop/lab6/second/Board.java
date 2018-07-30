/**
 * 
 */
package hr.fer.oop.lab6.second;

import java.util.LinkedList;

/**
 * @author Filip
 *
 */
public class Board {
	private static boolean first;
	private int width;
	private int height;
	private Cell[][]  board;
	private LinkedList<BoardListener> slusaci=new LinkedList<>();
	private LinkedList<Cell> changed=new LinkedList<>();

	/**
	 * Constructor using: width, height
	 * initializes whole 2D array of Cells
	 */
	public Board(int width, int height) {
		this.height=height;
		this.width=width;
		this.board=new Cell[width][height];
		for(int i=0;i<this.width;i++){
			for(int j=0;j<this.height;j++){
				board[i][j]=new Cell(i,j);
			}
		}
	}
	
	/**
	 * Checks if cell is alive
	 * @param x
	 * @param y
	 * @return true/false
	 */
	public boolean isCellAlive(int x, int y){
		return board[x][y].isAlive();  
	}

	
	/**
	 * Sets DOA status for cell
	 * @param x
	 * @param y
	 * @param alive
	 */
	public void setCell(int x, int y, boolean alive){
		board[x][y].setAlive(alive);;
	}

	/**
	 * Getter
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Getter
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Getter
	 * @return the board
	 */
	public Cell[][] getBoard() {
		return board;
	}

	/**
	 * Counts all currently alive neighbors of the cell
	 * @param x
	 * @param y
	 * @return
	 */
	public  int countAliveNeighbors(int x, int y){
		int count=0,i,j;

		for(i=x-1; i<=x+1;i++){
			if(i<0) i =0;
			for( j=y-1;j<=y+1;j++){
				if(j<0) j=0;
				if(i>=width || j>=height){
					if(isCellAlive(x, y)) count--;
					return count;
				}
				if(isCellAlive(i, j)) count++;
			}
		}
		if(isCellAlive(x, y)) count--;
		return count;
	}

	/**
	 * Plays one iteration: calculates dead and alive cells, 
	 * changes the state of the board and notifies all listeners
	 */
	public void playOneIteration(){
		int aliveNo;
		
		
		if(changed.isEmpty()) first=true;
		changed.clear();
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				 aliveNo=countAliveNeighbors(i, j);
				if(board[i][j].isAlive()){
					if(aliveNo!=2 && aliveNo!=3){
						changed.add(board[i][j]);
						
						
					}
				}
				else{
					if(aliveNo==3){
						changed.add(board[i][j]);
						
						
						
					}
				}
			}

		}
		
		for(Cell temp:changed){
			if(temp.isAlive()){
				temp.setAlive(false);

			}
			else{
				temp.setAlive(true);

			}
		}
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				if(board[i][j].isAlive()){
					if(first && !changed.contains(board[i][j])){
					board[i][j].setAliveNo(board[i][j].getAliveNo()+1);
					}
					else if(changed.contains(board[i][j])){
						board[i][j].setAliveNo(board[i][j].getAliveNo()+1);
					}
				}
				else {
					if(changed.contains(board[i][j])){
						board[i][j].setDeadNo(board[i][j].getDeadNo()+1);
					}
				}
			}
		}
		first=false;
		this.broadcast();
		
		
	}
	
	/**
	 * Notifies all listeners.
	 */
	public void broadcast(){
		slusaci.forEach((t)->t.boardChanged(this));
	}
	

	/**
	 * Adds board listener to listener list
	 * @param listener
	 */
	public void addListener(BoardListener listener){
		slusaci.add(listener);
	}
	
	
	/**
	 * Removes board listener
	 * @param listener
	 */
	public void removeListener(BoardListener listener){
		slusaci.remove(listener);
	}

	/**
	 * Getter
	 * @return the slusaci
	 */
	public LinkedList<BoardListener> getSlusaci() {
		return slusaci;
	}

	/**
	 * Getter
	 * @return the changed
	 */
	public LinkedList<Cell> getChanged() {
		return changed;
	}

	public void clear(){
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				board[i][j].setAliveNo(0);
				board[i][j].setDeadNo(0);
			}
		}
		changed.clear();
	}
}
