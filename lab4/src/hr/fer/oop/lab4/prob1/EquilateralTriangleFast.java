/**
 * 
 */
package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * @author Filip
 *
 */
public class EquilateralTriangleFast extends EquilateralTriangle {


	@Override
	/**
	 * Draws triangle on picture by drawing line by line.
	 * @param picture
	 */
	public void drawOnPicture(Picture picture) {
		int dHeight=(int)(side*Math.sqrt(3)/2);
		int dWidth;
		int x1=this.getX();
		int yHeight=this.getY()+dHeight;
		int left;
		int right;
		
		if(yHeight>=picture.getHeight()){
			yHeight=picture.getHeight()-1;
		}
		
		for(int i=this.getY(); i<=yHeight;i++){
			dWidth=(int)((i-this.getY())*Math.sqrt(3)/3);
			left=x1-dWidth;
			right=x1+dWidth;
				if(left<0){
					left=0;
				}
				if(right>=picture.getWidth()){
					right=picture.getWidth()-1;
				}
				picture.drawLine(left, right, i);
		}
			
			
	}


	/**
	 * Constructor
	 * @param side
	 * @param x
	 * @param y
	 */
	public EquilateralTriangleFast(int side, int x, int y) {
		super(side, x, y);
		
	}

	/**
	 * Constructor
	 * @param triangle
	 */
	public EquilateralTriangleFast(EquilateralTriangle triangle) {
		super(triangle);
	
	}

}
