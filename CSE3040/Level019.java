/**
 * CSE3040 HW3
 * Level019.java
 * Purpose: Using map, read data from file and prints out the data in a sorted order.
 *
 * @version 1.0 12/13/2019
 * @author InHye Kye
 */
package cse3041;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

class UserTreeMap<K, V> extends TreeMap<K, V> {
	/**
	 * ������ ���Ŀ� �°� ����ϵ��� �Ѵ�.
	 * 
	 * @return Formated String.
	 */
	public String toString() {
		String output = "";

		for (Map.Entry<K, V> elem : this.entrySet()) {
			output += elem.getKey() + " " + elem.getValue() + "\n";
		}
		return output;
	}
}

public class Level019 {
	/**
	 * UserTreeMap�� ��ü�� �����Ѵ�.
	 *
	 * @return A UserTreeMap
	 */
	static Map<String, Double> InitializeMap() {
		return new UserTreeMap<String, Double>();
	}

	/**
	 * �Է¹��� ���ϸ�� ��ġ�ϴ� ������ ã�� ���ϰ� ������ ������ �����Ѵ�. ���ϸ�� ��ġ�ϴ� ������ ���ٸ� ���� �޼����� ����Ѵ�.
	 * 
	 * @return ������ �б� ���� ����
	 */
	static int readDataFromFile(String fileName, Map<String, Double> map) throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			Double price;
			String fruit;
			// ������ �������� �ڸ� ���ڿ��� fruit�� price�� ���� �����Ѵ�.
			while ((line = br.readLine()) != null) {
				String[] trimSpace = line.split(" ");
				fruit = trimSpace[0];
				price = Double.parseDouble(trimSpace[1]);
				map.put(fruit, price);
			}

			br.close();

			return 0;

		} catch (FileNotFoundException e) {
			return 1;
		}
	}

	/**
	 * The main method for the Level019 program.
	 *
	 * @param args Not used
	 */
	public static void main(String[] args) throws Exception {

		Map<String, Double> map = InitializeMap();
		int rv = readDataFromFile("./input.txt", map);
		if (rv == 1) {
			System.out.println("input file not found!");
			return;
		}

		System.out.println(map);
	}

}
