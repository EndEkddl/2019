/**
 * CSE3040 HW3
 * Level018.java
 * Purpose: read data from file and prints out the data in a sorted order.
 *
 * @version 1.0 12/13/2019
 * @author InHye Kye
 */
package cse3041;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Element implements Comparable<Element> {
	String fruit = new String();
	Float price;

	// constructor
	public Element(String fruit, float price) {
		this.fruit = fruit;
		this.price = price;
	}

	public float getPrice() {
		return this.price;
	}

	public String getFruit() {
		return this.fruit;
	}

	/**
	 * 정해진 형식에 맞게 출력하도록 한다.
	 * 
	 * @return Formated String.
	 */

	@Override
	public String toString() {
		return this.fruit + " " + this.price;
	}

	/**
	 * 가격을 먼저 비교하고 가격이 같으면 과일 이름으로 비교한다.
	 * 
	 * @return 비교 결과
	 */

	@Override
	public int compareTo(Element x) {
		if (this.price < x.getPrice()) {
			return -1;
		} else if (this.price > x.getPrice()) {
			return 1;
		} else {
			return this.fruit.compareTo(x.getFruit());
		}

	}
}

public class Level018 {
	/**
	 * 입력받은 파일명과 일치하는 파일을 찾아 과일과 가격의 정보를 저장한다. 파일명과 일치하는 파일이 없다면 오류 메세지를 출력한다.
	 * 
	 * @return 데이터 읽기 성공 여부
	 */
	static int readDataFromFile(String fileName, ArrayList<Element> list) throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			Float price;
			String fruit;
			while ((line = br.readLine()) != null) {
				// 공백을 기준으로 자른 문자열을 fruit과 price에 각각 저장한다.
				String[] trimSpace = line.split(" ");
				fruit = trimSpace[0];
				price = Float.parseFloat(trimSpace[1]);
				Element temp = new Element(fruit, price);
				list.add(temp);
			}
			br.close();

			return 0;

		} catch (FileNotFoundException e) {
			return 1;
		}
	}

	/**
	 * The main method for the Level018 program.
	 *
	 * @param args Not used
	 */
	public static void main(String args[]) throws IOException {
		ArrayList<Element> list = new ArrayList<>();
		int rv = readDataFromFile("./input.txt", list);
		if (rv == 1) {
			System.out.println("input file not found!");
			return;
		}
		Collections.sort(list);
		Iterator<Element> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());

	}
}
