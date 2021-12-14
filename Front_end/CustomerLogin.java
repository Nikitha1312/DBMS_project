import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;


public class CustomerLogin implements ActionListener {
    private JFrame Customer;
    private JTextField txtTypeName; 
    private JPasswordField passwordFiled;
    private JDialog Dialog;
	
    public void setVisible(boolean visible) {
        if (Customer != null) {
        	Customer.setVisible(visible);
        }
    }
    


public CustomerLogin() {
        initialize();
    }

    private void initialize() {
        Customer = new JFrame("OrderRestaurant");
        Customer.getContentPane().setBackground(SystemColor.window);
        Customer.getContentPane().setForeground(Color.BLACK);
        Customer.setTitle("Itsay Dine-IN Login");
        Customer.setBounds(100, 100, 450, 300);
        Customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Customer.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome To Itsay Dine-IN");
        lblWelcome.setForeground(Color.PINK);
        lblWelcome.setBounds(108, 41, 229, 39);
        Customer.getContentPane().add(lblWelcome);

        JLabel lblUser = new JLabel("User Name");
        lblUser.setForeground(Color.BLUE);
        lblUser.setBounds(93, 92, 96, 29);
        Customer.getContentPane().add(lblUser);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLUE);
        lblPassword.setBounds(93, 141, 96, 29);
        Customer.getContentPane().add(lblPassword);

        txtTypeName = new JTextField();
        txtTypeName.setText("Enter Name");
        txtTypeName.setBounds(227, 93, 130, 26);
        Customer.getContentPane().add(txtTypeName);
        txtTypeName.setColumns(10);

        passwordFiled = new JPasswordField();
        passwordFiled.setBounds(227, 142, 130, 26);
        Customer.getContentPane().add(passwordFiled);

	JButton btnReturnButton = new JButton("Return");
		btnReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer.dispose();
				new StartPage().setVisible(true);
			}
		});
		btnReturnButton.setBounds(6, 6, 117, 29);
		Customer.getContentPane().add(btnReturnButton);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        btnLogin.setBounds(72, 206, 117, 29);
        Customer.getContentPane().add(btnLogin);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer.dispose();
	            new Register().setVisible(true);
			}
		});
        btnSignUp.setBounds(260, 206, 117, 29);
        Customer.getContentPane().add(btnSignUp);
        
        

        JLabel lblLobby = new JLabel("lobby");
        lblLobby.setIcon(new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\Pictures\\login.jpeg"));
        lblLobby.setBounds(0, 0, 450, 278);
        Customer.getContentPane().add(lblLobby);

    }

    public void actionPerformed(ActionEvent e){
        

        Connection myConn=null;
    	PreparedStatement myPst=null;
    	ResultSet myRs=null;
    	
    	String url="jdbc:mysql://localhost:3306/Restaurant";
		String user="root";
		String password="Nikki@999";
		String cmd=e.getActionCommand();
        if(cmd.equals("Login")) {
        	
            	try {
                myConn = DriverManager.getConnection(url, user, password);
                
                String sql= "SELECT *FROM `Restaurant`.`Register`" 
    					+"WHERE `UserName`=? AND `Password`=?";
                
                myPst =myConn.prepareStatement(sql);
                myPst.setString(1,txtTypeName.getText());
                myPst.setString(2,passwordFiled.getText());
                myRs=myPst.executeQuery();
               
                if(myRs.next()){
                	try{
		                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","Nikki@999");
		                
		                String sql1= "INSERT INTO `Restaurant`.`OrderFood`" 
	        					+"(`UserName`)"
	        					+"VALUES (?)";
	                    
	                    PreparedStatement Pst =Conn.prepareStatement(sql1);
	                    Pst.setString(1,txtTypeName.getText());
	                  
	               
	                    Pst.executeUpdate();
                	}catch(Exception ex){
		                ex.printStackTrace();
		            }
        
                	JOptionPane.showMessageDialog(Dialog, "Welcome Back!", "",JOptionPane.INFORMATION_MESSAGE);
                	Customer.dispose();
                    new FoodMenu().setVisible(true);
                    myPst.close();
                    myConn.close();
                    
                }
                else{
                
                	JOptionPane.showMessageDialog(Dialog, "The User Name or Password is incorrect. Please try again.", "",JOptionPane.WARNING_MESSAGE);
                }
               
        }catch (Exception exc) {
        	exc.printStackTrace();
        }
        	}
 
}	
}
 
