package Package;

public class Package {
	int priorytate;
	String content;
	int fromWhere;
	int whereTo;
	int number;
	
	public Package(int number, int fromWhere, int whereTo, String content, int priorytate){
		this.number = number;
		this.fromWhere = fromWhere;
		this.whereTo = whereTo;
		this.content = content;
		this.priorytate = priorytate;
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
	
	@Override
	public String toString(){
		return number + " " + fromWhere + " " +
				whereTo + " " + content + " " +
				priorytate;
	}
}
