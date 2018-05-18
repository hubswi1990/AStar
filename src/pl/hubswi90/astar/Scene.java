package pl.hubswi90.astar;

import java.util.ArrayList;

public class Scene {

	private int mapWidth;
	private int mapHeight;
	private ArrayList<ArrayList<Node>> map;
	private int pointStartX = 0;
	private int pointStartY = 0;
	private int pontEndX = 0;
	private int pointEndY = 0;
	private int[][] sceneTab;

	Scene(int mapWith, int mapHeight, int[][] przeszkodyTab) {
		this.mapWidth = mapWith;
		this.mapHeight = mapHeight;
		this.sceneTab = przeszkodyTab;

		createMap();
		getNeighbor();
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	private void createMap() {
		Node n;
		map = new ArrayList<ArrayList<Node>>();
		for (int x = 0; x < mapWidth; x++) {
			map.add(new ArrayList<Node>());
			for (int y = 0; y < mapHeight; y++) {
				n = new Node(x, y);
				if (sceneTab[x][y] == 1)
					n.setObstacle(true);
				map.get(x).add(n);
			}
		}
	}

	private void getNeighbor() {
		for (int x = 0; x < mapWidth - 1; x++) {
			for (int y = 0; y < mapHeight - 1; y++) {
				Node n = map.get(x).get(y);
				if (!(y == 0))
					n.setNorth(map.get(x).get(y - 1));
				if (!(y == 0) && !(x == mapWidth))
					n.setNorthEast(map.get(x + 1).get(y - 1));
				if (!(x == mapWidth))
					n.setEast(map.get(x + 1).get(y));
				if (!(x == mapWidth) && !(y == mapHeight))
					n.setSouthEast(map.get(x + 1).get(y + 1));
				if (!(y == mapHeight))
					n.setSouth(map.get(x).get(y + 1));
				if (!(x == 0) && !(y == mapHeight))
					n.setSouthWest(map.get(x - 1).get(y + 1));
				if (!(x == 0))
					n.setWest(map.get(x - 1).get(y));
				if (!(x == 0) && !(y == 0))
					n.setNorthWest(map.get(x - 1).get(y - 1));
			}
		}
	}

	public Node getNode(int x, int y) {
		return map.get(x).get(y);
	}

	public void setStartPoint(int x, int y) {
		map.get(x).get(y).setStart(true);
		pointStartX = x;
		pointStartY = y;
	}

	public void setEndPoint(int x, int y) {
		map.get(x).get(y).setEnd(true);
		pontEndX = x;
		pointEndY = y;
	}
	
	public Node getStartNode() {
		return map.get(pointStartX).get(pointStartY);
	}

	public int getPointEndX() {
		return pontEndX;
	}

	public int getPointEndY() {
		return pointEndY;
	}

	public float getDistance(Node node1, Node node2) {
		if (node1.getX() == node2.getX() || node1.getY() == node2.getY()) {
			return 10;
		} else { 
			return 14;
		}
	}
}
