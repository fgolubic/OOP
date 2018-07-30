/**
 * 
 */
package hr.fer.oop.lab5.second;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

/**
 * @author Filip
 *
 */
public class Program {

	/**
	 * Main creates two new ".txt" files using two different encodings. It begins walking the file tree given as path
	 *  and writes in two newly created files. 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path p=Paths.get("D:\\Users\\Filip\\hr\\fer\\oop\\lab5\\racuni");
		MySecondByteReader reader=new MySecondByteReader();
		Files.walkFileTree(p,reader);

		Path iso=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/cjenik.88592.txt");
		Path utf=Paths.get("D:/Users/Filip/hr/fer/oop/lab5/cjenik.utf8.txt");

		Files.deleteIfExists(utf);
		Files.deleteIfExists(iso);

		Files.createFile(utf);
		Files.createFile(iso);

		try(BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(iso.toString())),"ISO-8859-2"))){
			reader.getCollection().stream().forEach(new Consumer<Artikl>(){

				@Override
				public void accept(Artikl a) {

					try {
						writer.write(a.getNaziv().toString()+" "+a.getCijena().toString());
						writer.write("\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});

		}
		catch(IOException ex){
			System.err.println(ex);
		}

		try(BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(utf.toString())),"UTF-8"))){
			reader.getCollection().stream().forEach(new Consumer<Artikl>(){

				@Override
				public void accept(Artikl a) {

					try {
						writer.write(a.getNaziv().toString()+" "+a.getCijena().toString());
						writer.write("\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});

		}
		catch(IOException ex){
			System.err.println(ex);
		}
	}

}


