/**
 * 
 */
package hr.fer.oop.lab5.first;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * @author Filip
 *
 */
public class MyByteWriter {
	private InputStream stream;
	private Path filePath;

	public MyByteWriter(InputStream stream, Path filePath){
		this.stream=stream;
		this.filePath=filePath;
	}

	public void run() throws IOException{
		BufferedInputStream inputStream=new BufferedInputStream(stream);
		byte[] buffer= new byte[2048];
		
		while(true){
			
			int temp=inputStream.read(buffer);
			if(temp<1) break;

			try(OutputStream out=Files.newOutputStream(filePath,StandardOpenOption.WRITE)){
				for(int i=0;i<temp;i++){
					out.write(buffer[i]);
				}
			}catch(IOException ex){
				System.err.println(ex);
			}

		}
		inputStream.close();
	}

	/**
	 * Getter
	 * @return the stream
	 */
	public InputStream getStream() {
		return stream;
	}

	/**
	 * Getter
	 * @return the filePath
	 */
	public Path getFilePath() {
		return filePath;
	}
}
