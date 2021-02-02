package cse3041;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

class UserLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	public String toString() {
		String output = "";

		for (Map.Entry<K, V> elem : this.entrySet()) {
			output += elem.getKey() + " " + elem.getValue() + "\n";
		}

		return output;
	}
}


public class Level020 {

	static Map<String, Double> InitializeMap() {

		return new UserLinkedHashMap<String, Double>();
	}

	public static LinkedHashMap<String, Double> sortByValue(Map<String, Double> map) {
		List<String> mapKeys = new ArrayList<>(map.keySet());
		List<Double> mapValues = new ArrayList<>(map.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();

		Iterator<Double> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Double val = valueIt.next();
			Iterator<String> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				String key = keyIt.next();
				Double comp1 = map.get(key);
				Double comp2 = val;

				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}

	static int readDataFromFile(String fileName, Map<String, Double> map) throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			Double price;
			String fruit;
			while ((line = br.readLine()) != null) {
				String[] trimSpace = line.split(" ");
				fruit = trimSpace[0];
				price = Double.parseDouble(trimSpace[1]);
				map.put(fruit, price);
			}

			br.close();
			Map<String, Double> mmap = InitializeMap();
			mmap = sortByValue(map);
			System.out.println(mmap);
			return 0;

		} catch (FileNotFoundException e) {
			return 1;
		}
	}

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
