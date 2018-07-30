/**
 * 
 */
package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;
import hr.fer.oop.lab4.pic.PictureDisplay;

/**
 * @author Filip
 *
 */
public class Demonstration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Picture picture= new Picture(500,500);
		Rectangle rectangleFast= new RectangleFast(100,20,50,100);
		Rectangle rectangleFast1= new RectangleFast(20,200,130,120);
		Rectangle rectangle= new Rectangle(100,20,130,320);
		Circle circleFast= new CircleFast(60,90, 280);
		Circle circle = new Circle(40,90,240);
		EquilateralTriangle triangle =new EquilateralTriangleFast(300, 400, 200);
		EquilateralTriangle triangle2= new EquilateralTriangle(100, 400, 20);
		



		rectangleFast.drawOnPicture(picture);
		rectangleFast1.drawOnPicture(picture);
		rectangle.drawOnPicture(picture);
		circleFast.drawOnPicture(picture);
		circle.erasePicture(picture);
		triangle.drawOnPicture(picture);
		triangle2.drawOnPicture(picture);
		picture.renderImageToStream(System.out);
		PictureDisplay.showPicture(picture);
		

	}

}
