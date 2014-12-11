package AssigningPackages;

import java.util.ArrayList;

import GraphSingleton.GraphSingleton;
import Package.Package;

public class FirstState {
	// 1 car, capacity 1
	private ArrayList<Package> packageList;
	private Integer[] costs;
	private GraphSingleton graph = null;
	
	public FirstState(ArrayList<Package> packageList,Integer[] costs){
		this.packageList = packageList;
		this.costs = costs;
		graph = GraphSingleton.getInstance();
	}
	
	public void start() throws InterruptedException{
		for(int i=0 ; i < packageList.size() ; i++){
			sendCar(packageList.get(i));
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
