/**
 * 
 */
package hr.fer.oop.lab5.third;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Filip
 *
 */
public class MaskStream extends OutputStream {
	private byte key;
	private OutputStream stream;
	
	/**
	 * Constructor using:
	 */
	public MaskStream(OutputStream stream, byte key) {
		super();
		this.key=key;
		this.stream=stream;
	}

	
	@Override
	public void write(int x) throws IOException {
		stream.write(((byte)x)^key);

	}

}
