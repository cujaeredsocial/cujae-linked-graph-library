package cu.edu.cujae.ceis.graph.interfaces;

/**
 * Interface para grafos dirigidos con aristas ponderadas
 */
public interface ILinkedWeightedEdgeDirectedGraph extends ILinkedDirectedGraph {
	public boolean insertWEdgeDG(int posTail, int posHead, Object weight);
}
