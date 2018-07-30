/**
 * 
 */
package hr.fer.oop.lab6.second;

/**
 * @author Filip
 *
 */
public class Cell {
	
	private int x,y;
	
	private int deadNo;
	private int aliveNo;
	
	private boolean alive;
	
	/**
	 * Constructor using: x,y.
	 * Constructs new cell.
	 */
	public Cell(int x, int y) {
		this.x=x;
		this.y=y;
		alive=false;
		deadNo=0;
		aliveNo=0;
	}

	/**
	 * Getter
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Setter
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Getter
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Getter
	 * @return the deadNo
	 */
	public int getDeadNo() {
		return deadNo;
	}

	/**
	 * Setter
	 * @param deadNo the deadNo to set
	 */
	public void setDeadNo(int deadNo) {
		this.deadNo = deadNo;
	}

	/**
	 * Getter
	 * @return the aliveNo
	 */
	public int getAliveNo() {
		return aliveNo;
	}

	/**
	 * Setter
	 * @param aliveNo the aliveNo to set
	 */
	public void setAliveNo(int aliveNo) {
		this.aliveNo = aliveNo;
	}
	


}
