package analysis.graph;

import java.util.Random;

/**
 * Класс, предоставляющий возможность генерации графов
 *
 * @author Kolomiets Alexander
 */
public class GraphGenerator {
	private static final int MAX_WEIGHT = 999999;

	/**
	 * Метод для генерации случайного графа с заданным количеством вершин
	 * и количеством связей, не превышающим указанное число
	 *
	 * @param verticesAmount количество вершин
	 * @param bondsAmount    верхняя граница количества вершин
	 * @return случайны граф
	 */
	public static Graph generateRandomGraph(int verticesAmount, int bondsAmount) {
		Random random = new Random();

		Graph graph = new Graph(verticesAmount);
		for (int i = 0; i < bondsAmount; i++) {
			int firstVertex = Math.abs(random.nextInt()) % verticesAmount;
			int secondVertex = Math.abs(random.nextInt()) % verticesAmount;
			int weight = Math.abs(random.nextInt()) % MAX_WEIGHT;
			graph.addBond(firstVertex, secondVertex, weight);
		}
		return graph;
	}

	/**
	 * Метод для генерации полного графа с заданным количеством вершин
	 *
	 * @param verticesAmount количество вершин
	 * @return полный граф
	 */
	public static Graph generateFullGraph(int verticesAmount) {
		Random random = new Random();

		Graph graph = new Graph(verticesAmount);
		for (int i = 0; i < verticesAmount; i++) {
			for (int j = 0; j < verticesAmount; j++) {
				int weight = Math.abs(random.nextInt()) % MAX_WEIGHT;
				graph.addBond(i, j, weight);
			}
		}
		return graph;
	}
}
