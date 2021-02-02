package cse3041;

import java.util.Scanner;

interface IntSequenceStr {
	boolean hasNext();

	int next();
}


class BinarySequenceStr implements IntSequenceStr {
	private int number;
	BinarySequenceStr(int n){
		number = n;
	}
	public boolean hasNext() {
		return number != 0;
	}

	public int next() {
		int result = number % 2;
		number /= 2;
		return result;
	}
}
public class Level012 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		String str = in.nextLine();
		int num = Integer.parseInt(str);
		in.close();
		System.out.println("Integer: " + num);
		IntSequenceStr seq = new BinarySequenceStr(num);
		System.out.print("Binary number: ");
		while (seq.hasNext())
			System.out.print(seq.next());
		
		System.out.println("");
	}
}
