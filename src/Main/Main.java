package Main;

import java.util.ArrayList;

import Cars.Car;
import DijkstraAlgorithm.Dijkstra;
import GraphSingleton.*;
import ReadFiles.*;
import Package.*;
import Package.Package;
import AssigningPackages.*;

public class Main {
	public static void main(String[] args) throws ErrorHandling, InterruptedException {
		long start = System.nanoTime();
		int whereTo = 0;
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Package> packagesList = new ArrayList<Package>();
		Integer howMany = Integer.parseInt(args[0]);
		GraphSingleton graph = GraphSingleton.getInstance();
		SearchingPackage searching = new SearchingPackage();
		Integer[] costs;
		Integer[] previousVertex;
		
		// wczytywanie samochodów
		for(int i=0 ; i < Integer.parseInt(args[0]) ; i++){
			cars.add(new Car(Integer.parseInt(args[1])));
		}
		
		//wczytywanie danych z plików
		ReadFile cities = new Cities();
		ReadFile connections = new Connections();
		ReadFile packages = new Packages();
		cities.read();
		connections.read();
		packages.read();
		
		//znajdujemy paczkę o największym priorytecie 
		//szukamy czy mamy więcej paczek do tego miejsca
		packagesList.add(searching.find()); 
		whereTo = packagesList.get(0).getWhereTo();
		
		for(int i=0 ; i < searching.checkedAnother(whereTo) ; i++){
			packagesList.add(searching.findAnother(whereTo));
		}
		
		// wyszukujemy najkrótszą ścieżkę do tego wierzchołka
		Dijkstra dijkstra = new Dijkstra(graph.getVector(),packagesList.get(0).fromWhere(),
				graph.getLength());
		dijkstra.start();
		costs = dijkstra.getCosts();
		previousVertex = dijkstra.getPreviousVertex();
				
		//sprawdzamy czy mamy jakieś paczki po drodze
		Integer a = previousVertex[whereTo];
		while(a != packagesList.get(0).getfromWhere()){
			for(int i=0 ; i < searching.checkedAnother(a) ; i++){
				packagesList.add(searching.findAnother(a));
			}
			a = previousVertex[a];
		}

		FirstState firstState = new FirstState(packagesList,costs);
		SecondState secondState = new SecondState(packagesList,costs,Integer.parseInt(args[1]));
		secondState.start();
		
		
		
		
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("dane pomocnicze");
		System.out.print("Koszty dojść: ");
		for(int i=0 ; i < costs.length ; i++){
			System.out.print(costs[i] + " ");
		}
		
		System.out.println();
		System.out.print("Poprzednie wierzchołki: ");
		for(int i=0 ; i < previousVertex.length ; i++){
			System.out.print(previousVertex[i] + " ");
		}
		
		System.out.println();
		System.out.print("Lista paczek: ");
		System.out.println(packagesList);
		System.out.print("Samochody: ");
		System.out.println(cars);
		
		long czas = ((System.nanoTime() - start)/1000);
		System.out.println("Czas działania programu: " + czas);
	}
}
  