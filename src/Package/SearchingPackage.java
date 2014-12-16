package Package;

import java.util.Vector;

public class SearchingPackage {
	private PackageSingleton packageSingleton;
	private Integer whichPackage;
	private Integer priority;
	private Integer howMany ;
	
	public SearchingPackage(){
		packageSingleton = PackageSingleton.getInstance();
		whichPackage = 0;
		priority = 0;
		howMany = 0;
	}
	
	public Package find(){
		whichPackage = 0;
		priority = 0;
		Package p = null;
		for(int i=0 ; i < packageSingleton.getSize() ; i++){
			if(!(packageSingleton.getPackage(i).getUsed())){
				if(packageSingleton.getPackage(i).getPrioritate() > priority){
					priority = packageSingleton.getPackage(i).getPrioritate();
					p = packageSingleton.getPackage(i);
					whichPackage = packageSingleton.getPackage(i).getNumber();
					packageSingleton.getPackage(i).getWhereTo();
				}
			}
		}
		setUsed(whichPackage);
		return p;
	}
	
	public void findAnother(Integer whereTo,Vector<Package> packagesList){
		whichPackage = 0;
		Package p = null;
		for(int j=0 ; j < checkedAnother(whereTo) ; j++){
			for(int i=0 ; i < packageSingleton.getSize() ; i++){
				if(!(packageSingleton.getPackage(i).getUsed())){
					if(packageSingleton.getPackage(i).getWhereTo() == whereTo){
						p = packageSingleton.getPackage(i);
						whichPackage = packageSingleton.getPackage(i).getNumber();
						setUsed(whichPackage);
						packagesList.addElement(p);
					}
				}
			}
		}
	}

	private Integer checkedAnother(Integer whereTo){
		howMany = 0;
		for(int i=0 ; i < packageSingleton.getSize() ; i++){
			if(!packageSingleton.getPackage(i).getUsed()){
				if(packageSingleton.getPackage(i).getWhereTo() == whereTo){
					howMany++;
				}
			}
		}
		return howMany;
	}
	
	private void setUsed(Integer a){
		for(int i=0 ; i < packageSingleton.getSize() ; i++){
			if(packageSingleton.getPackage(i).getNumber() == a){
				packageSingleton.getPackage(i).setUsed();
			}
		}
	}
	
	public String getName(){
		return packageSingleton.getPackage(whichPackage-1).getContent();
	}
}
