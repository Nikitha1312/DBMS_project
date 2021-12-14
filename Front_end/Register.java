import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.sql.* ;


public  class Register {
    private JFrame AccountRegister = null;
    private JDialog Dialog;
    private JTextField textFieldName=new JTextField();
    private JTextField textFieldBirthday=new JTextField();
    private JTextField textFieldEmail=new JTextField();
    private JPasswordField passwordField=new JPasswordField();
    private JTextField textFieldAddress=new JTextField();
    private JTextField textFieldCellPhone=new JTextField();
    


    public void setVisible(boolean visible) {
        if (AccountRegister != null) {
            AccountRegister.setVisible(visible);
        }
    }

    public Register() {
		initialize();
	}
	private void initialize() {
        AccountRegister = new JFrame("Create new account");
        AccountRegister.setBounds(100, 100, 450, 500);
        AccountRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AccountRegister.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("User Name");
        lblName.setForeground(Color.BLACK);
        lblName.setBounds(33, 89, 75, 21);
        AccountRegister.getContentPane().add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(116, 86, 130, 26);
        AccountRegister.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblBirthday = new JLabel("Birthday");
        lblBirthday.setForeground(Color.BLACK);
        lblBirthday.setBounds(33, 122, 61, 23);
        AccountRegister.getContentPane().add(lblBirthday);

        textFieldBirthday = new JTextField();
        textFieldBirthday.setBounds(116, 120, 130, 26);
        AccountRegister.getContentPane().add(textFieldBirthday);
        textFieldBirthday.setColumns(10);
        
        JLabel lblDateFormat = new JLabel("(yyyy-mm-dd)");
        lblDateFormat.setForeground(Color.BLACK);
        lblDateFormat.setBounds(268, 123, 92, 21);
        AccountRegister.getContentPane().add(lblDateFormat);
        
        JLabel lblCellPhone = new JLabel("Cell Phone");
        lblCellPhone.setForeground(Color.BLACK);
        lblCellPhone.setBounds(33, 157, 75, 21);
        AccountRegister.getContentPane().add(lblCellPhone);
        
        textFieldCellPhone = new JTextField();
        textFieldCellPhone.setBounds(116, 155, 130, 26);
        AccountRegister.getContentPane().add(textFieldCellPhone);
        textFieldCellPhone.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBounds(33, 198, 61, 16);
        AccountRegister.getContentPane().add(lblEmail);
        
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(116, 193, 130, 26);
        AccountRegister.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBounds(33, 236, 61, 16);
        AccountRegister.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(116, 231, 130, 26);
        AccountRegister.getContentPane().add(passwordField);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(Color.BLACK);
        lblAddress.setBounds(33, 273, 61, 16);
        AccountRegister.getContentPane().add(lblAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(115, 265, 310, 33);
        AccountRegister.getContentPane().add(textFieldAddress);
        textFieldAddress.setColumns(10);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(new ActionListener() {
      
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
        		String url="jdbc:mysql://localhost:3306/Restaurant";
        		String user="root";
        		String password="Nikki@999";
            		 
                	try {
                    Connection myConn = DriverManager.getConnection(url, user, password);
                    
                    String sql= "INSERT INTO `Restaurant`.`Register`" 
        					+"(`UserName`, `Birthday`,`CellPhone`, `Email`, `Password`,`Address`)"
        					+"VALUES (?,?,?,?,?,?)";
                    
                    PreparedStatement myPst =myConn.prepareStatement(sql);
                    myPst.setString(1,textFieldName.getText());
                    myPst.setString(2,textFieldBirthday.getText());
                    myPst.setString(3,textFieldCellPhone.getText());
                    myPst.setString(4,textFieldEmail.getText());
                    myPst.setString(5,passwordField.getText());
                    myPst.setString(6,textFieldAddress.getText());
                    myPst.executeUpdate();
                    myPst.close();
                    myConn.close();
                    JOptionPane.showMessageDialog(Dialog, "Congratulations! You have now successfully registered", "",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exc) {
                	JOptionPane.showMessageDialog(Dialog, "Please Fill Out This Form Completely And Accurately", "",JOptionPane.WARNING_MESSAGE);
                	exc.printStackTrace();
                }
			}
        	
        });
        btnConfirm.setBounds(67, 312, 117, 29);
        AccountRegister.getContentPane().add(btnConfirm);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AccountRegister.dispose();
        		new StartPage().setVisible(true);
      
        	}
        });
        btnCancel.setBounds(243, 312, 117, 29);
        AccountRegister.getContentPane().add(btnCancel);

        JLabel lblBackground = new JLabel("Background");
        lblBackground.setIcon(new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\Pictures\\register.jpeg"));
        lblBackground.setBounds(0, 0, 500, 480);
        AccountRegister.getContentPane().add(lblBackground);
        
        
    }

}
