/**
 * 
 */
package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * @author Filip
 *
 */
public class Circle {
	int radius, x,y;

	/**
	 * Draws circle on picture by turning one by one pixel on.
	 * @param picture
	 */
	public void drawOnPicture(Picture picture){

		for(int i=this.getY(); i<=this.getY()+2*radius;i++){
			for(int j=this.getX()-radius;j<=this.getX()+radius;j++){
				if(Math.pow(i-this.getY()-radius, 2)+Math.pow(j-this.getX(),2)<=radius*radius){
					try{
						picture.turnPixelOn(j, i);
					}
					catch(java.lang.IllegalArgumentException ex){
						continue;
					}
				}
			}
		}
	}
	
	/**
	 * Erases circle by turning pixel by pixel off.
	 * @param picture
	 */
	public void erasePicture(Picture picture){
		for(int i=this.getY(); i<=this.getY()+2*radius;i++){
			for(int j=this.getX()-radius;j<=this.getX()+radius;j++){
				if(Math.pow(i-this.getY()-radius, 2)+Math.pow(j-this.getX(),2)<=radius*radius){
					try{
						picture.turnPixelOff(j, i);
					}
					catch(java.lang.IllegalArgumentException ex){
						continue;
					}
				}
			}
		}
	}

	/**
	 * Getter
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Setter
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
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
	 * @param radius
	 * @param x
	 * @param y
	 */
	public Circle(int radius, int x, int y) {
		super();
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	/**
	 * Constructor
	 * @param circle
	 */
	public Circle(Circle circle){
		super();
		this.radius = circle.radius;
		this.x = circle.x;
		this.y=circle.y;
	}

}
