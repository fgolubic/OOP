package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

public class Rectangle {

	private int width, height;
	private int x,y;

	/**
	 * Draws rectangle on picture by turning one by one pixel on.
	 * @param picture
	 */
	public void drawOnPicture(Picture picture){
		int pictureHeight=(this.height+this.getY());
		int pictureWidth=(this.width+this.getX());
		
		for(int i=this.getY(); i<=pictureHeight;i++){
			for(int j=this.getX();j<=pictureWidth;j++){
				try{
					picture.turnPixelOn(j, i);
				}
				catch(java.lang.IllegalArgumentException ex){
					continue;
				}
			}
		}
	}
	
	/**
	 * Erases rectangle by turning pixel by pixel off.
	 * @param picture
	 */
	public void erasePicture(Picture picture){
		int pictureHeight=(this.height+this.getY());
		int pictureWidth=(this.width+this.getX());
		
		for(int i=this.getY(); i<=pictureHeight;i++){
			for(int j=this.getX();j<=pictureWidth;j++){
				try{
					picture.turnPixelOff(j, i);
				}
				catch(java.lang.IllegalArgumentException ex){
					continue;
				}
			}
		}
	}

	

	/**
	 * Getter
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Setter
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Getter
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Setter
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
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
	 * Constructor
	 * @param rectangle
	 */
	public Rectangle( Rectangle rectangle) {
		super();
		this.width=rectangle.width;
		this.height=rectangle.height;
		this.x=rectangle.x;
		this.y=rectangle.y;
	}

	/**
	 * Constructor
	 * @param width
	 * @param hight
	 * @param x
	 * @param y
	 */
	public Rectangle(int width, int hight, int x, int y) {
		super();
		this.width = width;
		this.height = hight;
		this.x = x;
		this.y = y;
	}

}
