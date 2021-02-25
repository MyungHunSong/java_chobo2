package java_chobo2.ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiseEx {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("url", "jdbc:mysql://localhost:3306/mysql_study?useSSL=false");  //
		
		prop.setProperty("user", "user_mysql_study");
		prop.setProperty("password", "rootroot");
		
		//file 저장
		try {
			prop.store(new FileOutputStream("oupt.txt"), "Properties Example");
			prop.store(new FileWriter("output2.properties"), "Properties Example");
			
			prop.storeToXML(new FileOutputStream("oupt.xml"), "Properties Example", "UTF-8");
			// xml 파일
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} //oupt.txt 가 텍스트 이름, 오른쪽 comment 파일이름이다
		
		//file로 부터 로드
		Properties loadProp = new Properties();
		Properties xmlProp = new Properties();
		try {
			loadProp.load(new FileInputStream("oupt.txt"));
			
			prnProperties(loadProp);
			
		
			prnProperties(xmlProp);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private static void prnProperties(Properties loadProp) {// 이게 불러오는 방법중 하나다 천천히 바라 부담같지 말고
		Set<Object> keys = loadProp.keySet();
		for(Object key : keys) {
			System.out.println(key + " : " + loadProp.getProperty((String) key));
		}
		
	}

}
