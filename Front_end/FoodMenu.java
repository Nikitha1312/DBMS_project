import java.awt.Checkbox;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import javax.swing.JTextField;


public class FoodMenu implements ItemListener {

	private JFrame FoodMenu;
	private JDialog Dialog;
	private JTextField txtEnterUsername;
	double totalFood;
	double foodHBK=0;
	double foodPT=0;
	double foodTK=0;
	double foodCT=0;
	double foodMSK=0;
	double foodGN=0;
	double foodBN=0;
	double foodMC=0;
	double foodVP=0;
	double foodCDB=0;
	double foodGJ=0;
	double foodRG=0;
	double foodKL=0;
	double foodPK=0;
	double foodFL=0;
	int QtyHBK=0;
	int QtyPT=0;
	int QtyTK=0;
	int QtyCT=0;
	int QtyMSK=0;
	int QtyGN=0;
	int QtyBN=0;
	int QtyMC=0;
	int QtyVP=0;
	int QtyCDB=0;
	int QtyGJ=0;
	int QtyRG=0;
	int QtyKL=0;
	int QtyPK=0;
	int QtyFL=0;
	String totalOrder;
	String strHBK="";
	String strPT="";
	String strTK="";
	String strCT="";
	String strMSK="";
	String strGN="";
	String strBN="";
	String strMC="";
	String strVP="";
	String strCDB="";
	String strGJ="";
	String strRG="";
	String strKL="";
	String strPK="";
	String strFL="";
	int PreQtyHBK = 1;
	int PreQtyPT = 1;
	int PreQtyTK = 1;
	int PreQtyCT = 1;
	int PreQtyMSK = 1;
	int PreQtyGN = 1;
	int PreQtyBN = 1;
	int PreQtyMC = 1;
	int PreQtyVP = 1;
	int PreQtyCDB = 1;
	int PreQtyGJ = 1;
	int PreQtyRG = 1;
	int PreQtyKL = 1;
	int PreQtyPK = 1;
	int PreQtyFL = 1;
	
	 
	
	public void setVisible(boolean visible) {
        if (FoodMenu != null) {
        	FoodMenu.setVisible(visible);
        }
    }
	
	public FoodMenu() {
		initialize();
	}

