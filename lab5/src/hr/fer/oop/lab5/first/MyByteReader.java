/**
 * 
 */
package hr.fer.oop.lab5.first;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Filip
 *
 */
public class MyByteReader implements FileVisitor<Path> {
	private BufferedOutputStream stream;
	/**
	 * Constructor using:
	 */
	public MyByteReader(OutputStream stream) {
		if(stream!=null){
			this.stream= new BufferedOutputStream(stream);
		}
		else{
			System.out.println("Nije predan stream za MyByteReader!");
		}
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}


	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		byte[] buffer;
		if(file.toString().endsWith(".txt")){
			try(BufferedInputStream is=new BufferedInputStream(new FileInputStream(file.toString()))){
				while(true){
					buffer=new byte[1024];
					int temp=is.read(buffer);
					if(temp<0) return FileVisitResult.CONTINUE;
					for(int i=0;i<temp;i++){
						stream.write(buffer[i]);
					}	
				}
			}catch(IOException ex){
				System.err.println(ex);
			}
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		
		return FileVisitResult.CONTINUE;
	}



}
