package AssigningPackages.States;

import java.util.Vector;
import GraphSingleton.GraphSingleton;
import Package.Package;
import Package.PackageSingleton;

public class FirstState implements Runnable {
	// 1 car, capacity 1
	private Vector<Package> listPackage;
	private Integer[] costs;
	private GraphSingleton graph;
	public FirstState(Vector<Package> listPackage,Integer[] costs){
		this.listPackage = listPackage;
		this.costs = costs;
		graph = GraphSingleton.getInstance();
		PackageSingleton.getInstance();
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
		for(int i=0 ; i < listPackage.size() ; i++){
			sendCar(listPackage.get(i),i);
		}
	}
	
	private void sendCar(Package p, int a) throws InterruptedException{
		Integer sleepingTime = costs[p.getWhereTo()] * 100;
		System.out.println("Pobrano przesy³kê " + p.getNumber() 
				+ " " + p.getContent() + " z miasta " 
				+ graph.getVertex(p.getfromWhere()).getCity());
		System.out.println();
		Thread.sleep( sleepingTime );
		System.out.println("Dostarczono przesy³kê " + p.getNumber() + " "
				+ p.getContent() 
				+ " do miasta " + graph.getVertex(p.getWhereTo()).getCity());
		Thread.sleep( sleepingTime );
		System.out.println();
	}
}
