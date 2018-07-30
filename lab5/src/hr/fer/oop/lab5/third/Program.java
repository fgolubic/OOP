/**
 * 
 */
package hr.fer.oop.lab5.third;

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
public class Program {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Path sifrirana=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/sifrirana.txt");
		Path sifrat=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/sifrat.txt");
		Path desifrirana=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/desifrirana.txt");
		
		Files.deleteIfExists(sifrirana);
		Files.deleteIfExists(desifrirana);
		
		Files.createFile(sifrirana);
		Files.createFile(desifrirana);
		
		try(InputStream in=Files.newInputStream(sifrat,StandardOpenOption.READ)){
			MyCriptByteWriter cript=new MyCriptByteWriter(in, sifrirana);
			cript.run();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		try(InputStream in=Files.newInputStream(sifrirana, StandardOpenOption.READ)){
			MyCriptByteWriter cript=new MyCriptByteWriter(in, desifrirana);
			cript.run();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}

}
