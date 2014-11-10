package ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Graph.*;

public class ReadFile {
	private FileReader file;
	private String linia;
	private Graph graph;
	private BufferedReader bfr;
	
	public ReadFile() {
		graph = Graph.getInstance();
		file = null;
		linia = "";
	}
	
	public void readFile() throws ErrorHandling {
			
		fileOne();
		fileTwo();
		
	}
	
	private void fileOne() throws ErrorHandling {
		
		try {
			file = new FileReader("Cities.txt");
		} catch (FileNotFoundException e) {
			throw new ErrorHandling( e.getMessage() );	   
		}
		
		bfr = new BufferedReader(file);
		
		try {
			while((linia = bfr.readLine()) != null){
				String[] linia2 = linia.split(" ");
				graph.addVertex(Integer.parseInt(linia2[0]), new Vertex(Integer.parseInt(linia2[0]),linia2[1]));
			}
		} catch ( IOException e ) {
			throw new ErrorHandling( e.getMessage() );	
		} catch ( NumberFormatException e ) {
			throw new ErrorHandling( e.getMessage() );	
		}
		
		try {
			file.close();
		} catch ( IOException e ) {
			throw new ErrorHandling( e.getMessage() );	 
		}
		
	}
	
	private void fileTwo() throws ErrorHandling {
		
		try {
			file = new FileReader("Connections.txt");
		} catch (FileNotFoundException e) {
			throw new ErrorHandling( e.getMessage() );	   
		}
		
		bfr = new BufferedReader(file);
		
		try {
			while((linia = bfr.readLine()) != null){
				String[] linia2 = linia.split(" ");
				graph.addEdge( Integer.parseInt(linia2[0]) , new Edge( Integer.parseInt(linia2[2]) , Integer.parseInt(linia2[1]) ) );
			}
		} catch ( IOException e ) {
			throw new ErrorHandling( e.getMessage() );	
		} catch ( NumberFormatException e ) {
			throw new ErrorHandling( e.getMessage() );	
		}
		
		try {
			file.close();
		} catch ( IOException e ) {
			throw new ErrorHandling( e.getMessage() );	 
		}
		
	}
}
