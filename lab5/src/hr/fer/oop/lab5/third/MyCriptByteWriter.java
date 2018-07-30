/**
 * 
 */
package hr.fer.oop.lab5.third;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import hr.fer.oop.lab5.first.MyByteWriter;

/**
 * @author Filip
 *
 */
public class MyCriptByteWriter extends MyByteWriter {

	/**
	 * Constructor using:
	 * @param stream
	 * @param filePath
	 */
	public MyCriptByteWriter(InputStream stream, Path filePath) {
		super(stream, filePath);

	}


	@Override
	public void run() throws IOException {
		BufferedInputStream inputStream=new BufferedInputStream(super.getStream());
		
		while(true){
			byte[] buffer= new byte[4096];
			int temp=inputStream.read(buffer);
			if(temp<1) break;

			try(OutputStream out=new MaskStream(Files.newOutputStream(super.getFilePath(),StandardOpenOption.WRITE), (byte)1)){

				out.write(buffer, 0 ,temp);

			}catch(IOException ex){
				System.err.println(ex);
			}

			


		}
		inputStream.close();
	}



}
