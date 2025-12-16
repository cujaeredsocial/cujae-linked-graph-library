package cu.edu.cujae.ceis.graph.interfaces;

/**
 * Interface para grafos no dirigidos con vértices ponderados
 */
public interface ILinkedWeightedVertexNotDirectedGraph extends
		ILinkedNotDirectedGraph {
	public boolean insertWVertex(Object info, Object weight);
}
