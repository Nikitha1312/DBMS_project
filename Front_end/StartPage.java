import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StartPage{

	private JFrame Status;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.Status.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setVisible(boolean visible) {
        if (Status != null) {
            Status.setVisible(visible);
        }
    }
	public StartPage() {
		initialize();
	}

	private void initialize() {
		Status = new JFrame();
		Status.setBounds(100,100, 450, 400);
		Status.setTitle("Itsay Dine-IN");
		Status.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Status.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Itsay Dine-IN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(78, 35, 306, 29);
		Status.getContentPane().add(lblNewLabel);
		
		JButton btnRegister = new JButton("Login");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
	            new CustomerLogin().setVisible(true);
			}
		});
		btnRegister.setBounds(133, 108, 170, 29);
		Status.getContentPane().add(btnRegister);
		
		JButton btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
	            new ManagerLogin().setVisible(true);
			}
		});
		btnManager.setBounds(133, 161, 170, 29);
		Status.getContentPane().add(btnManager);
		
		JButton btnSurfer = new JButton("Surfer");
		btnSurfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
				new Retrieve().setVisible(true);
			}
		});
		btnSurfer.setBounds(133, 215, 170, 23);
		Status.getContentPane().add(btnSurfer);
		
		JButton btnReview = new JButton("Review");
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
				new Review().setVisible(true);
			}
		});
		btnReview.setBounds(133, 269, 172, 29);
		Status.getContentPane().add(btnReview);
		
		JLabel lblLobby = new JLabel();
		lblLobby.setIcon(new ImageIcon("C:\\Users\\Clg\\Downloads\\Dbms_project\\Pictures\\lobby.jpeg"));
		lblLobby.setBounds(0,0, 450, 600);
		Status.getContentPane().add(lblLobby);
		
		
	}
}
