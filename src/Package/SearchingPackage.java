package Package;

public class SearchingPackage {
	private Integer whereTo;
	private PackageSingleton packagesList;
	private Integer whichPackage;
	private Integer priority;
	private Integer howMany ;
	
	public SearchingPackage(){
		packagesList = PackageSingleton.getInstance();
		whereTo = 0;
		whichPackage = 0;
		priority = 0;
		howMany = 0;
	}
	
	public Package find(){
		whichPackage = 0;
		for(int i=0 ; i < packagesList.getSize() ; i++){
			if(!(packagesList.getPackage(i).getUsed())){
				if(packagesList.getPackage(i).getPrioritate() > priority){
					priority = packagesList.getPackage(i).getPrioritate();
					whichPackage = packagesList.getPackage(i).getNumber();
					whereTo = packagesList.getPackage(i).getWhereTo();
				}
			}
		}	
		setUsed(whichPackage);
		return packagesList.getPackage(whichPackage-1);
	}
	
	public Package findAnother(Integer whereTo){
		whichPackage = 0;
		this.whereTo = whereTo;
		for(int i=0 ; i < packagesList.getSize() ; i++){
			if(!(packagesList.getPackage(i).getUsed())){
				if(packagesList.getPackage(i).getWhereTo() == whereTo){
					priority = packagesList.getPackage(i).getPrioritate();
					whichPackage = packagesList.getPackage(i).getNumber();
				}
			}
		}	
		setUsed(whichPackage);
		return packagesList.getPackage(whichPackage-1);
	}

	public Integer checkedAnother(Integer whereTo){
		this.whereTo = whereTo;
		howMany = 0;
		for(int i=0 ; i < packagesList.getSize() ; i++){
			if(!packagesList.getPackage(i).getUsed()){
				if(packagesList.getPackage(i).getWhereTo() == whereTo){
					howMany++;
				}
			}
		}
		return howMany;
	}
	
	private void setUsed(Integer a){
		for(int i=0 ; i < packagesList.getSize() ; i++){
			if(packagesList.getPackage(i).getNumber() == a){
				packagesList.getPackage(i).setUsed();
			}
		}
	}
	
	public String getName(){
		return packagesList.getPackage(whichPackage-1).getContent();
	}
}
