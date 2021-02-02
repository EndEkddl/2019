/**
 * CSE3040 HW3
 * Level022.java
 * Purpose: Using jsoup, fetch a URL on the Internet and finds the information we need.
 *
 * @version 1.0 12/13/2019
 * @author InHye Kye
 */
package cse3041;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.select.Elements;

public class Level022 {
	/**
	 * The main method for the Level022 program.
	 *
	 * @param args Not used
	 */
	public static void main(String[] args) {
		String url = "https://www.aladin.co.kr/shop/common/wbest.aspx?BranchType=1&start=we";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Elements bestsellers = doc.select("div.ss_book_list");
		Elements booktitles = bestsellers.select("a.bo3"), juja = bestsellers.select("a[href*=/Search/]");

		Elements tmp = doc.select("div.megaseller_tbox"), tmptmp = tmp.select("input");

		String y = "" + tmptmp.eq(2);
		int s = 0, e = 0;
		//년 출력
		for (int k = 0; k < 3; k++) {
			try {
				s = y.indexOf("value=") + "value=".length();
				e = y.lastIndexOf(">");
			} catch (Exception en) {
			}
		}

		System.out.print("[" + y.substring(s + 1, e - 1) + "년 ");
		//월 출력
		String m = "" + tmptmp.eq(3);
		for (int k = 0; k < 3; k++) {
			try {
				s = m.indexOf("value=") + "value=".length();
				e = m.lastIndexOf(">");
			} catch (Exception en) {
			}
		}
		System.out.print(m.substring(s + 1, e - 1) + "월 ");
		//주 출력
		String w = "" + tmptmp.eq(4);
		for (int k = 0; k < 3; k++) {
			try {
				s = w.indexOf("value=") + "value=".length();
				e = w.lastIndexOf(">");
			} catch (Exception en) {
			}
		}
		System.out.println(w.substring(s + 1, e - 1) + "주]");

		int I = 0;
		for (int i = 0; i < booktitles.size(); i++) {
			//책 제목 출력
			System.out.print(i + 1 + "위: " + booktitles.eq(i).text() + " (");
			int j = 0;
			for (;; j++) {
				String a = "" + juja.eq(I);
				for (int k = 0; k < 3; k++) {
					try {
						s = w.indexOf("value=") + "value=".length();
						e = w.lastIndexOf(">");
					} catch (Exception en) {
					}
				}//지은이 출력
				if (a.indexOf("Author") != -1) {
					if (j == 0)
						System.out.print(juja.eq(I).text());
					I++;
				} else {
					I++;
					break;
				}
			}
			System.out.println(")");
		}
	}
}
