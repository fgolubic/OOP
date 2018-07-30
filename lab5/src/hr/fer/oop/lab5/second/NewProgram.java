/**
 * 
 */
package hr.fer.oop.lab5.second;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * @author Filip
 *
 */
public class NewProgram {
	
	
	
	public static void main(String[] args) throws IOException {
				Path p1=Paths.get("D:\\Users\\Filip\\hr\\fer\\oop\\lab5\\racuni");
				
				MySecondByteReader reader= new MySecondByteReader();
				
				Files.walkFileTree(p1, reader);
				
				List<Artikl> map= MySecondByteReader.getMostSold();
				
				Comparator<Artikl> cmp= (a1,a2)->{
					if(a1.getProdanoKomada()==0){
						return -1;
					}
					if(a2.getProdanoKomada()==0){
						return 1;
					}
					 return a2.getProdanoKomada().compareTo(a1.getProdanoKomada());
				};
				
				Collections.sort( map,cmp);
				
				for(int i=0;i<10;i++){
					System.out.println(map.get(i).toString());
				}
				
		
		
	}
}
