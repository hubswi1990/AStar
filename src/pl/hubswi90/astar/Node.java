package pl.hubswi90.astar;

import java.util.ArrayList;

public class Node {

	private Node north, northEast, northWest, east, southEast, south, southWest, west;
	private Node previousNode;
	private ArrayList<Node> neighborList;
	private float distanceToStart;
	private float distancetoEnd;
	private int x;
	private int y;
	private boolean isVisited;
	private boolean isObstacle;
	private boolean isStart;
	private boolean isEnd;
	private boolean isPath;

	Node(int x, int y) {
		neighborList = new ArrayList<Node>();
		this.x = x;
		this.y = y;
		this.isVisited = false;
		this.distanceToStart = 300000;
		this.isObstacle = false;
		this.isStart = false;
		this.isEnd = false;
		this.isPath = false;
	}

	Node(int x, int y, boolean isVisited, int distanceToStart,
			boolean isObstacle, boolean isStart, boolean isEnd, boolean isPath) {
		neighborList = new ArrayList<Node>();
		this.x = x;
		this.y = y;
		this.isVisited = isVisited;
		this.distanceToStart = distanceToStart;
		this.isObstacle = isObstacle;
		this.isStart = isStart;
		this.isEnd = isEnd;
		this.isPath = isPath;
	}

	public Node getNorth() {
		return north;
	}

	public void setNorth(Node north) {
		if (neighborList.contains(this.north))
			neighborList.remove(this.north);
		neighborList.add(north);
		this.north = north;
	}

	public Node getNorthEast() {
		return northEast;
	}

	public void setNorthEast(Node northEast) {
		if (neighborList.contains(this.northEast))
			neighborList.remove(this.northEast);
		neighborList.add(northEast);
		this.northEast = northEast;
	}

	public Node getEast() {
		return east;
	}

	public void setEast(Node east) {
		if (neighborList.contains(this.east))
			neighborList.remove(this.east);
		neighborList.add(east);
		this.east = east;
	}

	public Node getSouthEast() {
		return southEast;
	}

	public void setSouthEast(Node southEast) {
		if (neighborList.contains(this.southEast))
			neighborList.remove(this.southEast);
		neighborList.add(southEast);
		this.southEast = southEast;
	}

	public Node getSouth() {
		return south;
	}

	public void setSouth(Node south) {
		if (neighborList.contains(this.south))
			neighborList.remove(this.south);
		neighborList.add(south);
		this.south = south;
	}

	public Node getSouthWest() {
		return southWest;
	}

	public void setSouthWest(Node southWest) {
		if (neighborList.contains(this.southWest))
			neighborList.remove(this.southWest);
		neighborList.add(southWest);
		this.southWest = southWest;
	}

	public Node getWest() {
		return west;
	}

	public void setWest(Node west) {
		if (neighborList.contains(this.west))
			neighborList.remove(this.west);
		neighborList.add(west);
		this.west = west;
	}

	public Node getNorthWest() {
		return northWest;
	}

	public void setNorthWest(Node northWest) {
		if (neighborList.contains(this.northWest))
			neighborList.remove(this.northWest);
		neighborList.add(northWest);
		this.northWest = northWest;
	}

	public ArrayList<Node> getNeighborList() {
		return neighborList;
	}

	public float getDistanceToStart() {
		return distanceToStart;
	}

	public void setDistanceToStart(float distanceToStart) {
		this.distanceToStart = distanceToStart;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}

	public float getDistancetoEnd() {
		return distancetoEnd;
	}

	public void setDistancetoEnd(float distancetoEnd) {
		distancetoEnd = distancetoEnd;
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean isPath() {
		return isPath;
	}

	public void setPath(boolean isPath) {
		this.isPath = isPath;
	}

}
