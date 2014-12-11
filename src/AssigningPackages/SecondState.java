package AssigningPackages;

import java.util.ArrayList;

import DijkstraAlgorithm.Dijkstra;
import GraphSingleton.GraphSingleton;
import Package.Package;

public class SecondState {
	// 1 car, capacity 1
	private ArrayList<Package> packageList;
	private Integer[] costs;
	private GraphSingleton graph = null;
	private Integer currentVertex;
	private Integer capacity;
	
	public SecondState(ArrayList<Package> packageList,Integer[] costs, Integer capacity){
		this.packageList = packageList;
		this.costs = costs;
		graph = GraphSingleton.getInstance();
		this.capacity = capacity;
	}
	
	public void start() throws InterruptedException{
		if(capacity > packageList.size() ){
			getAllPackages();
			startOne();
		} else {
			startTwo();
		}
	}
	
	private void startOne() throws InterruptedException{
		for(int i=0 ; i < packageList.size() ; i++){
			if(!(packageList.get(i) == null)){
				if(i == 0){ // dostarczamy przesylke o najwiekszym priorytecie i przenosimy sie do tamtego miasta
					currentVertex = packageList.get(0).getWhereTo();
					Thread.sleep( costs[currentVertex] * 200 );
					Package p = packageList.get(0);
					System.out.println("Dostarczono przesy³kê " + p.getNumber() + " "
							+ p.getContent() 
							+ " do miasta " + graph.getVertex(p.getWhereTo()).getCity());
				} else {
					if(packageList.get(i).getWhereTo() == currentVertex ){ // sprawdzamy czy jest wiecej przesylek do tego samego miasta
						Package p = packageList.get(i);
						System.out.println("Dostarczono przesy³kê " + p.getNumber() + " "
								+ p.getContent() 
								+ " do miasta " + graph.getVertex(p.getWhereTo()).getCity());
					} else {
						// przesy³ka jest do jakiegos miast po drodze 
						// musimy obliczyc najblizsza odleglosc do tego miasta
						Integer[] costs2;
						Dijkstra dijkstra2 = new Dijkstra(graph.getVector(),currentVertex,
								graph.getLength());
						dijkstra2.start();
						costs2 = dijkstra2.getCosts();
						currentVertex = packageList.get(i).getWhereTo();
						Thread.sleep( costs[currentVertex] * 200 );
						Package p = packageList.get(i);
						System.out.println("Dostarczono przesy³kê " + p.getNumber() + " "
								+ p.getContent() 
								+ " do miasta " + graph.getVertex(p.getWhereTo()).getCity());
						}
				}
			}
		}
	}
	
	private void startTwo(){
		
	}
	
	private void getAllPackages(){
		for(int i=0 ; i < packageList.size() ; i++){
			Package p = packageList.get(i);
			System.out.println("Pobrano przesy³kê " + p.getNumber() 
					+ " " + p.getContent() + " z miasta " 
					+ graph.getVertex(p.getfromWhere()).getCity());
		}
	}
	
	private void sendCar(Package p) throws InterruptedException{
		System.out.println("Pobrano przesy³kê " + p.getNumber() 
				+ " " + p.getContent() + " z miasta " 
				+ graph.getVertex(p.getfromWhere()).getCity());
		Thread.sleep( costs[p.getWhereTo()] * 200 );
		System.out.println("Dostarczono przesy³kê " + p.getNumber() + " "
				+ p.getContent() 
				+ " do miasta " + graph.getVertex(p.getWhereTo()).getCity());
		Thread.sleep( costs[p.getWhereTo()] * 200 );
	}
}
