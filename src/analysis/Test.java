package analysis;

import analysis.dijkstra.CommonDijkstraAlgorithm;
import analysis.graph.Graph;
import analysis.graph.GraphGenerator;

import java.util.Random;

/**
 * Класс для проведения тестирования
 *
 * @author Kolomiets Alexander
 */
public class Test {
	private static final int start = 64;
	private static final int end = 512;
	private static final int step = 32;

	public static void main(String[] args) {
		for (int n = start; n <= end; n += step) {
			int total = 0;
			for (int i = 0; i < 10; i++) {
				Graph graph = GraphGenerator.generateFullGraph(n);

				Random random = new Random();
				int fromVertex = Math.abs(random.nextInt()) % n;
				int toVertex = Math.abs(random.nextInt()) % n;

				CommonDijkstraAlgorithm commonDijkstraAlgorithm = new CommonDijkstraAlgorithm(graph);

				commonDijkstraAlgorithm.getMinPath(fromVertex, toVertex);
				int count = commonDijkstraAlgorithm.getOperationsCount();

				total += count;
			}

			total /= 10;

			System.out.println(n + " " + total);
		}
	}
}
