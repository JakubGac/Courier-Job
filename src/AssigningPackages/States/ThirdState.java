package AssigningPackages.States;

import java.util.Vector;
import Package.Package;

public class ThirdState {
	private Vector<Package> packageList;
	private Integer costs[];
	
	public ThirdState(Vector<Package> packageList, Integer costs[]){
		this.packageList = packageList;
		this.costs = costs;
	}
	
	public void begin(){
		
	}
}
