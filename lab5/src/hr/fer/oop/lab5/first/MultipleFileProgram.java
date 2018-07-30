/**
 * 
 */
package hr.fer.oop.lab5.first;


import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Filip
 *
 */
public class MultipleFileProgram {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path p=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/final.txt");
		Path p1=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/racuni");
		if(!Files.exists(p)){
			Files.createFile(p);
		}
		try(OutputStream stream=Files.newOutputStream(p, StandardOpenOption.WRITE)){
			MyByteReader reader=new MyByteReader(stream);
			Files.walkFileTree(p1, reader);
		}
		catch(IOException ex){
			System.err.println("Nemogu otvorit datoteku!");
		}
		
		

	}

}
