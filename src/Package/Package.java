package Package;

public class Package {
	private int priority;
	private String content;
	private int fromWhere;
	private int whereTo;
	private int number;
	private boolean used;
	
	public Package(int number, int fromWhere, int whereTo, String content, int priorytate){
		this.number = number;
		this.fromWhere = fromWhere;
		this.whereTo = whereTo;
		this.content = content;
		this.priority = priorytate;
		used = false;
	}
	
	public void setUsed(){
		used = true;
	}
	
	public int getNumber(){
		return number;
	}
	
	public int getfromWhere(){
		return fromWhere;
	}
	
	public int getPrioritate(){
		return priority;
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
	
	public boolean getUsed(){
		return used;
	}
	
	@Override
	public String toString(){
		return number + " " + fromWhere + " " +
				whereTo + " " + content + " " +
				priority;
	}
}
