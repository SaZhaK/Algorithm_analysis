package analysis.graph;

/**
 * Класс, реализующий вершину графа и предоставляющий удобный интерфейс для взаимодействия
 *
 * @author Kolomiets Alexander
 */
public class Vertex implements Comparable<Vertex> {
	private boolean checked = false;
	private int minPath;

	public Vertex(int minPath) {
		this.minPath = minPath;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getMinPath() {
		return minPath;
	}

	public void setMinPath(int minPath) {
		this.minPath = minPath;
	}

	@Override
	public int compareTo(Vertex vertex) {
		return vertex.minPath - this.minPath;
	}
}
