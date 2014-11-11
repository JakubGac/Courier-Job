package Main;

import Graph.Graph;
import ReadFiles.*;

public class Main {
	public static void main(String[] args) throws ErrorHandling {
		
		ReadFile cities = new Cities();
		ReadFile connections = new Connections();
		//ReadFile packages = new Packages();
		
		cities.read();
		connections.read();
		//packages.read();
		
		Graph graph = Graph.getInstance();
		System.out.println(graph.toString());
	}
}
