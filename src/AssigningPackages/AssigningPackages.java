package AssigningPackages;

import java.util.Vector;

import AssigningPackages.States.FirstState;
import AssigningPackages.States.FourthState;
import AssigningPackages.States.SecondState;
import AssigningPackages.States.ThirdState;
import Package.Package;

public class AssigningPackages {
	Vector<Package> packagesList;
	Integer[] costs;
	Integer capacity;
	Integer carNumber;
	
	public AssigningPackages(Vector<Package> packagesList, Integer[] costs, 
			Integer capacity, Integer carNumber){
		this.packagesList = packagesList;
		this.costs = costs;
		this.capacity = capacity;
		this.carNumber = carNumber;
	}
	
	public void start() throws InterruptedException{
		chooseState();
	}
	
	private void chooseState() throws InterruptedException{
		if(carNumber == 1){
			if(capacity == 1){
				FirstState firstState = new FirstState(packagesList,costs);
				Thread thread = new Thread(firstState);
				thread.start();
			} else {
				SecondState secondState = new SecondState(packagesList,costs,capacity,carNumber);
				Thread thread = new Thread(secondState);
				thread.start();
			}
		} else {
			if(capacity == 1){
				ThirdState thirdState = new ThirdState(packagesList,costs,carNumber);
				thirdState.begin();
			} else {
				FourthState fourthState = new FourthState(packagesList,costs);
				fourthState.begin();
			}
		}
	}
}
