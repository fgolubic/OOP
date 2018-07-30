package hr.fer.oop.lab5.second;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author Filip
 *
 */
public class MySecondByteReader implements FileVisitor<Path> {

	private Collection<Artikl> collection;
	private static List<Artikl> mostSold= new ArrayList<>();
	/**
	 * Constructor
	 */
	public MySecondByteReader() {

		collection=new HashSet<>();
	}


	/**
	 * Getter
	 * @return the collection
	 */
	public Collection<Artikl> getCollection() {
		return collection;
	}

	/**
	 * Do nothing in directory.
	 */
	@Override
	public FileVisitResult postVisitDirectory(Path arg0, IOException arg1) throws IOException {

		return FileVisitResult.CONTINUE;
	}

	/**
	 * Do nothing in directory.
	 */
	@Override
	public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {

		return FileVisitResult.CONTINUE;
	}

	/**
	 * When walking the file tree visits the file it separates price and name of the product and puts it in set as
	 * an instance of Article containing name and price.
	 */
	@Override
	public FileVisitResult visitFile(Path arg0, BasicFileAttributes arg1) throws IOException {
		String line;
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(arg0.toString())))){
			while((line=reader.readLine())!=null){
				if(line.contains("UKUPNO")) break;
				if(!(line.contains("Račun br.")||line.contains("Kupac:")||line.contains("---")|| line.contains("Proizvod")||line.trim().isEmpty())){
					int firstPos=0, secondPos=0;
					firstPos=calculateFirstPos(line);
					secondPos=calculateSecondPos(line, firstPos);

					int number=Integer.parseInt(line.substring(92, 96).trim());

					String name=line.substring(0, firstPos-1);
					String price=line.substring(firstPos,firstPos+secondPos);
					
					collection.add(new Artikl(name.trim(),price,number));
				
					
					if(mostSold.isEmpty() || !mostSold.contains(new Artikl(name.trim(),price,number))){
						mostSold.add(new Artikl(name.trim(),price,number));
						
					}
					else{
						Artikl art=new Artikl(name.trim(),price,number);
						int index=mostSold.indexOf(art);
						mostSold.get(index).setProdanoKomada(mostSold.get(index).getProdanoKomada()+number);
					}
					
				}

			}

		}
		catch(IOException ex){
			System.err.println(ex);
		}
		return FileVisitResult.CONTINUE;
	}

	/**
	 * @param line 
	 * @param secondPos
	 * @return
	 */
	public static int getNumber(String line, int secondPos) {
		int thirdPos=secondPos+1;

		for(char temp:line.substring(secondPos+1).toCharArray()){
			if(Character.isDigit(temp)){
				break;
			}
			else{
				thirdPos++;
			}
		}

		int forthPos=thirdPos+1;

		for(char temp:line.substring(thirdPos).toCharArray()){
			if(!Character.isDigit(temp)){
				break;
			}
			else{
				forthPos++;
			}
		}
		return Integer.parseInt(line.substring(thirdPos-1, forthPos-1 ));
	}


	/**
	 * Calculates the position of the last digit in price in line.
	 * @param line
	 * @param firstPos 
	 * @return secondPosition
	 */
	public static int calculateSecondPos(String line, int firstPos) {
		int counter=0;
		for(char temp: line.substring(firstPos-1).toCharArray()){
			if(!(Character.isDigit(temp) || temp=='.')){
				break;
			}
			else{
				counter ++;
			}
		}
		return counter;
	}


	/**
	 * Calculates position of the first number of price in line.
	 * @param line
	 * @return firstPosition
	 */
	public static int calculateFirstPos(String line) {
		int counter=0;
		int min= 78;
		for(char temp:line.toCharArray()){
			if(counter>min && Character.isDigit(temp) ){
				counter++;
				break;
			}
			else{
				counter ++;
			}
		}
		return counter;
	}

	/**
	 * If visiting file fails, continue the walk.
	 */
	@Override
	public FileVisitResult visitFileFailed(Path arg0, IOException arg1) throws IOException {

		return FileVisitResult.CONTINUE;
	}


	/**
	 * Getter
	 * @return the mostSold
	 */
	public static List<Artikl> getMostSold() {
		return mostSold;
	}


}
