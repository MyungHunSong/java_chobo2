package java_chobo2.ch16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlConnectionEx {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://sports.news.naver.com/news.nhn?oid=139&aid=0002147234");

		try (BufferedReader bor = new BufferedReader
				(new InputStreamReader
						(url.openStream()));

				BufferedWriter bw = new BufferedWriter
						(new OutputStreamWriter
								(new FileOutputStream("test.html")))) { // 이렇게
																														// 삽가능
			String line = null;

			while ((line = bor.readLine()) != null) {
				System.out.println(line);
				bw.newLine();
				
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
