package cse3041;

interface IntSequence {
	boolean hasNext();

	int next();
}

class FibonacciSequence implements IntSequence {
	private static int a = 0, b = 1, n = 0;

	public boolean hasNext() {
		return true;
	}

	public int next() {
		n++;
		if (n == 1)
			return a;
		if(n==2) return b;
		int tmp = a;
		a = b;
		b += tmp;
		return b;
		
	}
}

public class Level011 {
	public static void main(String[] args) {
		IntSequence seq = new FibonacciSequence();
		for (int i = 0; i < 20; i++) {
			if (seq.hasNext() == false)
				break;
			System.out.print(seq.next() + " ");
		}
		System.out.println(" ");
	}
}