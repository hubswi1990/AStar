package pl.hubswi90.astar;

import java.util.ArrayList;

import pl.hubswi90.heuristics.AStarHeuristics;

public class AStar {
	private Scene map;
	private AStarHeuristics heuristics;

	private ArrayList<Node> closedList;
	private ArrayList<Node> openList;
	private Path path;

	AStar(Scene map, AStarHeuristics heuristics) {
		this.map = map;
		this.heuristics = heuristics;

		closedList = new ArrayList<Node>();
		openList = new ArrayList<>();
	}
	
	public void calculate(int startX, int startY, int goalX, int goalY) {
		calculatePath(startX, startY, goalX, goalY);
		createPath();
	}

	private Path calculatePath(int startX, int startY, int goalX, int goalY) {

		map.setStartPoint(startX, startY);
		map.setEndPoint(goalX, goalY);

		if (map.getNode(goalX, goalY).isObstacle())
			return null;

		map.getStartNode().setDistanceToStart(0);
		closedList.clear();
		openList.clear();
		openList.add(map.getStartNode());

		while (openList.size() != 0) {
			Node current = openList.get(0);

			if (current.getX() == map.getPointEndX()
					&& current.getY() == map.getPointEndY()) {
				return reconstructPath(current);
			}

			openList.remove(current);
			closedList.add(current);

			for (Node neighbor : current.getNeighborList()) {
				boolean isBest;

				if (closedList.contains(neighbor))
					continue;

				if (!neighbor.isObstacle()) {

					float neighborDistanceFromStart = (current
							.getDistanceToStart() + map.getDistance(
							current, neighbor));

					if (!openList.contains(neighbor)) {
						openList.add(neighbor);
						isBest = true;

					} else if (neighborDistanceFromStart < current
							.getDistanceToStart()) {
						isBest = true;
					} else {
						isBest = false;
					}

					if (isBest) {
						
						neighbor.setPreviousNode(current);
						neighbor.setDistanceToStart(neighborDistanceFromStart);
						neighbor.setDistancetoEnd(heuristics.getDistanceToEnd(neighbor.getX(),
										neighbor.getY(), map.getPointEndX(), map.getPointEndY()));
					}
				}

			}

		}
		return null;
	}

	private void createPath() {
		Node n;
		for (int x = 0; x < map.getMapWidth(); x++) {
			for (int y = 0; y < map.getMapHeight(); y++) {
				n = map.getNode(x, y);
				if (n.isObstacle())
					continue;
				else if (n.isStart())
					continue;
				else if (n.isEnd())
					continue;
				else if (path.contains(n.getX(), n.getY()))
					n.setPath(true);
			}
		}
	}

	private Path reconstructPath(Node node) {
		Path path = new Path();
		while (!(node.getPreviousNode() == null)) {
			path.addPointFirst(node);
			node = node.getPreviousNode();
		}
		this.path = path;
		return path;
	}

}
