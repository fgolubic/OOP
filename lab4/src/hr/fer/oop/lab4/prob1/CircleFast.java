/**
 * 
 */
package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * @author Filip
 *
 */
public class CircleFast extends Circle {

	/**
	 * Constructor
	 * @param radius
	 * @param x
	 * @param y
	 */
	public CircleFast(int radius, int x, int y) {
		super(radius, x, y);

	}

	@Override
	/**
	 * Draws circle on picture drawing line by line.
	 * @param picture
	 */
	public void drawOnPicture(Picture picture) {
		int xCoordinate;
		int x1=this.getX();
		int left, right, up , down;

		for(int i=0;i<radius;i++){
			xCoordinate=(int)Math.sqrt(radius*radius-i*i);
			left=x1-xCoordinate;
			right=x1+xCoordinate;
			up=this.getY()-i;
			down=this.getY()+i;
			
			if(down<picture.getHeight()){
				
				if(left<0){
					left=0;

				}
				if(right>=picture.getWidth()){
					right=picture.getWidth()-1;
				}

				picture.drawLine(left, right, this.getY()+i);

			}
			
			if(up>=0){

				if(left<0){
					left=0;

				}
				if(right>=picture.getWidth()){
					right=picture.getWidth()-1;
				}
				picture.drawLine(left, right, this.getY()-i);
			}
			
			
		}

	}

	/**
	 * Constructor
	 * @param circle
	 */
	public CircleFast(Circle circle) {
		super(circle);
	}

}
