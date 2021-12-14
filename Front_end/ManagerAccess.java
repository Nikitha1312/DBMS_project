import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;


public class ManagerAccess {

	private JFrame Access;
	private JTable RegisterTable;
	private JScrollPane scrollPaneRT;
	private JTextField textFieldUserName;
	private JLabel lblBackground;
	private JLabel lblBackground1;
	private JTable OrderFoodTable;
	private JScrollPane scrollPaneOF;
	private JTextField textFieldUN;
	private JButton btnReturn;
	private JTable ReviewTable;
	private JDialog Dialog;

	public void setVisible(boolean visible) {
        if (Access != null) {
        	Access.setVisible(visible);
        }
    }
    

	public ManagerAccess() {
		initialize();
	}

	private void initialize() {
		Access = new JFrame("Manager Access");
		Access.setBounds(1000, 1000, 1500, 1500);
		Access.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Access.getContentPane().setLayout(null);
		Access.getContentPane().setBackground(Color.BLACK);
		
		btnReturn = new JButton("Return");
		btnReturn.setBounds(10, 6, 117, 29);
		Access.getContentPane().add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Access.dispose();
				new StartPage().setVisible(true);
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 53, 1262, 636);
		Access.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Customer Manage", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Review", null, panel1, null);
		panel1.setLayout(null);
		
		JPanel panel2 = new JPanel(new BorderLayout());
        tabbedPane.addTab("Delivery", null, panel2, null);
		
		JButton btnLoad = new JButton("Load Customers' Information");
		btnLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","Nikki@999");
	                String query="SELECT *FROM Register";
	                PreparedStatement myPst = myConn.prepareStatement(query);
	                ResultSet myRs = myPst.executeQuery();
	                RegisterTable.setModel(DbUtils.resultSetToTableModel(myRs));
			}catch(Exception ex){
                ex.printStackTrace();
            }
		}});
		btnLoad.setBounds(0, 208, 227, 29);
		panel.add(btnLoad);
		
		scrollPaneRT = new JScrollPane();
		scrollPaneRT.setBounds(6, 68, 1254, 128);
		panel.add(scrollPaneRT);
		
		RegisterTable = new JTable();
		scrollPaneRT.setViewportView(RegisterTable);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setText("Enter UserName");
		textFieldUserName.setBounds(396, 208, 130, 26);
		panel.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JButton btnDelete = new JButton("Delete User");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","Nikki@999");
		                String sql="DELETE FROM  Register where UserName = '"+textFieldUserName.getText()+"'";
		                PreparedStatement myPst = myConn.prepareStatement(sql);
		                myPst.execute();
		                JOptionPane.showMessageDialog(null, "Successfully Deleted User From System!");   
		                    
		                }
		                
		            catch(Exception ex){
		                ex.printStackTrace();
		            }
		        
			}
		});
		btnDelete.setBounds(584, 208, 117, 29);
		panel.add(btnDelete);
		
		scrollPaneOF = new JScrollPane();
		scrollPaneOF.setBounds(6, 281, 1254, 128);
		panel.add(scrollPaneOF);
		
		OrderFoodTable = new JTable();
		scrollPaneOF.setViewportView(OrderFoodTable);
		
		JButton btnShowOrder = new JButton("Show Order");
		btnShowOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","Nikki@999");
	                String query="SELECT *FROM OrderFood";
	                PreparedStatement myPst = myConn.prepareStatement(query);
	                ResultSet myRs = myPst.executeQuery();
	                OrderFoodTable.setModel(DbUtils.resultSetToTableModel(myRs));
			}catch(Exception ex){
                ex.printStackTrace();
            }
			}
		});
		btnShowOrder.setBounds(0, 429, 227, 29);
		panel.add(btnShowOrder);
		
		textFieldUN = new JTextField();
		textFieldUN.setText("Enter UserName");
		textFieldUN.setBounds(396, 429, 130, 26);
		panel.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","Nikki@999");
	                String sql="DELETE FROM  OrderFood where UserName = '"+textFieldUN.getText()+"'";
	                PreparedStatement myPst = myConn.prepareStatement(sql);
	                myPst.execute();
	                JOptionPane.showMessageDialog(null, "Successfully Deleted Order!");   
	                    
	                }
	                        
	            catch(Exception ex){
	                ex.printStackTrace();
	            }
			}
		});
		btnDelivery.setBounds(584, 429, 117, 29);
		panel.add(btnDelivery);
		
		
		JScrollPane scrollPaneReview = new JScrollPane();
		scrollPaneReview.setBounds(6, 68, 1254, 128);
		panel1.add(scrollPaneReview);
		
		ReviewTable = new JTable();
		scrollPaneReview.setViewportView(ReviewTable);
		
		JButton btnReview = new JButton("Review Food");
		btnReview.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection ReviewConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","Nikki@999");
	                String ReviewQuery="SELECT *FROM Menu";
	                PreparedStatement ReviewPst = ReviewConn.prepareStatement(ReviewQuery);
	                ResultSet ReviewRs = ReviewPst.executeQuery();
	                ReviewTable.setModel(DbUtils.resultSetToTableModel(ReviewRs));
			}catch(Exception ex){
                ex.printStackTrace();
            }
		}});
		btnReview.setBounds(0, 208, 227, 29);
		panel1.add(btnReview);
		lblBackground = new JLabel("");
		int widthBG=1281,heightBG=711;
		ImageIcon imageBG = new ImageIcon("src/Pictures/scenery.jpg");
        imageBG.setImage(imageBG.getImage().getScaledInstance(widthBG,heightBG,Image.SCALE_DEFAULT));
        lblBackground.setIcon(imageBG);
        lblBackground.setSize(widthBG,heightBG);
		lblBackground.setBounds(0, 0, 1281, 711);	
		panel.add(lblBackground);
		
			
		lblBackground1 = new JLabel("");
		int widthBG1=1281,heightBG1=711;
		ImageIcon imageBG1 = new ImageIcon("src/Pictures/scenery1.jpg");
        imageBG1.setImage(imageBG1.getImage().getScaledInstance(widthBG1,heightBG1,Image.SCALE_DEFAULT));
        lblBackground1.setIcon(imageBG1);
        lblBackground1.setSize(widthBG1,heightBG1);
		lblBackground1.setBounds(0, 0, 1281, 711);	
		panel1.add(lblBackground1);
			
		
	}
}
