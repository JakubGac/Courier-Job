package GraphSingleton;

import java.util.Vector;

public class GraphSingleton {
	private static GraphSingleton instance = null;
	private Vector<Vertex> vertex;
	
	private GraphSingleton(){
		vertex = new Vector<Vertex>();
	}
	
	public static synchronized GraphSingleton getInstance(){
		
		if(instance == null){
			instance = new GraphSingleton();
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
	
	public Vertex getVertex(Integer i){
		return vertex.elementAt(i);
	}
	
	public Integer getLength(){
		return vertex.size();
	}
	
	public Vector getVector(){
		return vertex;
	}
	
	@Override
	public String toString(){
		return vertex.toString();
	}
}
