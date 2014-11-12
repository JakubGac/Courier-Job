package ReadFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Package.*;
import Package.Package;

public class Packages implements ReadFile {
	private FileReader file;
	private String linia;
	private PackageSingleton packageSingleton ;
	private BufferedReader bfr;
	
	public Packages(){
		packageSingleton = PackageSingleton.getInstance();
		file = null;
		linia = "";
	}
	
	
	public void read() throws ErrorHandling {
		openFile();
		readFile();
		closeFile();
	}
	
	private void openFile() throws ErrorHandling {
		try {
			file = new FileReader("EntryFiles/Packages.txt");
		} catch (FileNotFoundException e) {
			throw new ErrorHandling( e.getMessage() );	   
		}
	}
	
	private void readFile() throws ErrorHandling {
		bfr = new BufferedReader(file);
		
		try {
			while((linia = bfr.readLine()) != null){
				String[] linia2 = linia.split(" ");
					packageSingleton.addPackage(new Package(Integer.parseInt(linia2[0]),
						Integer.parseInt(linia2[1]),
							Integer.parseInt(linia2[2]),
							linia2[3] + " " + linia2[4] + " " + linia2[5],
							Integer.parseInt(linia2[6])));
			}
		} catch ( IOException e ) {
			throw new ErrorHandling( e.getMessage() );	
		} catch ( NumberFormatException e ) {
			throw new ErrorHandling( e.getMessage() );	
		}
	}
	
	private void closeFile() throws ErrorHandling {
		try {
			file.close();
		} catch ( IOException e ) {
			throw new ErrorHandling( e.getMessage() );	 
		}
	}
}
