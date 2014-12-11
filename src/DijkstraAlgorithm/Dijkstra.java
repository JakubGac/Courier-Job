package DijkstraAlgorithm;

import java.util.Vector;

import GraphSingleton.*;

public class Dijkstra {
	private Integer startVertex;
	private Vector<Vertex> vertex;;
	private Integer vertexAmount;
	private Vector<Integer> doneVertex = new Vector<Integer>();
	private Integer[] costs; 
	private Integer[] previousVertex;
	private Integer helpVertex = 0;
	private Integer nextVertex = 0;
	
	public Dijkstra(Vector<Vertex> vertex, Integer startVertex, Integer vertexAmount){
		this.vertex = vertex;
		this.startVertex = startVertex;
		this.vertexAmount = vertexAmount;
		costs = new Integer[vertexAmount];
		previousVertex = new Integer[vertexAmount];
	}
	
	public void start(){
		prepare();
		helpVertex = startVertex;
		costs[startVertex] = 0; // koszt dojœcia do wierzcho³ka wyjœciowego = 0
		
		while( doneVertex.size() < vertexAmount*2 -1 ){
			if(helpVertex == startVertex){
				doneVertex.add(helpVertex);
				neighbour(helpVertex);
				helpVertex = searchVertex(vertex.elementAt(helpVertex));
			} else {
				doneVertex.add(helpVertex);
				neighbour(helpVertex);
				helpVertex = searchVertex(vertex.elementAt(helpVertex));
			}	
		}
	}
	
	private void prepare(){
		doneVertex.clear();
		for(int i=0 ; i < costs.length ; i++){
			costs[i] = 123456;
			previousVertex[i] = -1;
		}
	}
	
	private Integer searchVertex(Vertex e){ // wyszukuje wierzcho³ek o najkrótszej drodze

		Integer min = e.getEdge(0).getWeight();
		Integer which = e.getEdge(0).getWhereTo();

		for(int i=1 ; i < e.getEdgesLength(); i++){
			if(e.getEdge(i).getWeight() < min){
				min = e.getEdge(i).getWeight();
				which = e.getEdge(i).getWhereTo();
			}
		}		
			return which;
	}
	
	private void neighbour(Integer actualVertex){
		Integer neighbour;
		
		for(int i=0 ; i < vertex.elementAt(actualVertex).getEdgesLength() ; i++){
			neighbour = vertex.elementAt(actualVertex).getEdge(i).getWhereTo();
			if(costs[neighbour] > 
				costs[actualVertex] + vertex.elementAt(actualVertex).getEdge(i).getWeight()){
				costs[neighbour] = 
						costs[actualVertex] + vertex.elementAt(actualVertex).getEdge(i).getWeight();
				previousVertex[neighbour] = actualVertex;
			}
		}
	}

	public Integer[] getCosts(){
		return costs;
	}

	public Integer[] getPreviousVertex(){
		return previousVertex;
	}
}
