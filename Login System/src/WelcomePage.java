import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

//login-success
public class WelcomePage {

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello");
	
	WelcomePage(String userID){
		
		//set label location
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
		welcomeLabel.setText("Hello " + userID);
				
				
		//initialize frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(welcomeLabel);
		
		
		
	}
}
