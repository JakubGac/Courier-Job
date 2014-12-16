package AssigningPackages.States;

import java.util.Vector;

import Package.Package;

public class ThirdState {
	private Vector<Package> packageList;
	private Integer costs[];
	private Integer carsAmount;
	private Vector<Package> helpList = new Vector<Package>();
	
	public ThirdState(Vector<Package> packageList, Integer costs[], Integer carsAmount){
		this.packageList = packageList;
		this.costs = costs;
		this.carsAmount = carsAmount;
	}
	
	public void begin() throws InterruptedException{
		Thread[] threads = new Thread[carsAmount];
		for(int i=0 ; i < countSeries() ; i++){
			for(int j=0 ; j < packageList.size() ; j++){
				if(packageList.get(j).getSeries() == i){
					helpList.addElement(packageList.get(j));
				}
			}
			
			FirstState firstState = new FirstState(helpList,costs);
			/*
			threads[i] = new Thread(firstState);
			helpList.removeAllElements();
		}
		for(int i=0 ; i < threads.length ; i++){
			if(threads[i] != null){
				threads[i].start();
			}
		*/
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
	
}
