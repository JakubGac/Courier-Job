package Main;

import Graph.Graph;
import ReadFiles.*;

public class Main {
	public static void main(String[] args) throws ErrorHandling {
		
		ReadFile cities = new Cities();
		ReadFile connections = new Connections();
		ReadFile packages = new Packages();
		
		cities.read();
		connections.read();
		packages.read();
		
		//Graph graph = Graph.getInstance();
		//System.out.println(graph.toString());
		
		/*
		graph.addVertex(0,new Vertex(0,"Radom"));
		graph.addVertex(1,new Vertex(1,"Warszawa"));
		graph.addVertex(2,new Vertex(2,"Olsztyn"));
		graph.addVertex(3,new Vertex(3,"Suwałki"));
		graph.addVertex(4,new Vertex(4,"Poznań"));
		
		graph.addEdge(0,new Edge(100,1));
		graph.addEdge(0,new Edge(200,2));
		graph.addEdge(1,new Edge(10,3));
		graph.addEdge(2,new Edge(15,3));
		*/
		
	}
}
