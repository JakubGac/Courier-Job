import java.util.Vector;

import Graph.Edge;
import Graph.Vertex;

public class Main {
	public static void main(String[] args){
		Vector<Vertex> vertexs = new Vector<Vertex>();
		
		vertexs.add(0,new Vertex(0,"Radom"));
		vertexs.add(1,new Vertex(1,"Warszawa"));
		vertexs.add(2,new Vertex(2,"Olsztyn"));
		vertexs.add(3,new Vertex(3,"Suwa³ki"));
		vertexs.add(4,new Vertex(4,"Poznañ"));
				
		vertexs.elementAt(0).addEdge(new Edge(100,1));
		vertexs.elementAt(0).addEdge(new Edge(200,2));
		vertexs.elementAt(1).addEdge(new Edge(10,3));
		vertexs.elementAt(2).addEdge(new Edge(15,3));

		System.out.println(vertexs);
	}
}
