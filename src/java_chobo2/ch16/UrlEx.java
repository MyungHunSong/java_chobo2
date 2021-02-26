package java_chobo2.ch16;

import java.io.IOException;

import java.net.URISyntaxException;
import java.net.URL;

public class UrlEx {

	public static void main(String[] args) throws Exception  {
	// URL url = new URL("http://www.codechobo.com:80/sample/" + "hello.html?referer=codechobo#index1");
		
		
		String adress = ("https://post.naver.com/viewer/postView.nhn?volumeNo=30216872");
		
		URL url1 = new URL(adress);
		
		
		System.out.println("url.getAuthority() :" + url1.getAuthority());
		System.out.println("url.getContent() : " + url1.getContent());
		System.out.println("url.getDefaultPort() : " + url1.getDefaultPort());
		System.out.println("url.getPort() : " + url1.getPort());
		System.out.println("url.getFile() : " + url1.getFile());
		System.out.println("url.getHost() : " + url1.getHost());
		System.out.println("url.getPath() : " + url1.getPath());
		System.out.println("url.getProtocol() : " + url1.getProtocol());
		System.out.println("url.getQuery() : " + url1.getQuery());
		System.out.println("url.getRef() : " + url1.getRef());
		System.out.println("url.getUserInfo() : " + url1.getUserInfo());
		System.out.println("url.toExternalForm() : " + url1.toExternalForm());
		System.out.println("url.toURI() : " + url1.toURI());
		

	}

}
