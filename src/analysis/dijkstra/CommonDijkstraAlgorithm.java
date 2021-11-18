package analysis.dijkstra;

import analysis.graph.Graph;
import analysis.graph.Vertex;

/**
 * Простая реализация алгоритма Дейкстры на графе, заданном матрицей смежности
 *
 * @author Kolomiets Alexander
 */
public class CommonDijkstraAlgorithm {
	private static final int INFINITY = Integer.MAX_VALUE;

	private int operationsCount;

	private final Graph graph;
	private final Vertex[] vertices;

	public CommonDijkstraAlgorithm(Graph graph) {
		this.graph = graph;
		this.vertices = new Vertex[graph.getVerticesAmount()];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(INFINITY);
		}
	}

	public int getOperationsCount() {
		return operationsCount;
	}

	/**
	 * Функция поиска кратчайшего пути между двумя заданными вершинами
	 *
	 * @param fromVertex начальная вершина
	 * @param toVertex   конечная вершина
	 * @return кратчайшее расстояние
	 */
	public int getMinPath(int fromVertex, int toVertex) {
		vertices[fromVertex].setMinPath(0);
		int curVertex = fromVertex;
		for (int j = 0; j < graph.getVerticesAmount(); j++) {
			int min = INFINITY;
			int minVertex = 0;
			for (int i = 0; i < vertices.length; i++) {
				if (!vertices[i].isChecked() && vertices[i].getMinPath() < min) {
					++operationsCount;
					min = vertices[i].getMinPath();
					minVertex = i;
				}
			}

			int[] pathsFromCurVertex = graph.getBonds(curVertex);
			for (int i = 0; i < pathsFromCurVertex.length; i++) {
				if (pathsFromCurVertex[i] != -1) {
					int path = vertices[curVertex].getMinPath() + pathsFromCurVertex[i];
					if (path < vertices[i].getMinPath()) vertices[i].setMinPath(path);
					++operationsCount;
				}
			}
			vertices[curVertex].setChecked(true);
			curVertex = minVertex;
			++operationsCount;
		}
		return vertices[toVertex].getMinPath();
	}
}
