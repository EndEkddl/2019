package cse3041;

public class Level016 {
	public static void main(String args[]) {
		Text t = new Text();
		t.readTextFromFile("src/cse3040/exercises/input_Level016.txt");
		System.out.println("a: " + t.countChar('a'));
		System.out.println("b: " + t.countChar('b'));
		System.out.println("c: " + t.countChar('c'));
	}
}
