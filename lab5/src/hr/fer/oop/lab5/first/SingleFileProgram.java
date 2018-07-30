/**
 * 
 */
package hr.fer.oop.lab5.first;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Filip
 *
 */
public class SingleFileProgram {


	public static void main(String[] args) throws IOException {
		Path p=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/racuni/racuni3/2015/1/Racun_1.txt");
		Path out=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/singleout.txt");
		
		Files.deleteIfExists(out);
		Files.createFile(out);
		
		try(InputStream stream=Files.newInputStream(p, StandardOpenOption.READ)){
			MyByteWriter writer=new MyByteWriter(stream, out);
			writer.run();
		}catch(IOException ex){
			System.err.println("Ne mogu otvorit datoteku!");
		}

	}

}
