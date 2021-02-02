package cse3041;

class Point {
	private int dimention;
	private double[] coordinate;

	Point(double arr[]) {
		dimention = arr.length;
		coordinate = new double[dimention];
		for (int i = 0; i < dimention; i++)
			coordinate[i] = arr[i];
	}

	public int getDimention() {
		return this.dimention;
	}

	public double getNum(int idx) {
		return this.coordinate[idx];
	}
}

class EuclideanDistance {

	public static double getDist(Point x, Point y) {
		double dist;
		if (x.getDimention() != y.getDimention())
			return -1;
		double sum = 0;
		int n = x.getDimention();
		for (int i = 0; i < n; i++) {
			double tmp = x.getNum(i) - y.getNum(i);
			tmp *= tmp;
			sum += tmp;
		}
		dist = Math.sqrt(sum);
		return dist;
	}
}

class ManhattanDistance {
	public static double getDist(Point x, Point y) {
	
		if (x.getDimention() != y.getDimention())
			return -1;
		double dist = 0;
		int n = x.getDimention();
		for (int i = 0; i < n; i++) {
			double tmp = Math.abs(x.getNum(i) - y.getNum(i));
			dist += tmp;
		}
		
		return dist;
	}
}

public class Level014 {

	public static void main(String[] args) {
		Point p1 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p2 = new Point(new double[] { 4.0, 5.0, 6.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
		Point p3 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p4 = new Point(new double[] { 4.0, 5.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4));
	}
}
