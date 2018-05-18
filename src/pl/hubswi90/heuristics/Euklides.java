package pl.hubswi90.heuristics;

public class Euklides implements AStarHeuristics {

	public float getDistanceToEnd(int startX, int startY, int goalX, int goalY) {
		float dx = goalX - startX;
		float dy = goalY - startY;

		return (float) (dx * dx) + (dy * dy);
	}

}
