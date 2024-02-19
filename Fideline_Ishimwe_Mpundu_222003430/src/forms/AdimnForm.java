package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AdimnForm<frmAdminFrom> {

	protected static final Window frmLoginForm = null;
	private JFrame frmAdminFrom;
	private JTextField usertxf;
	private JLabel lblPassword;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdimnForm window = new AdimnForm();
					window.frmAdminFrom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdimnForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <frmAdminFrom>
	 */
	private <frmAdminFrom> void initialize() {
		frmAdminFrom = new JFrame();
		frmAdminFrom.setTitle("admin from");
		frmAdminFrom.setBounds(100, 100, 604, 334);
		frmAdminFrom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminFrom.getContentPane().setLayout(null);
		
		JLabel uslb = new JLabel("username");
		uslb.setFont(new Font("Tahoma", Font.BOLD, 19));
		uslb.setBounds(35, 58, 183, 37);
		frmAdminFrom.getContentPane().add(uslb);
		
		usertxf = new JTextField();
		usertxf.setBounds(260, 65, 243, 37);
		frmAdminFrom.getContentPane().add(usertxf);
		usertxf.setColumns(10);
		
		lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(35, 125, 183, 37);
		frmAdminFrom.getContentPane().add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(260, 129, 243, 37);
		frmAdminFrom.getContentPane().add(pass);
		
		JButton btnNewButton = new JButton("login");
	btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","222003430","222003430");
					Statement stm=con.createStatement();
					String query="select * from admin where username='"+usertxf.getText()+"' and password='"+pass.getText().toString()+"'";
					ResultSet set=stm.executeQuery(query);
					if (set.next()) {
						JOptionPane.showMessageDialog(btnNewButton, "Login Successfully!!!");
						userform login= new userform ();
			             login.setVisible(true);
			             frmLoginForm.dispose(); 
						
					}
					else {
						JOptionPane.showMessageDialog(null, "username or password incorrect");
					}
				} catch (Exception e2) {
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Sorts Mill Goudy", Font.BOLD | Font.ITALIC, 19));
		btnNewButton.setBounds(129, 227, 89, 37);
		frmAdminFrom.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.setFont(new Font("Sorts Mill Goudy", Font.BOLD | Font.ITALIC, 19));
		btnNewButton_1.setBounds(348, 228, 89, 36);
		frmAdminFrom.getContentPane().add(btnNewButton_1);
	}
}
