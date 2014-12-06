package Main;

import DijkstraAlgorithm.Dijkstra;
import GraphSingleton.*;
import ReadFiles.*;
import Package.*;

public class Main {
	public static void main(String[] args) throws ErrorHandling {
		
		ReadFile cities = new Cities();
		ReadFile connections = new Connections();
		ReadFile packages = new Packages();
		
		cities.read();
		connections.read();
		packages.read();
		
		GraphSingleton graph = GraphSingleton.getInstance();
		PackageSingleton packagesList = PackageSingleton.getInstance();
		
		System.out.println(graph);
		
		Dijkstra dijkstra = new Dijkstra(graph.getVector(),0,graph.getLength());
		dijkstra.start();
		
		System.out.println(graph);
	}
}
  