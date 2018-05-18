package pl.hubswi90.astar;

import java.util.ArrayList;

public class Path {

	private ArrayList<Node> pointPath;

	public Path() {
		pointPath = new ArrayList<Node>();
	}

	public Node getPointPath(int index) {
		return pointPath.get(index);
	}

	public void addPointToPath(Node n) {
		pointPath.add(n);
	}

	public void addPointFirst(Node n) {
		pointPath.add(0, n);
	}

	public int getPointPathX(int index) {
		return getPointPath(index).getX();
	}

	public int getPointPathY(int index) {
		return getPointPath(index).getY();
	}

	public boolean contains(int x, int y) {
		for (Node n : pointPath) {
			if (n.getX() == x && n.getY() == y)
				return true;
		}
		return false;
	}

}
