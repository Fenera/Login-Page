import java.util.HashMap;

public class IDandPasswords {
	
	//create a hashmap with key-value pairs being ID and Password
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	//constructor adds to hashmap
	IDandPasswords(){
		
		//ID and Password combinations are added to the hashmap
		loginInfo.put("Fenera", "123abc");
		loginInfo.put("James", "456def");
		loginInfo.put("Michael", "789ghi");
	}
	
	//access modifier is protected because sensitive information
	//can only be accessed by classes in the same package
	protected HashMap getLoginInfo(){
		return loginInfo;
	}

}
