package analysis.dijkstra;

import analysis.graph.Graph;
import analysis.graph.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Реализация алгоритма Дейкстры с использованием приоритетной очереди (кучи)
 * на графе, заданном матрицей смежности
 *
 * @author Kolomiets Alexander
 */
public class PriorityQueueDijkstraAlgorithm {
	private static final int INFINITY = Integer.MAX_VALUE;

	private final Graph graph;
	private final List<Vertex> vertices;

	public PriorityQueueDijkstraAlgorithm(Graph graph) {
		this.graph = graph;
		this.vertices = new ArrayList<>();
		for (int i = 0; i < graph.getVerticesAmount(); i++) {
			vertices.add(new Vertex(INFINITY));
		}
	}

	/**
	 * Функция поиска кратчайшего пути между двумя заданными вершинами
	 *
	 * @param fromVertex начальная вершина
	 * @param toVertex   конечная вершина
	 * @return кратчайшее расстояние
	 */
	public int getMinPath(int fromVertex, int toVertex) {
		PriorityQueue<Vertex> tree = new PriorityQueue<>();
		vertices.get(fromVertex).setMinPath(0);
		Vertex curVertex = vertices.get(fromVertex);
		tree.add(curVertex);

		for (int j = 0; j < graph.getVerticesAmount(); j++) {
			int[] pathsFromCurVertex = graph.getBonds(vertices.indexOf(curVertex));
			for (int i = 0; i < pathsFromCurVertex.length; i++) {
				if (pathsFromCurVertex[i] != -1) {
					int path = curVertex.getMinPath() + pathsFromCurVertex[i];
					if (path < vertices.get(i).getMinPath()) {
						vertices.get(i).setMinPath(path);
					}
					tree.add(vertices.get(i));
				}
			}
			curVertex.setChecked(true);
			curVertex = tree.remove();
		}
		return vertices.get(toVertex).getMinPath();
	}
}
