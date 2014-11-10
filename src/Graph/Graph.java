package Graph;

import java.util.Vector;

public class Graph {
	private static Graph instance = null;
	private Vector<Vertex> vertex;
	
	private Graph(){
		vertex = new Vector<Vertex>();
	}
	
	public static synchronized Graph getInstance(){
		
		if(instance == null){
			instance = new Graph();
			return instance;
		}
		return instance;
	}
	
	public void addVertex(int i, Vertex v){
		vertex.add(i,v);
	}
	
	public void addEdge(int i, Edge e){
		vertex.elementAt(i).addEdge(e);
	}
	
	@Override
	public String toString(){
		return vertex.toString();
	}
}
