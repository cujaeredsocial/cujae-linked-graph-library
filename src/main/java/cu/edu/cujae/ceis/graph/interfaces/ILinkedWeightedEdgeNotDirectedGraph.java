package cu.edu.cujae.ceis.graph.interfaces;

/**
 * Interface para grafos no dirigidos con aristas ponderadas
 */
public interface ILinkedWeightedEdgeNotDirectedGraph extends
		ILinkedNotDirectedGraph {
	public boolean insertWEdgeNDG(int posTail, int posHead, Object weight);
}
