/**
 * CSE3040 HW3
 * Level021.java
 * Purpose: Fetches a URL on the Internet and finds the 50 weekly bestseller books we need.
 *
 * @version 1.0 12/13/2019
 * @author InHye Kye
 */
package cse3041;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Level021 {
	static ArrayList<String> lines = new ArrayList<String>();

	/**
	 * The main method for the Level021 program.
	 *
	 * @param args Not used
	 */
	public static void main(String[] args) throws Exception {
		URL url = null;
		BufferedReader input = null;
		String address = "https://www.aladin.co.kr/shop/common/wbest.aspx?BranchType=1&start=we_tab";
		String line = "";

		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = input.readLine()) != null) {
				if (line.trim().length() > 0)
					lines.add(line);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int rank = 1;
		int status = 0;
		for (int i = 0; i < lines.size(); i++) {

			String l = lines.get(i);
			// 년 출력
			if (l.contains("div class=\"newbs_year\"")) {
				int yBegin = l.indexOf("('Layer_Year')\">") + ("('Layer_Year')\">").length();
				int yEnd = l.indexOf("<img");
				System.out.print("[" + l.substring(yBegin, yEnd) + " ");
			} // 월 출력
			if (l.contains("div class=\"newbs_month\"")) {
				int mBegin = l.indexOf("('Layer_Month')\">") + ("('Layer_Month')\">").length();
				int mEnd = l.indexOf("<img");
				System.out.print(l.substring(mBegin, mEnd) + " ");
			} // 주 출력
			if (l.contains("div class=\"newbs_week\"")) {
				int wBegin = l.indexOf("('Layer_Week')\">") + ("('Layer_Week')\">").length();
				int wEnd = l.indexOf("<img");
				System.out.println(l.substring(wBegin, wEnd) + "]");
			}

			if (status == 0) {
				if (l.contains("div class=\"ss_book_list\""))
					status = 1;
			} else if (status == 1) {
				// 책 제목 출력
				if (l.contains("class=\"bo3\"")) {
					status = 2;
					int begin = l.indexOf("\"bo3\"><b>") + "\"bo3\"><b>".length();
					int end = l.lastIndexOf("</b>");
					System.out.print(rank + "위: " + l.substring(begin, end));
				}
			} else if (status == 2) {
				// 지은이 출력
				if (l.contains("a href")) {
					int k = 0;
					int begin = l.indexOf("<li><a href=") + "<li><a href=".length();
					for (; l.charAt(begin) != '>'; begin++)
						;

					int end = l.indexOf("</a>");
					status = 0;
					System.out.println(" (" + l.substring(begin + 1, end) + ")");
					rank++;
				}

			}

		}
	}
}
