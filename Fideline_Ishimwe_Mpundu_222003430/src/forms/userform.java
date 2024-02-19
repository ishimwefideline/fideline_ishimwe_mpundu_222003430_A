package forms;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class userform implements ActionListener{
	JFrame frame;
	JLabel idlb= new JLabel("ID");
	JLabel fnlb= new JLabel("FIRSTNAME");
	JLabel lnlb= new JLabel("LASTNAME");
	JLabel addlb1= new JLabel("ADDRESS");
	JLabel cntlb1= new JLabel("CONTACT");
	JLabel bdlb1= new JLabel("BIRTHDATE");
	JLabel uslb1= new JLabel("USERNAME");
	JLabel pslb1= new JLabel("PASSWORD");
	
	JTextField idTextField= new JTextField();
	JTextField fnTextField= new JTextField();
	JTextField lnTextField= new JTextField();
	JTextField addTextField= new JTextField();
	JTextField cntTextField= new JTextField();
	JTextField bdTextField= new JTextField();
	JTextField usTextField= new JTextField();
	JTextField psTextField= new JTextField();
	
	JButton insertbtn= new JButton ("INSERT");
	JButton readbtn= new JButton ("READ");
	JButton updatebtn= new JButton ("UPDATE");
	JButton deltebtn= new JButton ("DELTE");
	private Component addlb;
	private Component cntlb;
	
	public userform  () {
		createwindows2();
	}
	
	
	private void createwindows2() {
		frame= new JFrame();
		frame.setTitle(" UserForm  ");
		frame.setBounds(10,10,500,400);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setsizeandlocation();
			
	}
	 
	
	private void setsizeandlocation() {
		idlb.setBounds(10,10,200,30);
		fnlb.setBounds(10,50,200,30);
		lnlb.setBounds(10,90,200,30);
		addlb1.setBounds(10,130,200,30);
		cntlb1.setBounds(10,170,200,30);
		bdlb1.setBounds(10,210,200,30);
		uslb1.setBounds(10,250,200,30);
		pslb1.setBounds(10,290,200,30);
		idTextField.setBounds(160,10,130,30);
		fnTextField.setBounds(160,50,130,30);
		lnTextField.setBounds(160,90,130,30);
		addTextField.setBounds(160,130,130,30);
		cntTextField.setBounds(160,170,130,30);
		bdTextField.setBounds(160,210,130,30);
		usTextField.setBounds(160,250,130,30);
		psTextField.setBounds(160,290,130,30);
		insertbtn.setBounds(10,330,85,30);
		readbtn.setBounds(100,330,85,30);
		updatebtn.setBounds(190,330,85,30);
		deltebtn.setBounds(280,330,85,30);
		addcomponenttoframe();
		
		// TODO Auto-generated method stub
		
	}


	private void addcomponenttoframe() {
		frame.add(idlb);
		frame.add(fnlb);
		frame.add(lnlb);
		frame.add(addlb1);
		frame.add(cntlb1);
		frame.add(uslb1);
		frame.add(pslb1);
		frame.add(bdlb1);
		frame.add(idTextField);
		frame.add(fnTextField);
		frame.add(lnTextField);
		frame.add(addTextField);
		frame.add(cntTextField);
		frame.add(bdTextField);
		frame.add(usTextField);
		frame.add(psTextField);
		frame.add(insertbtn);
		frame.add(readbtn);
		frame.add(updatebtn);
		frame.add(deltebtn);
		ActionEvent();
		
		
		
		
		// TODO Auto-generated method stub
		
	}


	private void ActionEvent() {
		insertbtn.addActionListener(this);
insertbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_lms","222003430","222003430");
					String query="INSERT INTO user VALUES(?,?,?,?,?,?,?,?)";
					PreparedStatement pStatement=connection.prepareStatement(query);
					pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
					pStatement.setString(2, fnTextField.getText());
					pStatement.setString(3, lnTextField.getText());
					pStatement.setString(4, addTextField.getText());
					pStatement.setString(5, cntTextField.getText());
					pStatement.setString(6, bdTextField.getText());
					pStatement.setString(7, usTextField.getText());
					pStatement.setString(8, psTextField.getText());
					pStatement.executeUpdate();
					JOptionPane.showMessageDialog(insertbtn, "data inserted well");
					pStatement.close();
					connection.close();	
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
				
			}
		});	
		readbtn.addActionListener(this);
		

		updatebtn.addActionListener(this);
updatebtn.addActionListener(new ActionListener() {
				
			
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","222003430","222003430");
					String sql="UPDATE user SET  firstname=?,lastname=?,address=?,contact=?,birthdate=?,username=?,password=? WHERE id=?";
					PreparedStatement stm=conn.prepareStatement(sql);
					
					stm.setString(1, fnTextField.getText());
					stm.setString(2, lnTextField.getText());
					stm.setString(3, addTextField.getText());
					stm.setString(4, cntTextField.getText());
					stm.setString(5, bdTextField.getText());
					stm.setString(6, usTextField.getText());
					stm.setString(7, psTextField.getText());
					stm.setInt(8,Integer.parseInt(idTextField.getText()));
					stm.executeUpdate();
					JOptionPane.showMessageDialog(updatebtn, "update data!");
					stm.close();
					conn.close();	
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});	
		deltebtn.addActionListener(this);
        deltebtn.addActionListener(new ActionListener() {
				
			
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_lms","222003430","222003430");
					String query="DELETE FROM useraccount WHERE id=?";
					int usTextField=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:"));
					PreparedStatement pStatement=connection.prepareStatement(query);
					pStatement.setInt(1,usTextField);
					JOptionPane.showMessageDialog(deltebtn, "recorded out!!!!!!!!!");
					Component delete;
					pStatement.executeUpdate();
					pStatement.close();
					connection.close();	
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
				
			}
		});	
		setFontforall();
		
		
		
		
	}



	
	private void setFontforall() {
		
		Font fontii= new Font("Georgia", Font.ITALIC,18); 
		idlb.setFont(fontii);
		fnlb.setFont(fontii);
		lnlb.setFont(fontii);
		addlb1.setFont(fontii);
		cntlb1.setFont(fontii);
		bdlb1.setFont(fontii);
		uslb1.setFont(fontii);
		pslb1.setFont(fontii);
		
		
		idTextField.setFont(fontii);
		fnTextField.setFont(fontii);
		lnTextField.setFont(fontii);
		addTextField.setFont(fontii);
		cntTextField.setFont(fontii);
		bdTextField.setFont(fontii);
		usTextField.setFont(fontii);
		psTextField.setFont(fontii);
		Font fii=new Font("CourierNew",Font.BOLD,12);
		insertbtn.setFont(fii);
		readbtn.setFont(fii);
		updatebtn.setFont(fii);
		deltebtn.setFont(fii);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



public static void main(String[] args) {
	userform atf=new userform ();

}


public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}


public void setVisible(String string) {
	// TODO Auto-generated method stub
	
}


public void setTitle(String string) {
	// TODO Auto-generated method stub
	
}
}


