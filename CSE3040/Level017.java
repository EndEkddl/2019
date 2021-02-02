/**
 * CSE3040 HW3
 * Level017.java
 * Purpose: Read data from file and prints out a summary of data. 
 *
 * @version 1.0 12/13/2019
 * @author InHye Kye
 */
package cse3041;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Level017 {
	/**
	 * The main method for the Level017 program.
	 * �Է¹��� ���ϸ�� ��ġ�ϴ� ������ ã�� ���ϰ� ������ ������ �����Ѵ�. ���ϸ�� ��ġ�ϴ� ������ ���ٸ� ���� �޼����� ����Ѵ�.
	 *
	 * @param args Not used
	 */
	public static void main(String args[]) throws IOException {
		String[] fruit = new String[1000];
		float[] price = new float[1000];
		int i = 0;
		int min = 0, max = 0;
		float avg = 0;
		// ������ �о� ���ϰ� ������ �����Ѵ�.
		try {
			BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] trimSpace = line.split(" ");
				fruit[i] = trimSpace[0];
				price[i++] = Float.parseFloat(trimSpace[1]);
			}
			br.close();
			// ���� �� ���� Ž��
			float x = 100000000, y = 0, sum = 0;
			for (int j = 0; j < i; j++) {
				if (price[j] < x) {
					x = price[j];
					min = j;
				} // ���� ������ �� ����
				sum += price[j];
			}
			// ���� ��� ���� Ž��
			for (int k = 0; k < i; k++) {
				if (price[k] > y) {
					y = price[k];
					max = k;
				}
			}
			avg = sum / i;
			System.out.println("Summary");
			System.out.println("-------");
			System.out.println("number of items: " + i);
			System.out.println("most expensive item: " + fruit[max] + " (" + price[max] + ")");
			System.out.println("cheapest item: " + fruit[min] + " (" + price[min] + ")");
			System.out.println("average price of items: " + Math.round(avg * 100) / 100.0);
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found!");
			e.printStackTrace();
		}

	}
}
