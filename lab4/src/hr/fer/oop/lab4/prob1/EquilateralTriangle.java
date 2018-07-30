/**
 * 
 */
package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * @author Filip
 *
 */
public class EquilateralTriangle {
	int side, x,y;



	/**
	 * Draws triangle on picture by turning one by one pixel on.
	 * @param picture
	 */
	public void drawOnPicture(Picture picture){
		int dHeight=(int)(side*Math.sqrt(3)/2);
		int dWidth;
		
		for(int i=this.getY(); i<=this.getY()+dHeight;i++){
			dWidth=(int)((i-this.getY())*Math.sqrt(3)/3);
			for(int j=this.getX()-dWidth;j<=this.getX()+dWidth;j++){
				try{
						picture.turnPixelOn(j, i);
					
				}
				catch( java.lang.IllegalArgumentException ex){
					continue;
				}
			}
		}
	}
	/**
	 * Erases triangle by turning pixel by pixel off.
	 * @param picture
	 */
	public void erasePicture(Picture picture){
		int dHeight=(int)(side*Math.sqrt(3)/2);
		int dWidth;
		
		for(int i=this.getY(); i<=this.getY()+dHeight;i++){
			dWidth=(int)((i-this.getY())*Math.sqrt(3)/3);
			for(int j=this.getX()-dWidth;j<=this.getX()+dWidth;j++){
				try{
						picture.turnPixelOff(j, i);
					
				}
				catch( java.lang.IllegalArgumentException ex){
					continue;
				}
			}
		}
	}

	/**
	 * Getter
	 * @return the side
	 */
	public int getSide() {
		return side;
	}
	/**
	 * Setter
	 * @param side the side to set
	 */
	public void setSide(int side) {
		this.side = side;
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
	 * @param side
	 * @param x
	 * @param y
	 */
	public EquilateralTriangle(int side, int x, int y) {
		super();
		this.side = side;
		this.x = x;
		this.y = y;
	}
	/**
	 * Constructor
	 * @param triangle
	 */
	public EquilateralTriangle(EquilateralTriangle triangle) {
		super();
		this.side = triangle.side;
		this.x = triangle.x;
		this.y = triangle.y;
	}

}
