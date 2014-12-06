package GraphSingleton;

import java.util.Vector;

public class Vertex {
	private int number;
	private String city;
	private Vector<Edge> edges = new Vector<Edge>();
	
	public Vertex(int number,String city){
		this.number = number;
		this.city = city;
	}
	
	public void addEdge(Edge edge){
		edges.addElement(edge);
	}
	
	public String getCity(){
		return city;
	}
	
	public int number(){
		return number;
	}
	
	public Integer getEdgesLength(){
		return edges.size();
	}
	
	public Edge getEdge(Integer i){
		return edges.elementAt(i);
	}
	
	@Override
	public String toString(){
		return number + " " + city + edges;
	}
}
