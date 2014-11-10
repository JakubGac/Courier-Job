package Package;

public class Package {
	int priorytate;
	String content;
	int fromWhere;
	int whereTo;
	
	public Package(int priorytate, String content,int fromWhere,int whereTo){
		this.priorytate = priorytate;
		this.content = content;
		this.fromWhere = fromWhere;
		this.whereTo = whereTo;
	}
	
	public int getPriorytate(){
		return priorytate;
	}
	
	public String getContent(){
		return content;
	}
	
	public int fromWhere(){
		return fromWhere;
	}
	
	public int getWhereTo(){
		return whereTo;
	}

}
