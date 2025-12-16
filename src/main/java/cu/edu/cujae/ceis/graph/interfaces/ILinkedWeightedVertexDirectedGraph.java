package cu.edu.cujae.ceis.graph.interfaces;

/**
 * Interface para grafos dirigidos con vértices ponderados
 */
public interface ILinkedWeightedVertexDirectedGraph extends
		ILinkedDirectedGraph {
	public boolean insertWVertex(Object info, Object weight);
}
