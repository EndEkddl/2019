package cse3041;

class Point {
	private int dimention;
	private int sum = 0;

	Point(double arr[]) {
		dimention = arr.length;

		for (int i = 0; i < dimention; i++)
			sum += arr[i];
	}

	public String toString() {
		if (this == null)
			return "null";
		return "[sum of points: " + sum + "]";
	}

	public boolean equals(Point x) {
		if (this == x)
			return true;
		if (x == null)
			return false;
		return (this.sum == x.sum);
	}
}

public class Level015 {
	public static void main(String[] args) {
		Points p1 = new Points(new double[] { 1.0, 2.0, 3.0 });
		Points p2 = new Points(new double[] { 4.0, 5.0, 6.0 });
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));
		Points p3 = new Points(new double[] { 1.0, 4.0, 7.0 });
		Points p4 = new Points(new double[] { 3.0, 9.0 });
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p3.equals(p4));
		Points p5 = new Points(new double[] { 1.0, 2.0 });
		Points p6 = null;
		System.out.println(p5);
		System.out.println(p6);
		System.out.println(p5.equals(p6));
	}

}
