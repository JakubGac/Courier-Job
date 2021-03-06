package ReadFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import GraphSingleton.Edge;
import GraphSingleton.GraphSingleton;

public class Connections implements ReadFile {
	private FileReader file;
	private String linia;
	private GraphSingleton graph;
	private BufferedReader bfr;
	
	public Connections(){
		graph = GraphSingleton.getInstance();
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
			file = new FileReader("EntryFiles/Connections.txt");
		} catch (FileNotFoundException e) {
			throw new ErrorHandling( e.getMessage() );	   
		}
	}
	
	private void readFile() throws ErrorHandling {
		bfr = new BufferedReader(file);
		
		try {
			while((linia = bfr.readLine()) != null){
				String[] linia2 = linia.split(" ");
				graph.addEdge( Integer.parseInt(linia2[0]) , new Edge( Integer.parseInt(linia2[2]) , Integer.parseInt(linia2[1]) ) );
				graph.addEdge( Integer.parseInt(linia2[1]) , new Edge( Integer.parseInt(linia2[2]) , Integer.parseInt(linia2[0]) ) );
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
