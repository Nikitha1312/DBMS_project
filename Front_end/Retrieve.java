import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Label;

public class Retrieve {

	private JFrame Retrieve;
	private JTextField textFieldNumber;

	 public void setVisible(boolean visible) {
	        if (Retrieve != null) {
	        	Retrieve.setVisible(visible);
	        }
	    }

	public Retrieve() {
		initialize();
	}

	private void initialize() {
		Retrieve = new JFrame("Retrieve Food Image");
	    Retrieve.setBounds(250, 250, 700, 680);
		Retrieve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Retrieve.getContentPane().setLayout(null);
		Retrieve.getContentPane().setBackground(Color.decode("#ffff99"));
		
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(111, 51, 551, 244);
		Retrieve.getContentPane().add(lblImage);
		
		JLabel lblFoodPrice = new JLabel("Food Price:");
		lblFoodPrice.setForeground(Color.YELLOW);
		lblFoodPrice.setBounds(203, 200, 107, 29);
		Retrieve.getContentPane().add(lblFoodPrice);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setBounds(369, 200, 130, 29);
		Retrieve.getContentPane().add(lblPrice);
		
		JLabel lblFoodName = new JLabel("Food Name :");
		lblFoodName.setForeground(Color.YELLOW);
		lblFoodName.setBounds(203, 150, 107, 11);
		Retrieve.getContentPane().add(lblFoodName);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(369, 150, 117, 26);
		Retrieve.getContentPane().add(lblName);
		
		Label labelDescription = new Label("");
		labelDescription.setBounds(110,290,450, 45);
		Retrieve.getContentPane().add(labelDescription);
		
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	            try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","password");
	                Statement mySt = myConn.createStatement();
	                ResultSet myRs = mySt.executeQuery("select * from menu where FoodID = '"+textFieldNumber.getText()+"'");
	                if(myRs.next()){
	                    byte[] img = myRs.getBytes("FoodImage");
	                    ImageIcon image = new ImageIcon(img);
	                    Image im = image.getImage();
	                    Image myImg = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    lblImage.setIcon(newImage);
	                    
	                    lblPrice.setText(myRs.getString("FoodPrice"));
	                    lblPrice.setForeground(Color.yellow);
	                    lblName.setText(myRs.getString("FoodName"));
	                    lblName.setForeground(Color.yellow);
	                    labelDescription.setText(myRs.getString("Description"));
	                    lblPrice.setForeground(Color.yellow);
	                    
	                    
	                }
	                
	                else{
	                    JOptionPane.showMessageDialog(null, "Please Enter Correct Number");
	                }
	            }catch(Exception ex){
	                ex.printStackTrace();
	            }
	        
			}
		});
		btnRetrieve.setBounds(160, 350, 117, 29);
		Retrieve.getContentPane().add(btnRetrieve);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setText("Enter Number");
		textFieldNumber.setBounds(350,350, 130, 26);
		Retrieve.getContentPane().add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		
		JLabel lblCollection = new JLabel("");
		int width=542,height=216;
		ImageIcon image = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\Pictures\\FoodList.png");
        image.setImage(image.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
		lblCollection.setIcon(image);
		lblCollection.setSize(width,height);
        lblCollection.setBounds(85,390, 551, 215);
		Retrieve.getContentPane().add(lblCollection);
		
		JButton btnReturnButton = new JButton("Return");
		btnReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retrieve.dispose();
				new StartPage().setVisible(true);
			}
		});
		btnReturnButton.setBounds(6, 6, 117, 29);
		Retrieve.getContentPane().add(btnReturnButton);
		
	
		
		JLabel lblWallpaper = new JLabel(" ");
		lblWallpaper.setBounds(0, 0, 750, 678);
		lblWallpaper.setIcon(new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\Pictures\\retrievepage.jpeg"));
		Retrieve.getContentPane().add(lblWallpaper);	
	
		
	}
}
