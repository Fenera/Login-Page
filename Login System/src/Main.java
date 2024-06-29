
public class Main {
	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		
		//created obj
		IDandPasswords idandPasswords = new IDandPasswords();
		
		//pass login info hashmap as argument to LoginPage constructor
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
		
		
	}

}
