/**
 * 
 */
package hr.fer.oop.lab5.third;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;

/**
 * @author Filip
 *
 */
public class Test {
	
	@org.junit.Test
	public void testSize() throws IOException{
		long size1=Files.size(Paths.get("D:/Users/Filip/hr/fer/oop/lab5/sifrat.txt"));
		long size2=Files.size(Paths.get("D:/Users/Filip/hr/fer/oop/lab5/desifrirana.txt"));
		
		Assert.assertEquals(size1, size2);
	}
	
	@org.junit.Test
	public void testAllLines() throws IOException{
		Assert.assertEquals(Files.readAllLines(Paths.get("D:/Users/Filip/hr/fer/oop/lab5/sifrat.txt")), Files.readAllLines(Paths.get("D:/Users/Filip/hr/fer/oop/lab5/desifrirana.txt")));
	}
}
