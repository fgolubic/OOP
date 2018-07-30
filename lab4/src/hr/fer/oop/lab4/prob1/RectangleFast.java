/**
 * 
 */
package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * @author Filip
 *
 */
public class RectangleFast extends Rectangle {

	/**
	 * Constructor
	 * @param rectangle
	 */
	public RectangleFast(Rectangle rectangle) {
		super(rectangle);
		
	}

	
	@Override
	/**
	 * Draws rectangle on picture by drawing a line by line.
	 * @param picture
	 */
	public void drawOnPicture(Picture picture) {
		int x1=this.getX();
		int xLength=x1+getWidth();
		int xHeight=this.getY()+this.getHeight();
		
		if(xHeight>=picture.getHeight()){
			xHeight=picture.getHeight()-1;
		}
		
		for(int i=this.getY();i<xHeight;i++){
			if(xLength>=picture.getWidth()){
				xLength=picture.getWidth()-1;
			}
			picture.drawLine(x1, xLength, i);
		}
	}

	/**
	 * Constructor
	 * @param width
	 * @param hight
	 * @param x
	 * @param y
	 */
	public RectangleFast(int width, int hight, int x, int y) {
		super(width, hight, x, y);
		// TODO Auto-generated constructor stub
	}

}
