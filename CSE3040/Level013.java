package cse3041;

class Shape {
	private static double sum = 0;
 
	 public double getArea() { return sum; }
	 
}

class Circle extends Shape {
	private double area;

	Circle(double radius) {
		area = radius * radius * Math.PI;
	}

	public double getArea() {
		return area;
	}
}

class Square extends Shape {
	private double area;

	Square(double a) {
		area = a * a;
	}

	public double getArea() {
		return area;
	}
}

class Rectangle extends Shape {
	private double area;

	Rectangle(double a, double b) {
		area = a * b;
	}

	public double getArea() {
		return area;
	}
}

public class Level013 {

	public static double sumArea(Shape arr[]) {
		double sum = 0;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			System.out.println(i + arr[i].getArea());
			sum += arr[i].getArea();
		}
		return sum;
	}

	public static void main(String args[]) {
		Shape[] arr = { new Circle(5.0), new Square(4.0), new Rectangle(3.0, 4.0), new Square(5.0) };
		System.out.println("Total area of the shapes is: " + sumArea(arr));
	}
}
