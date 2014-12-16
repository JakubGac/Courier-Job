package AssigningPackages.States;

import java.util.Vector;

import DijkstraAlgorithm.Dijkstra;
import GraphSingleton.GraphSingleton;
import Package.Package;
import Package.PackageSingleton;

public class SecondState implements Runnable {
	// 1 car, capacity 1
	private Vector<Package> packageList;
	private Integer[] costs;
	private GraphSingleton graph = null;
	private PackageSingleton packageSingleton;
	private Integer currentVertex;
	private Integer capacity;
	
	public SecondState(Vector<Package> packageList,Integer[] costs, Integer capacity){
		this.packageList = packageList;
		this.costs = costs;
		graph = GraphSingleton.getInstance();
		this.capacity = capacity;
		packageSingleton = PackageSingleton.getInstance();
	}
	
	@Override
	public void run(){
		try {
			begin();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void begin() throws InterruptedException{
		Integer lastPackage = 0;
		Integer a = 0;
		for(int i=0 ; i < countSeries() ; i++){
			a = countPackages(i);
			if(capacity >= a){
				getAllPackages(a,lastPackage);
				startOne(a,lastPackage);
				lastPackage = lastPackage + a;
			} else {
				startTwo();
			}
		}
		
	}
	
	private Integer countSeries(){
		Integer series=1;
		Integer help = 0;
		for(int i=0 ; i < packageList.size() ; i++){
			if(packageList.get(i).getSeries() != help){
				series++;
				help = packageList.get(i).getSeries();
			}
		}
		return series; 
	}
	
	private Integer countPackages(Integer series){
		Integer help = 0;
		for(int i=0 ; i < packageList.size() ; i++){
			if(packageList.get(i).getSeries() == series){
				help++;
			}
		}
			
		return help; 
	}
	
	private void startOne(Integer a, Integer lastPackage) throws InterruptedException{
		for(int i=lastPackage ; i < a + lastPackage ; i++){
			if(!(packageList.get(i) == null)){
				if(i == lastPackage){ // dostarczamy przesylke o najwiekszym priorytecie i przenosimy sie do tamtego miasta
					currentVertex = packageList.get(lastPackage).getWhereTo();
					Thread.sleep( costs[currentVertex] * 200 );
					Package p = packageList.get(lastPackage);
					sendCar(p);
				} else {
					if(packageList.get(i).getWhereTo() == currentVertex ){ 
						// sprawdzamy czy jest wiecej przesylek do tego samego miasta
						Package p = packageList.get(i);
						
						sendCar(p);
					} else {
						// przesy³ka jest do jakiegos miast po drodze 
						// musimy obliczyc najblizsza odleglosc do tego miasta
						countWay();
						currentVertex = packageList.get(i).getWhereTo();
						Thread.sleep( costs[currentVertex] * 200 );
						Package p = packageList.get(i);
						sendCar(p);
					}
				}
			}
		}
	}
	
	private void startTwo(){
		
	}
	
	private void getAllPackages(Integer a, Integer lastPackage){
		for(int i=lastPackage ; i < a + lastPackage ; i++){
			Package p = packageList.get(i);
			System.out.println("Pobrano przesy³kê " + p.getNumber() 
					+ " " + p.getContent() + " z miasta " 
					+ graph.getVertex(p.getfromWhere()).getCity());
			System.out.println();
		}
	}
	
	private void countWay(){
		Integer[] costs2;
		
		Dijkstra dijkstra2 = new Dijkstra(graph.getVector(),currentVertex,
				graph.getLength());
		dijkstra2.start();
		costs2 = dijkstra2.getCosts();
	}
	
	private void sendCar(Package p){
		System.out.println("Dostarczono przesy³kê " + p.getNumber() + " "
				+ p.getContent() 
				+ " do miasta " + graph.getVertex(p.getWhereTo()).getCity());
		System.out.println();
	}
}
