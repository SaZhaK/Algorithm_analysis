package analysis.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий граф и предоставляющий удобный интерфейс для взаимодействия
 *
 * @author Kolomiets Alexander
 */
public class Graph {
	private int vertexAmount;

	private final List<List<Integer>> bonds;

	public Graph(int vertexAmount) {
		this.vertexAmount = vertexAmount;
		this.bonds = new ArrayList<>(vertexAmount);
		for (int i = 0; i < vertexAmount; i++) {
			List<Integer> row = new ArrayList<>(vertexAmount);
			for (int j = 0; j < vertexAmount; j++) {
				row.add(-1);
			}
			bonds.add(row);
		}
	}

	public int getVerticesAmount() {
		return vertexAmount;
	}

	public void addVertex() {
		for (int i = 0; i < vertexAmount; i++) {
			bonds.get(i).add(-1);
		}
		++this.vertexAmount;
		List<Integer> row = new ArrayList<>(vertexAmount);
		for (int j = 0; j < vertexAmount; j++) {
			row.add(-1);
		}
		bonds.add(row);
	}

	public void removeVertex(int index) {
		for (int i = 0; i < vertexAmount; i++) {
			bonds.get(i).remove(index);
		}
		bonds.remove(index);
		--this.vertexAmount;
	}

	public int getBond(int firstVertex, int secondVertex) {
		return bonds.get(firstVertex).get(secondVertex);
	}

	public int[] getBonds(int firstVertex) {
		return bonds.get(firstVertex).stream().mapToInt(i -> i).toArray();
	}

	public void addBond(int firstVertex, int secondVertex, int weight) {
		bonds.get(firstVertex).set(secondVertex, weight);
	}

	public void addBondSymmetric(int firstVertex, int secondVertex, int weight) {
		bonds.get(firstVertex).set(secondVertex, weight);
		bonds.get(secondVertex).set(firstVertex, weight);
	}

	public void removeBond(int firstVertex, int secondVertex) {
		bonds.get(firstVertex).set(secondVertex, -1);
	}

	public void removeBondSymmetric(int firstVertex, int secondVertex) {
		bonds.get(firstVertex).set(secondVertex, -1);
		bonds.get(secondVertex).set(firstVertex, -1);
	}
}
