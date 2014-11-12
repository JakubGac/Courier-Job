package GraphSingleton;

public class Edge {
	private int weight;
	private int whereTo;
	
	public Edge(int weight, int whereTo){
		this.weight = weight;
		this.whereTo = whereTo;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int getWhereTo(){
		return whereTo;
	}
	
	@Override
	public String toString(){
		return "do: " + whereTo + " waga: " + weight;
	}
}
