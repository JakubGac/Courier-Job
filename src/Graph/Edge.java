package Graph;

public class Edge {
	int weight;
	int whereTo;
	
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
	
	public String toString(){
		return "do: " + whereTo + " waga: " + weight;
	}
}
