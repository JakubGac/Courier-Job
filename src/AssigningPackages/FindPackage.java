package AssigningPackages;

import java.util.Vector;
import DijkstraAlgorithm.Dijkstra;
import GraphSingleton.GraphSingleton;
import Package.*;
import Package.Package;

public class FindPackage {
	private SearchingPackage searching;
	private Vector<Package> packagesList;
	private Integer whereTo;
	GraphSingleton graph;
	PackageSingleton packageSingleton;
	Integer[] costs;
	Integer[] previousVertex;
	Dijkstra dijkstra;
	Integer carNumber;
	Integer capacity;
	AssigningPackages assigningPackages;
	
	public FindPackage(Integer carNumber, Integer capacity){
		searching = new SearchingPackage();
		packagesList = new Vector<Package>();
		whereTo = 0;
		graph = GraphSingleton.getInstance();
		this.carNumber = carNumber;
		this.capacity = capacity;
		packageSingleton = PackageSingleton.getInstance();
	}
	
	public void find() throws InterruptedException{
		Integer k = 0;
		Integer lastElement = 0;
		while(!packageSingleton.isEmpty()){
			// znajdujemy paczk� o najwi�kszym priorytecie
			// oraz inne do tego samego miasta
			findPackage();
			
			// wyszukujemy najkr�tsz� �cie�k� do tego wierzcho�ka
			findWay();
			
			// sprawdzamy czy mamy jakie� paczki po drodze
			findPrevious();
			
			// ustawiamy seri� paczek
			setSeries(k,lastElement);
			
			//usuwamy wiercho�ki kt�re zosta�u ju� wykorzystane
			removeVertex();
			
			lastElement = packagesList.size();
			k++;
		}
			
		//puszczamy samochody
		startCars();
		/*
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("dane pomocnicze");
		System.out.print("Koszty doj��: ");
		for(int i=0 ; i < costs.length ; i++){
			System.out.print(costs[i] + " ");
		}
		
		System.out.println();
		System.out.print("Poprzednie wierzcho�ki: ");
		for(int i=0 ; i < previousVertex.length ; i++){
			System.out.print(previousVertex[i] + " ");
		}
		
		System.out.println();
		System.out.print("Lista paczek: ");
		System.out.println(packagesList);
		
		PackageSingleton paczki = PackageSingleton.getInstance();
		
		System.out.println();
		System.out.print("Lista wszystkich paczek: ");
		System.out.println(paczki);
		*/
	}
	
	private void findPackage(){
		packagesList.add(searching.find());
		whereTo = packagesList.lastElement().getWhereTo();
		
		searching.findAnother(whereTo,packagesList);
	}
	
	private void findWay(){
		dijkstra = new Dijkstra(graph.getVector(),packagesList.lastElement().fromWhere(),
				graph.getLength());
		dijkstra.start();
		costs = dijkstra.getCosts();
		previousVertex = dijkstra.getPreviousVertex();
	}
	
	private void findPrevious(){
		Integer a = previousVertex[whereTo];
		while(a != packagesList.lastElement().getfromWhere()){
			searching.findAnother(a,packagesList);
			a = previousVertex[a];
		}
	}
	
	private void startCars() throws InterruptedException{
		assigningPackages = new AssigningPackages(packagesList,costs,capacity,carNumber);
		assigningPackages.start();
	}
	
	private void removeVertex(){
		for(int i=0 ; i < packagesList.size() ; i++){
			packageSingleton.removePackage(packagesList.get(i));
		}
	}
	
	private void setSeries(Integer a, Integer lastElement){
		for(int i=lastElement ; i < packagesList.size() ; i++){
			packagesList.get(i).setSeries(a);
		}
	}
}
