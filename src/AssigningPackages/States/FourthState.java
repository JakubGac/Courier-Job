package AssigningPackages.States;

import java.util.Vector;
import Package.Package;

public class FourthState {
	private Vector<Package> packageList;
	private Integer costs[];
	
	public FourthState(Vector<Package> packageList, Integer costs[]){
		this.packageList = packageList;
		this.costs = costs;
	}
	
	public void begin(){
		
	}
}
