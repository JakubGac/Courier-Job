package Package;

public class Package {
	private int priorytate;
	private String content;
	private int fromWhere;
	private int whereTo;
	private int number;
	
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
