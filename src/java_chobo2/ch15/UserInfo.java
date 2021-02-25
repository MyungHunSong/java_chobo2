package java_chobo2.ch15;

import java.io.Serializable;


public class UserInfo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 922167899509951820L;
	
	
	private String name;
	private String password;
	private int age;
	
	
	public UserInfo() {
		this("UnKnown", "1111", 0); // 이걸로 초기화 안그러면 외부에서 받은걸로 초기화
	}


	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}


	@Override
	public String toString() {
		return String.format("UserInfo [%s, %s, %s]", name, password, age);
	}
	
	
	
}
