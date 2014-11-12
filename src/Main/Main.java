package Main;

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
		System.out.println(graph.toString());
		System.out.println(packagesList.toString());
	}
}