	private void initialize() {
		
		FoodMenu = new JFrame("ITSAY Dine-In");
		FoodMenu.setBounds(700, 700, 1500, 1500);
		FoodMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FoodMenu.getContentPane().setLayout(null);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodMenu.dispose();
				new StartPage().setVisible(true);
			   
			}
		});
		btnReturn.setBounds(0, 0, 117, 29);
		FoodMenu.getContentPane().add(btnReturn);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(1060, 484, 81, 27);
		FoodMenu.getContentPane().add(lblBalance);
		
		JLabel lbltotalFood = new JLabel("");
		lbltotalFood.setBounds(1121, 474, 81, 37);
		FoodMenu.getContentPane().add(lbltotalFood);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setText("Enter UserName");
		txtEnterUsername.setBounds(1060, 540, 117, 27);
		FoodMenu.getContentPane().add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		JLabel lblOrder = new JLabel("");
		lblOrder.setBounds(6, 630, 1258, 45);
		FoodMenu.getContentPane().add(lblOrder);
		
		JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodMenu.dispose();
	            new Deposit().setVisible(true);
			}
		});
		btnDeposit.setBounds(139, 0, 117, 29);
		FoodMenu.getContentPane().add(btnDeposit);
		
		
		JButton btnPayBalance = new JButton("Pay Balance");
		btnPayBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","password");
		                Statement mySt =myConn.createStatement();
		                String sql= "UPDATE `Restaurant`.`OrderFood` "
		                		+ "SET `Orders`='"+(lblOrder.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
	        			
	                    mySt.executeUpdate(sql);
	                    try{
			                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","password");
			                Statement St =Conn.createStatement();
			                String sql1= "UPDATE `Restaurant`.`Register` "
			                		+ "SET `Deposit`=`Deposit`-'"+(lbltotalFood.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
		        			
		                    St.executeUpdate(sql1);
		                    try{
				                Connection SpentConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","password");
				                Statement SpentSt =SpentConn.createStatement();
				                String SpentSql= "UPDATE `Restaurant`.`Register` "
				                		+ "SET `Spent`=`Spent`+'"+(lbltotalFood.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
			        			
			                    SpentSt.executeUpdate(SpentSql);
			                 
			                    SpentSt.close();
			                    SpentConn.close();
				                
	   
				            }catch(Exception ex){
				            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
				                ex.printStackTrace();
				            }
		                    
		                    St.close();
		                    Conn.close();
			                
   
			            }catch(Exception ex){
			            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
			                ex.printStackTrace();
			            }
	                    JOptionPane.showMessageDialog(Dialog, "Successfully Ordered Food!", "",JOptionPane.INFORMATION_MESSAGE);
	                    mySt.close();
	                    myConn.close();
		                
		                
		                
		            }catch(Exception ex){
		            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
		                ex.printStackTrace();
		            }
		        
			
			}
		});
		btnPayBalance.setBounds(1060, 578, 117, 29);
		FoodMenu.getContentPane().add(btnPayBalance);
		
		
		
			
		//Food: Hara Bhara Kebab 
				JLabel lblHaraBharaKebab = new JLabel("");
				int widthHBK=68,heightHBK=51;
				ImageIcon imageHBK = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\1.jpeg");
		        imageHBK.setImage(imageHBK.getImage().getScaledInstance(widthHBK,heightHBK,Image.SCALE_DEFAULT));
		        lblHaraBharaKebab.setIcon(imageHBK);
		        lblHaraBharaKebab.setSize(widthHBK,heightHBK);
		        lblHaraBharaKebab.setBounds(46, 83, 81, 65);
		        FoodMenu.getContentPane().add(lblHaraBharaKebab);
				
		        JSpinner spinnerHBK = new JSpinner();
				spinnerHBK.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerHBK.setEnabled(false);
				spinnerHBK.setBounds(78, 184, 56, 23);
				FoodMenu.getContentPane().add(spinnerHBK);
			
				
				JCheckBox chckbxHBK = new JCheckBox(" ");
				chckbxHBK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxHBK.isSelected()){
							spinnerHBK.setEnabled(true);
							foodHBK=foodHBK+270;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strHBK="Hara Bhara Kebab" + "("+String.valueOf(PreQtyHBK)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							
							spinnerHBK.setEnabled(false);
							spinnerHBK.setValue(1);
							foodHBK=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strHBK=" ";
							PreQtyHBK = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
							
						}
					}
				});
				chckbxHBK.setBounds(6, 110, 25, 23);
				FoodMenu.getContentPane().add(chckbxHBK);
				
			
				spinnerHBK.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateHBK=270;
						 
						 if(chckbxHBK.isSelected()){
							 PreQtyHBK=(Integer)spinnerHBK.getValue();
						 if(PreQtyHBK>QtyHBK){
							 QtyHBK = PreQtyHBK;
					         foodHBK = RateHBK * PreQtyHBK;
					         strHBK="Hara Bhara Kebab" + "("+String.valueOf(PreQtyHBK)+")";
							 totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							 
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					         }else if(PreQtyHBK<=QtyHBK){
							 QtyHBK = PreQtyHBK;
					         foodHBK = RateHBK * PreQtyHBK;
					         strHBK="Hara Bhara Kebab" + "("+String.valueOf(PreQtyHBK)+")";
							 totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							 
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lblOrder.setText(String.valueOf(totalOrder));
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				
				JLabel lblHBK = new JLabel("Hara Bhara Kebab (270)");
				lblHBK.setBounds(21, 160, 137, 12);
				FoodMenu.getContentPane().add(lblHBK);
				
				JLabel lblQtyHBK = new JLabel("Qty:");
				lblQtyHBK.setBounds(44, 187, 31, 19);
				FoodMenu.getContentPane().add(lblQtyHBK);
				
				
				//FoodL: Paneer Tikka
				JLabel lblPaneerTikka = new JLabel("");
				int widthPT=81,heightPT=65;
				ImageIcon imagePT = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\2.jpeg");
		        imagePT.setImage(imagePT.getImage().getScaledInstance(widthPT,heightPT,Image.SCALE_DEFAULT));
		        lblPaneerTikka.setIcon(imagePT);
		        lblPaneerTikka.setSize(widthPT,heightPT);
		        lblPaneerTikka.setBounds(263, 83, 81, 65);
				FoodMenu.getContentPane().add(lblPaneerTikka);
				
				JSpinner spinnerPT = new JSpinner();
				spinnerPT.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerPT.setEnabled(false);
				spinnerPT.setBounds(286, 184, 58, 23);
				FoodMenu.getContentPane().add(spinnerPT);
				
				JCheckBox chckbxPT = new JCheckBox("");
				chckbxPT.addItemListener(this);
				chckbxPT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxPT.isSelected()){
							spinnerPT.setEnabled(true);
							foodPT=foodPT+300;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPT="Paneer Tikka"+ "("+String.valueOf(PreQtyPT)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							lblOrder.setText(null);
							spinnerPT.setEnabled(false);
							spinnerPT.setValue(1);
							foodPT=0;
							PreQtyPT = 1;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPT=" ";
							PreQtyPT = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));				}
					}
				});
				chckbxPT.setBounds(216, 110, 25, 23);
				FoodMenu.getContentPane().add(chckbxPT);
				
				spinnerPT.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RatePT=300;
						 if(chckbxPT.isSelected()){
							 PreQtyPT=(Integer)spinnerPT.getValue();
						 if(PreQtyPT>QtyPT){
							 QtyPT = PreQtyPT;
					         foodPT = RatePT * PreQtyPT;
								strPT="Paneer Tikka"+ "("+String.valueOf(PreQtyPT)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyPT<=QtyPT){
							 QtyPT = PreQtyPT;
					         foodPT = RatePT * PreQtyPT;
								strPT="Paneer Tikka"+ "("+String.valueOf(PreQtyPT)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblPT = new JLabel("Paneer Tikka(300)");
				lblPT.setBounds(245, 160, 115, 14);
				FoodMenu.getContentPane().add(lblPT);
				
				JLabel lblQtyPT = new JLabel("Qty:");
				lblQtyPT.setBounds(253, 187, 36, 19);
				FoodMenu.getContentPane().add(lblQtyPT);
				
				
				//Food: Tangdi Kebab    
				JLabel lblTangdiKebab     = new JLabel("");
				int widthTK=81,heightTK=65;
				ImageIcon imageTK = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\3.jpeg");
		        imageTK.setImage(imageTK.getImage().getScaledInstance(widthTK,heightTK,Image.SCALE_DEFAULT));
		        lblTangdiKebab.setIcon(imageTK);
		        lblTangdiKebab.setSize(widthTK,heightTK);
				lblTangdiKebab.setBounds(493, 83, 81, 65);
				FoodMenu.getContentPane().add(lblTangdiKebab);
				
				JSpinner spinnerTK = new JSpinner();
				spinnerTK.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerTK.setEnabled(false);
				spinnerTK.setBounds(514, 183, 56, 23);
				FoodMenu.getContentPane().add(spinnerTK);
				
				JCheckBox chckbxTK = new JCheckBox("");
				chckbxTK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxTK.isSelected()){
							spinnerTK.setEnabled(true);
							foodTK=foodTK+400;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strTK="Tangdi Kebab"+ "("+String.valueOf(PreQtyTK)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerTK.setEnabled(false);
							spinnerTK.setValue(1);
							foodTK=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strTK=" ";
							PreQtyTK = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxTK.setBounds(433, 110, 25, 23);
				FoodMenu.getContentPane().add(chckbxTK);
				
				spinnerTK.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateTK=400;
						 if(chckbxTK.isSelected()){
							 PreQtyTK=(Integer)spinnerTK.getValue();
						 if(PreQtyTK>QtyTK){
							 QtyTK = PreQtyTK;
					         foodTK = RateTK * PreQtyTK;
					         strTK="Tangdi Kebab"+ "("+String.valueOf(PreQtyTK)+")";
					         totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							 lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyTK<=QtyTK){
							 QtyTK = PreQtyTK;
					         foodTK = RateTK * PreQtyTK;
					         strTK="Tangdi Kebab"+ "("+String.valueOf(PreQtyTK)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblTK = new JLabel("Tangdi Kebab (400)");
				lblTK.setBounds(482, 160, 92, 12);
				FoodMenu.getContentPane().add(lblTK);
				
				JLabel lblQtyTK = new JLabel("Qty:");
				lblQtyTK.setBounds(483, 184, 31, 20);
				FoodMenu.getContentPane().add(lblQtyTK);
				
				
				//Food: Chicken Tikka
				JLabel lblChickenTikka = new JLabel("");
				int widthCT=81,heightCT=65;
				ImageIcon imageCT = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\4.jpeg");
		        imageCT.setImage(imageCT.getImage().getScaledInstance(widthCT,heightCT,Image.SCALE_DEFAULT));
		        lblChickenTikka.setIcon(imageCT);
		        lblChickenTikka.setSize(widthCT,heightCT);
				lblChickenTikka.setBounds(699, 83, 81, 65);
				FoodMenu.getContentPane().add(lblChickenTikka);
				
				JSpinner spinnerCT = new JSpinner();
				spinnerCT.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerCT.setEnabled(false);
				spinnerCT.setBounds(711, 184, 56, 23);
				FoodMenu.getContentPane().add(spinnerCT);
				
				JCheckBox chckbxCT = new JCheckBox("");
				chckbxCT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxCT.isSelected()){
							spinnerCT.setEnabled(true);
							foodCT=foodCT+350;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strCT="Chicken Tikka" + "("+String.valueOf(PreQtyCT)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerCT.setEnabled(false);
							spinnerCT.setValue(1);
							foodCT=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCT=" ";
							PreQtyCT = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxCT.setBounds(625, 110, 25, 23);
				FoodMenu.getContentPane().add(chckbxCT);
				
				spinnerCT.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateCT=350;
						 if(chckbxCT.isSelected()){
							 PreQtyCT=(Integer)spinnerCT.getValue();
						 if(PreQtyCT>QtyCT){
							 QtyCT= PreQtyCT;
					         foodCT = RateCT * PreQtyCT;
								strCT="Chicken Tikka" + "("+String.valueOf(PreQtyCT)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyCT<=QtyCT){
							 QtyCT = PreQtyCT;
					         foodCT = RateCT * PreQtyCT;
								strCT="Chicken Tikka" + "("+String.valueOf(PreQtyCT)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblCT = new JLabel("Chicken Tikka (350)");
				lblCT.setBounds(699, 158, 68, 14);
				FoodMenu.getContentPane().add(lblCT);
				
				JLabel lblQtyCT = new JLabel("Qty:");
				lblQtyCT.setBounds(680, 188, 61, 16);
				FoodMenu.getContentPane().add(lblQtyCT);
				
				
				//Food:Mutton Seekh Kebab
				JLabel lblMuttonSeekhKebab = new JLabel("");
				int widthMSK=81,heightMSK=65;
				ImageIcon imageMSK = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\5.jpeg");
		        imageMSK.setImage(imageMSK.getImage().getScaledInstance(widthMSK,heightMSK,Image.SCALE_DEFAULT));
		        lblMuttonSeekhKebab.setIcon(imageMSK);
		        lblMuttonSeekhKebab.setSize(widthMSK,heightMSK);
				lblMuttonSeekhKebab.setBounds(898, 83, 81, 65);
				FoodMenu.getContentPane().add(lblMuttonSeekhKebab);
				
				JSpinner spinnerMSK = new JSpinner();
				spinnerMSK.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerMSK.setEnabled(false);
				spinnerMSK.setBounds(910, 183, 56, 22);
				FoodMenu.getContentPane().add(spinnerMSK);
				
				JCheckBox chckbxMSK = new JCheckBox(" ");
				chckbxMSK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxMSK.isSelected()){
							spinnerMSK.setEnabled(true);
							foodMSK=foodMSK+400;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strMSK="Mutton Seekh Kebab" + "("+String.valueOf(PreQtyMSK)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerMSK.setEnabled(false);
							spinnerMSK.setValue(1);
							foodMSK=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strMSK=" ";
							PreQtyMSK = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxMSK.setBounds(828, 110, 25, 23);
				FoodMenu.getContentPane().add(chckbxMSK);
				
				spinnerMSK.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateMSK=400;
						 if(chckbxMSK.isSelected()){
							 PreQtyMSK=(Integer)spinnerMSK.getValue();
						 if(PreQtyMSK>QtyMSK){
							 QtyMSK = PreQtyMSK;
					         foodMSK = RateMSK * PreQtyMSK;
								strMSK="Mutton Seekh Kebab" + "("+String.valueOf(PreQtyMSK)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyMSK<=QtyMSK){
							 QtyMSK = PreQtyMSK;
					         foodMSK = RateMSK * PreQtyMSK;
								strMSK="Mutton Seekh Kebab" + "("+String.valueOf(PreQtyMSK)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblMSK = new JLabel("Mutton Seekh Kebab (400)");
				lblMSK.setBounds(867, 157, 115, 18);
				FoodMenu.getContentPane().add(lblMSK);
				
				JLabel lblQtyMSK = new JLabel("Qty:");
				lblQtyMSK.setBounds(875, 185, 45, 19);
				FoodMenu.getContentPane().add(lblQtyMSK);
				
				
				//Food: Garlic Naan
				JLabel lblGarlicNaan = new JLabel("");
				int widthGN=81,heightGN=65;
				ImageIcon imageGN = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\6.jpeg");
		        imageGN.setImage(imageGN.getImage().getScaledInstance(widthGN,heightGN,Image.SCALE_DEFAULT));
		        lblGarlicNaan.setIcon(imageGN);
		        lblGarlicNaan.setSize(widthGN,heightGN);
				lblGarlicNaan.setBounds(46, 255, 81, 65);
				FoodMenu.getContentPane().add(lblGarlicNaan);
				
				JSpinner spinnerGN = new JSpinner();
				spinnerGN.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerGN.setEnabled(false);
				spinnerGN.setBounds(78, 350, 56, 23);
				FoodMenu.getContentPane().add(spinnerGN);
				
				JCheckBox chckbxGN = new JCheckBox("");
				chckbxGN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxGN.isSelected()){
							spinnerGN.setEnabled(true);
							foodGN=foodGN+50;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strGN="GarlicNaan" + "("+String.valueOf(PreQtyGN)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerGN.setEnabled(false);
							spinnerGN.setValue(1);
							foodGN=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strGN=" ";
							PreQtyGN = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxGN.setBounds(6, 284, 25, 23);
				FoodMenu.getContentPane().add(chckbxGN);
				
				spinnerGN.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateGN=50;
						 if(chckbxGN.isSelected()){
							 PreQtyGN=(Integer)spinnerGN.getValue();
						 if(PreQtyGN>QtyGN){
							 QtyGN = PreQtyGN;
					         foodGN = RateGN * PreQtyGN;
								strGN="GarlicNaan" + "("+String.valueOf(PreQtyGN)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyGN<=QtyGN){
							 QtyGN = PreQtyGN;
					         foodGN = RateGN * PreQtyGN;
								strGN="GarlicNaan" + "("+String.valueOf(PreQtyGN)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblGN = new JLabel("GarlicNaan (50)");
				lblGN.setBounds(37, 328, 97, 19);
				FoodMenu.getContentPane().add(lblGN);
				
				JLabel lblQtyGN = new JLabel("Qty:");
				lblQtyGN.setBounds(44, 352, 38, 20);
				FoodMenu.getContentPane().add(lblQtyGN);
				
				
				//Food: Butter Naan
				JLabel lblButterNaan = new JLabel("");
				int widthBN=81,heightBN=65;
				ImageIcon imageBN = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\7.jpeg");
		        imageBN.setImage(imageBN.getImage().getScaledInstance(widthBN,heightBN,Image.SCALE_DEFAULT));
		        lblButterNaan.setIcon(imageBN);
		        lblButterNaan.setSize(widthBN,heightBN);
				lblButterNaan.setBounds(263, 255, 81, 65);
				FoodMenu.getContentPane().add(lblButterNaan);
				
				JSpinner spinnerBN = new JSpinner();
				spinnerBN.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerBN.setEnabled(false);
				spinnerBN.setBounds(286, 350, 57, 23);
				FoodMenu.getContentPane().add(spinnerBN);
				
				JCheckBox chckbxBN = new JCheckBox("");
				chckbxBN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxBN.isSelected()){
							spinnerBN.setEnabled(true);
							foodBN=foodBN+12;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strBN="Butter Naan" + "("+String.valueOf(PreQtyBN)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerBN.setEnabled(false);
							spinnerBN.setValue(1);
							foodBN=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strBN=" ";
							PreQtyBN = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxBN.setBounds(216, 284, 25, 23);
				FoodMenu.getContentPane().add(chckbxBN);
				
				spinnerBN.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateBN=50;
						 if(chckbxBN.isSelected()){
							 PreQtyBN=(Integer)spinnerBN.getValue();
						 if(PreQtyBN>QtyBN){
							 QtyBN = PreQtyBN;
					         foodBN = RateBN * PreQtyBN;
								strBN="Butter Naan" + "("+String.valueOf(PreQtyBN)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyBN<=QtyBN){
							 QtyBN = PreQtyBN;
					         foodBN = RateBN * PreQtyBN;
								strBN="Butter Naan" + "("+String.valueOf(PreQtyBN)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblBN = new JLabel("Butter Naan (50)");
				lblBN.setBounds(245, 324, 118, 23);
				FoodMenu.getContentPane().add(lblBN);
				
				JLabel lblQtyBN = new JLabel("Qty:");
				lblQtyBN.setBounds(255, 354, 36, 19);
				FoodMenu.getContentPane().add(lblQtyBN);
				
				
				//Food: Mushroom Curry
				JLabel lblMushroomCurry = new JLabel("");
				int widthMC=81,heightMC=65;
				ImageIcon imageMC = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\8.jpeg");
		        imageMC.setImage(imageMC.getImage().getScaledInstance(widthMC,heightMC,Image.SCALE_DEFAULT));
		        lblMushroomCurry.setIcon(imageMC);
		        lblMushroomCurry.setSize(widthMC,heightMC);
				lblMushroomCurry.setBounds(493, 255, 81, 65);
				FoodMenu.getContentPane().add(lblMushroomCurry);
				
				JSpinner spinnerMC = new JSpinner();
				spinnerMC.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerMC.setEnabled(false);
				spinnerMC.setBounds(526, 349, 56, 23);
				FoodMenu.getContentPane().add(spinnerMC);
				
				JCheckBox chckbxMC = new JCheckBox("");
				chckbxMC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxMC.isSelected()){
							spinnerMC.setEnabled(true);
							foodMC=foodMC+200;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strMC="Mushroom Curry" + "("+String.valueOf(PreQtyMC)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerMC.setEnabled(false);
							spinnerMC.setValue(1);
							foodMC=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strMC=" ";
							PreQtyMC = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));;
						}
					}
				});
				chckbxMC.setBounds(442, 284, 25, 23);
				FoodMenu.getContentPane().add(chckbxMC);
				
				spinnerMC.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateMC=200;
						 if(chckbxMC.isSelected()){
							 PreQtyMC=(Integer)spinnerMC.getValue();
						 if(PreQtyMC>QtyMC){
							 QtyMC = PreQtyMC;
					         foodMC = RateMC * PreQtyMC;
								strMC="Mushroom Curry" + "("+String.valueOf(PreQtyMC)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyMC<=QtyMC){
							 QtyMC = PreQtyMC;
					         foodMC = RateMC * PreQtyMC;
								strMC="Mushroom Curry" + "("+String.valueOf(PreQtyMC)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblMC = new JLabel("Mushroom Curry (200)");
				lblMC.setBounds(463, 324, 153, 23);
				FoodMenu.getContentPane().add(lblMC);
				
				JLabel lblQtyMC = new JLabel("Qty:");
				lblQtyMC.setBounds(491, 353, 36, 19);
				FoodMenu.getContentPane().add(lblQtyMC);
				
				
				//Food: Vegetable pulao
				JLabel lblVegetablepulao = new JLabel("");
				int widthVP=81,heightVP=65;
				ImageIcon imageVP = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\9.jpeg");
		        imageVP.setImage(imageVP.getImage().getScaledInstance(widthVP,heightVP,Image.SCALE_DEFAULT));
		        lblVegetablepulao.setIcon(imageVP);
		        lblVegetablepulao.setSize(widthVP,heightVP);
				lblVegetablepulao.setBounds(699, 255, 81, 65);
				FoodMenu.getContentPane().add(lblVegetablepulao);
				
				JSpinner spinnerVP = new JSpinner();
				spinnerVP.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerVP.setEnabled(false);
				spinnerVP.setBounds(711, 349, 56, 23);
				FoodMenu.getContentPane().add(spinnerVP);
				
				JCheckBox chckbxVP = new JCheckBox("");
				chckbxVP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxVP.isSelected()){
							spinnerVP.setEnabled(true);
							foodVP=foodVP+350;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strVP="Vegetable pulao" + "("+String.valueOf(PreQtyVP)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerVP.setEnabled(false);
							spinnerVP.setValue(1);
							foodVP=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strVP=" ";
							PreQtyVP = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxVP.setBounds(625, 284, 25, 23);
				FoodMenu.getContentPane().add(chckbxVP);
				
				spinnerVP.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateVP=350;
						 if(chckbxVP.isSelected()){
							 PreQtyVP=(Integer)spinnerVP.getValue();
						 if(PreQtyVP>QtyVP){
							 QtyVP = PreQtyVP;
					         foodVP = RateVP* PreQtyVP;
								strVP="Vegetable pulao" + "("+String.valueOf(PreQtyVP)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyVP<=QtyVP){
							 QtyVP = PreQtyVP;
					         foodVP= RateVP * PreQtyVP;
								strVP="Vegetable pulao" + "("+String.valueOf(PreQtyVP)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblVP = new JLabel("Vegetable pulao (350)");
				lblVP.setBounds(668, 324, 153, 23);
				FoodMenu.getContentPane().add(lblVP);
				
				JLabel lblQtyVP = new JLabel("Qty:");
				lblQtyVP.setBounds(680, 354, 61, 16);
				FoodMenu.getContentPane().add(lblQtyVP);
				
				
				//Food: Chicken Dum Biryani
				JLabel lblChickenDumBiryani = new JLabel("");
				int widthCDB=81,heightCDB=65;
				ImageIcon imageCDB = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\10.jpeg");
		        imageCDB.setImage(imageCDB.getImage().getScaledInstance(widthCDB,heightCDB,Image.SCALE_DEFAULT));
		        lblChickenDumBiryani.setIcon(imageCDB);
		        lblChickenDumBiryani.setSize(widthCDB,heightCDB);
				lblChickenDumBiryani.setBounds(898, 255, 81, 65);
				FoodMenu.getContentPane().add(lblChickenDumBiryani);
				
				JSpinner spinnerCDB = new JSpinner();
				spinnerCDB.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerCDB.setEnabled(false);
				spinnerCDB.setBounds(910, 349, 56, 24);
				FoodMenu.getContentPane().add(spinnerCDB);
				
				JCheckBox chckbxCDB = new JCheckBox("");
				chckbxCDB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxCDB.isSelected()){
							spinnerCDB.setEnabled(true);
							foodCDB=foodCDB+300;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCDB="Chicken Dum Biryani"+ "("+String.valueOf(PreQtyCDB)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerCDB.setEnabled(false);
							spinnerCDB.setValue(1);
							foodCDB=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCDB=" ";
							PreQtyCDB = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxCDB.setBounds(828, 284, 25, 23);
				FoodMenu.getContentPane().add(chckbxCDB);
				
				spinnerCDB.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateCDB=300;
						 if(chckbxCDB.isSelected()){
							 PreQtyCDB=(Integer)spinnerCDB.getValue();
						 if(PreQtyCDB>QtyCDB){
							 QtyCDB = PreQtyCDB;
					         foodCDB= RateCDB * PreQtyCDB;
								strCDB="Chicken Dum Biryani"+ "("+String.valueOf(PreQtyCDB)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyCDB<=QtyCDB){
							 QtyCDB = PreQtyCDB;
					         foodCDB = RateCDB * PreQtyCDB;
								strCDB="Chicken Dum Biryani"+ "("+String.valueOf(PreQtyCDB)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblCDB = new JLabel("Chicken Dum Biryani(300)");
				lblCDB.setBounds(867, 328, 128, 19);
				FoodMenu.getContentPane().add(lblCDB);
				
				JLabel lblQtyCDB = new JLabel("Qty:");
				lblQtyCDB.setBounds(877, 354, 61, 16);
				FoodMenu.getContentPane().add(lblQtyCDB);
				
				
				//Food: Gulab Jamoon
				JLabel lblGulabJamoon = new JLabel("");
				int widthGJ=81,heightGJ=65;
				ImageIcon imageGJ = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\11.jpeg");
		        imageGJ.setImage(imageGJ.getImage().getScaledInstance(widthGJ,heightGJ,Image.SCALE_DEFAULT));
		        lblGulabJamoon.setIcon(imageGJ);
		        lblGulabJamoon.setSize(widthGJ,heightGJ);
				lblGulabJamoon.setBounds(46, 423, 81, 65);
				FoodMenu.getContentPane().add(lblGulabJamoon);
				
				JSpinner spinnerGJ = new JSpinner();
				spinnerGJ.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerGJ.setEnabled(false);
				spinnerGJ.setBounds(71, 524, 56, 21);
				FoodMenu.getContentPane().add(spinnerGJ);
				
				JCheckBox chckbxGJ = new JCheckBox("");
				chckbxGJ.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxGJ.isSelected()){
							spinnerGJ.setEnabled(true);
							foodGJ=foodGJ+150;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strGJ="Gulab Jamoon"+ "("+String.valueOf(PreQtyGJ)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerGJ.setEnabled(false);
							spinnerGJ.setValue(1);
							foodGJ=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strGJ=" ";
							PreQtyGJ = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxGJ.setBounds(6, 452, 25, 23);
				FoodMenu.getContentPane().add(chckbxGJ);
				
				spinnerGJ.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateGJ=150;
						 if(chckbxGJ.isSelected()){
							 PreQtyGJ=(Integer)spinnerGJ.getValue();
						 if(PreQtyGJ>QtyGJ){
							 QtyGJ = PreQtyGJ;
					         foodGJ = RateGJ * PreQtyGJ;
								strGJ="Gulab Jamoon"+ "("+String.valueOf(PreQtyGJ)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyGJ<=QtyGJ){
							 QtyGJ = PreQtyGJ;
					         foodGJ = RateGJ * PreQtyGJ;
								strGJ="Gulab Jamoon"+ "("+String.valueOf(PreQtyGJ)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblGJ = new JLabel("Gulab Jamoon (150)");
				lblGJ.setBounds(16, 498, 153, 18);
				FoodMenu.getContentPane().add(lblGJ);
				
				JLabel lblQtyGJ = new JLabel("Qty:");
				lblQtyGJ.setBounds(37, 528, 61, 16);
				FoodMenu.getContentPane().add(lblQtyGJ);
				
				
				//Food: Rasgulla
				JLabel lblRasgulla = new JLabel("");
				int widthRG=81,heightRG=65;
				ImageIcon imageRG= new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\12.jpeg");
		        imageRG.setImage(imageRG.getImage().getScaledInstance(widthRG,heightRG,Image.SCALE_DEFAULT));
		        lblRasgulla.setIcon(imageRG);
		        lblRasgulla.setSize(widthRG,heightRG);
				lblRasgulla.setBounds(263, 423, 81, 65);
				FoodMenu.getContentPane().add(lblRasgulla);
				
				JSpinner spinnerRG = new JSpinner();
				spinnerRG.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerRG.setEnabled(false);
				spinnerRG.setBounds(286, 523, 56, 23);
				FoodMenu.getContentPane().add(spinnerRG);
				
				JCheckBox chckbxRG = new JCheckBox("");
				chckbxRG.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxRG.isSelected()){
							spinnerRG.setEnabled(true);
							foodRG=foodRG+160;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strRG="Rasgulla"+ "("+String.valueOf(PreQtyRG)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerRG.setEnabled(false);
							spinnerRG.setValue(1);
							foodRG=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strRG=" ";
							PreQtyRG = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxRG.setBounds(216, 452, 25, 23);
				FoodMenu.getContentPane().add(chckbxRG);
				
				spinnerRG.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateRG=160;
						 if(chckbxRG.isSelected()){
							 PreQtyRG=(Integer)spinnerRG.getValue();
						 if(PreQtyRG>QtyRG){
							 QtyRG = PreQtyRG;
					         foodRG = RateRG * PreQtyRG;
								strRG="Rasgulla"+ "("+String.valueOf(PreQtyRG)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyRG<=QtyRG){
							 QtyRG = PreQtyRG;
					         foodRG = RateRG * PreQtyRG;
								strRG="Rasgulla"+ "("+String.valueOf(PreQtyRG)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblRG = new JLabel("Rasgulla (160)");
				lblRG.setBounds(237, 498, 153, 19);
				FoodMenu.getContentPane().add(lblRG);
				
				JLabel lblQtyRG = new JLabel("Qty:");
				lblQtyRG.setBounds(255, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyRG);
				
				
				//Food: Kulfi
				JLabel lblKulfi = new JLabel("");
				int widthKL=81,heightKL=65;
				ImageIcon imageKL = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\13.jpeg");
		        imageKL.setImage(imageKL.getImage().getScaledInstance(widthKL,heightKL,Image.SCALE_DEFAULT));
		        lblKulfi.setIcon(imageKL);
		        lblKulfi.setSize(widthKL,heightKL);
				lblKulfi.setBounds(493, 423, 81, 65);
				FoodMenu.getContentPane().add(lblKulfi);
				
				JSpinner spinnerKL = new JSpinner();
				spinnerKL.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerKL.setEnabled(false);
				spinnerKL.setBounds(526, 523, 56, 23);
				FoodMenu.getContentPane().add(spinnerKL);
				
				JCheckBox chckbxKL = new JCheckBox("");
				chckbxKL.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxKL.isSelected()){
							spinnerKL.setEnabled(true);
							foodKL=foodKL+60;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strKL="Kulfi" + "("+String.valueOf(PreQtyKL)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerKL.setEnabled(false);
							spinnerKL.setValue(1);
							foodKL=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strKL=" ";
							PreQtyKL = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxKL.setBounds(442, 452, 25, 23);
				FoodMenu.getContentPane().add(chckbxKL);
				
				spinnerKL.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateKL=60;
						 if(chckbxKL.isSelected()){
							 PreQtyKL=(Integer)spinnerKL.getValue();
						 if(PreQtyKL>QtyKL){
							 QtyKL= PreQtyKL;
					         foodKL = RateKL * PreQtyKL;
								strKL="Kulfi" + "("+String.valueOf(PreQtyKL)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyKL<=QtyKL){
							 QtyKL = PreQtyKL;
					         foodKL = RateKL * PreQtyKL;
								strKL="Kulfi" + "("+String.valueOf(PreQtyKL)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblKL = new JLabel("Kulfi (60)");
				lblKL.setBounds(473, 498, 137, 18);
				FoodMenu.getContentPane().add(lblKL);
				
				JLabel lblQtyKL = new JLabel("Qty:");
				lblQtyKL.setBounds(493, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyKL);
				
				
				//Food: Palkova
				JLabel lblPalkova = new JLabel("");
				int widthPK=81,heightPK=65;
				ImageIcon imagePK = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\14.jpeg");
		        imagePK.setImage(imagePK.getImage().getScaledInstance(widthPK,heightPK,Image.SCALE_DEFAULT));
		        lblPalkova.setIcon(imagePK);
		        lblPalkova.setSize(widthPK,heightPK);
				lblPalkova.setBounds(699, 423, 81, 65);
				FoodMenu.getContentPane().add(lblPalkova);
				
				JSpinner spinnerPK = new JSpinner();
				spinnerPK.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerPK.setEnabled(false);
				spinnerPK.setBounds(711, 522, 56, 26);
				FoodMenu.getContentPane().add(spinnerPK);
				
				JCheckBox chckbxPK = new JCheckBox("");
				chckbxPK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxPK.isSelected()){
							spinnerPK.setEnabled(true);
							foodPK=foodPK+100;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strPK="Palkova" + "("+String.valueOf(PreQtyPK)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerPK.setEnabled(false);
							spinnerPK.setValue(1);
							foodPK=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPK=" ";
							PreQtyPK = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxPK.setBounds(625, 452, 25, 23);
				FoodMenu.getContentPane().add(chckbxPK);
				
				spinnerPK.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RatePK=100;
						 if(chckbxPK.isSelected()){
							 PreQtyPK=(Integer)spinnerPK.getValue();
						 if(PreQtyPK>QtyPK){
							 QtyPK= PreQtyPK;
					         foodPK = RatePK * PreQtyPK;
								strPK="Palkova" + "("+String.valueOf(PreQtyPK)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyPK<=QtyPK){
							 QtyPK = PreQtyPK;
					         foodPK = RatePK * PreQtyPK;
								strPK="Palkova" + "("+String.valueOf(PreQtyPK)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblPK = new JLabel("Palkova (100)");
				lblPK.setBounds(680, 497, 134, 19);
				FoodMenu.getContentPane().add(lblPK);
				
				JLabel lblQtyPK = new JLabel("Qty:");
				lblQtyPK.setBounds(680, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyPK);
				
				
				//Food: Falooda 
				JLabel lblFalooda  = new JLabel("");
				int widthFL=81,heightFL=65;
				ImageIcon imageFL = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\FoodList\\15.jpeg");
		        imageFL.setImage(imageFL.getImage().getScaledInstance(widthFL,heightFL,Image.SCALE_DEFAULT));
		        lblFalooda .setIcon(imageFL);
		        lblFalooda .setSize(widthFL,heightFL);
				lblFalooda .setBounds(898, 423, 81, 65);
				FoodMenu.getContentPane().add(lblFalooda );
				
				JSpinner spinnerFL = new JSpinner();
				spinnerFL.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerFL.setEnabled(false);
				spinnerFL.setBounds(910, 522, 56, 23);
				FoodMenu.getContentPane().add(spinnerFL);
				
				JCheckBox chckbxFL = new JCheckBox("");
				chckbxFL.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxFL.isSelected()){
							spinnerFL.setEnabled(true);
							foodFL=foodFL+180;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strFL="Falooda " + "("+String.valueOf(PreQtyFL)+")";
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerFL.setEnabled(false);
							spinnerFL.setValue(1);
							foodFL=0;
							totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
							lbltotalFood.setText(String.valueOf(totalFood));
							strFL=" ";
							PreQtyFL = 1;
							totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxFL.setBounds(828, 452, 25, 23);
				FoodMenu.getContentPane().add(chckbxFL);
				
				spinnerFL.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateFL=180;
						 if(chckbxFL.isSelected()){
							 PreQtyFL=(Integer)spinnerFL.getValue();
						 if(PreQtyFL>QtyFL){
							 QtyFL= PreQtyFL;
					         foodFL = RateFL * PreQtyFL;
								strFL="Falooda" + "("+String.valueOf(PreQtyFL)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					     }else if(PreQtyFL<=QtyFL){
							 QtyFL = PreQtyFL;
					         foodFL = RateFL * PreQtyFL;
								strFL="Falooda " + "("+String.valueOf(PreQtyFL)+")";
								totalOrder=strHBK+" "+strPT+" "+strTK+" "+strCT+" "+strMSK+" "+strGN+" "+strBN+" "+strMC+" "+strVP+" "+strCDB+" "+strGJ+" "+strRG+" "+strKL+" "+strPK+" "+strFL;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodHBK+foodPT+foodTK+foodCT+foodMSK+foodGN+foodBN+foodMC+foodVP+foodCDB+foodGJ+foodRG+foodKL+foodPK+foodFL;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblFL = new JLabel("Falooda  (180)");
				lblFL.setBounds(860, 498, 134, 18);
				FoodMenu.getContentPane().add(lblFL);
				
				JLabel lblQtyFL = new JLabel("Qty:");
				lblQtyFL.setBounds(877, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyFL);
				
				
				JLabel lblLogo = new JLabel("");
				int widthLG=204,heightLG=125;
				ImageIcon imageLG = new ImageIcon("src/Pictures/AsianFlavors.png");
		        imageLG.setImage(imageLG.getImage().getScaledInstance(widthLG,heightLG,Image.SCALE_DEFAULT));
		        lblLogo.setIcon(imageLG);
		        lblLogo.setSize(widthLG,heightLG);
				lblLogo.setBounds(1060, 110, 204, 125);
				FoodMenu.getContentPane().add(lblLogo);
				
				JLabel lblLogo1 = new JLabel("");
				int widthLG1=204,heightLG1=125;
				ImageIcon imageLG1 = new ImageIcon("src/Pictures/NewAsia.jpg");
		        imageLG1.setImage(imageLG1.getImage().getScaledInstance(widthLG1,heightLG1,Image.SCALE_DEFAULT));
		        lblLogo1.setIcon(imageLG1);
		        lblLogo1.setSize(widthLG1,heightLG1);
				lblLogo1.setBounds(1060, 300, 204, 125);
				FoodMenu.getContentPane().add(lblLogo1);

				
				JLabel lblBackground = new JLabel("Enter Your UserName");
				int widthBG=1500,heightBG=1500;
				ImageIcon imageBG = new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\Pictures\\blue.jpg");
		        imageBG.setImage(imageBG.getImage().getScaledInstance(widthBG,heightBG,Image.SCALE_DEFAULT));
		        lblBackground.setIcon(imageBG);
		        lblBackground.setSize(widthBG,heightBG);
				lblBackground.setBounds(0, 0, 1500, 1500);
				FoodMenu.getContentPane().add(lblBackground);
				
						
				
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
		}
		}
