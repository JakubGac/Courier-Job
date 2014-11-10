package ReadFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Graph.Edge;
import Graph.Graph;

public class Connections implements ReadFile {
	private FileReader file;
	private String linia;
	private Graph graph;
	private BufferedReader bfr;
	
	public Connections(){
		graph = Graph.getInstance();
		file = null;
		linia = "";
	}
	
	public void read() throws ErrorHandling {
		
		try {
			file = new FileReader("EntryFiles/Connections.txt");
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