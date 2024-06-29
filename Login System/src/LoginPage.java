
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class LoginPage implements ActionListener{
	
	//instantiate GUI and buttons
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JLabel userIDLabel = new JLabel("userID:");
	JTextField userIDField = new JTextField();
	JPasswordField userPwField = new JPasswordField();
	JLabel userPwLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("TEST");
	
	/*Initialize a hashmap that will store 
	 * a copy of OG login info that is globally available in this file*/
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	LoginPage(HashMap<String, String> OGLoginInfo){
		
		loginInfo = OGLoginInfo;
		
		//choose label placement location(X, Y, W, H).
		userIDLabel.setBounds(50, 100, 75, 25);
		userPwLabel.setBounds(50, 150, 75, 25);
		messageLabel.setBounds(125, 250, 200, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		//text field placement
		userIDField.setBounds(125, 100, 200, 25);
		userPwField.setBounds(125, 150, 200, 25);
		
		//login button placement
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		//reset button placement
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		
		
		//place label/text fields/buttons on window
		frame.add(userIDLabel);
		frame.add(userPwLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPwField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		//set frame settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	//method to handle events
	@Override
	public void actionPerformed(ActionEvent e) {

		//find source of action
		if(e.getSource()==resetButton) {
			//clears ID field and password field
			userIDField.setText("");
			userPwField.setText("");
			messageLabel.setText("");
		}
		if(e.getSource() == loginButton) {
			//extracts text from userID field and PW field
			String userID = userIDField.getText();
			//retrieves PW and converts to string bc PW is in form ....
			String password = String.valueOf(userPwField.getPassword());
			/*
			KEY: loginInfo is the copy hashmap w/ ID and PW
			verification(key = userID val = PW)
			if.1 = checks if loginInfo contains that userID
			if.2 = checks if the corresponding value to that key is the one
			the user entered
			*/
			if(loginInfo.containsKey(userID)) {
				
				if(loginInfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login Successful");
					//closes frame
					frame.dispose();
					//create welcome page constructor which opens new window
					WelcomePage welcomePage = new WelcomePage(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");

				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
	}

}
