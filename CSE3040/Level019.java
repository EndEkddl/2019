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
	 * 정해진 형식에 맞게 출력하도록 한다.
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
	 * UserTreeMap의 객체를 생성한다.
	 *
	 * @return A UserTreeMap
	 */
	static Map<String, Double> InitializeMap() {
		return new UserTreeMap<String, Double>();
	}

	/**
	 * 입력받은 파일명과 일치하는 파일을 찾아 과일과 가격의 정보를 저장한다. 파일명과 일치하는 파일이 없다면 오류 메세지를 출력한다.
	 * 
	 * @return 데이터 읽기 성공 여부
	 */
	static int readDataFromFile(String fileName, Map<String, Double> map) throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			Double price;
			String fruit;
			// 공백을 기준으로 자른 문자열을 fruit과 price에 각각 저장한다.
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
