package forms;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class borrowingform implements ActionListener{
	JFrame frame;
	JLabel idlb= new JLabel("ID");
	JLabel rtrn_dtelb= new JLabel(" RETURN_DATE");
	JLabel brrw_dtelb= new JLabel("BORROWING_DATE");
	JLabel amntlb= new JLabel("AMOUNT");
	
	
	JTextField idTextField= new JTextField();
	JTextField rtrn_dteTextField= new JTextField();
	JTextField  brrw_dteTextField= new JTextField();
	JTextField amntTextField= new JTextField();
	
	
	JButton insertbtn= new JButton ("INSERT");
	JButton readbtn= new JButton ("READ");
	JButton updatebtn= new JButton ("UPDATE");
	JButton deltebtn= new JButton ("DELTE");
	

	
	public borrowingform () {
		createwindows3();
	}
	
	
	private void createwindows3() {
		frame= new JFrame();
		frame.setTitle("BorrowingForm");
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
		rtrn_dtelb.setBounds(10,50,200,30);
		brrw_dtelb.setBounds(10,90,200,30);
		amntlb.setBounds(10,130,200,30);
		
		
		idTextField.setBounds(200,10,130,30);
		rtrn_dteTextField.setBounds(200,50,130,30);
		brrw_dteTextField.setBounds(200,90,130,30);
		amntTextField.setBounds(200,130,130,30);
		
		
		insertbtn.setBounds(10,180,85,30);
		readbtn.setBounds(100,180,85,30);
		updatebtn.setBounds(190,180,85,30);
		deltebtn.setBounds(280,180,85,30);
		addcomponenttoframe();
		
		// TODO Auto-generated method stub
		
	}


	private void addcomponenttoframe() {
		frame.add(idlb);
		frame.add(rtrn_dtelb);
		frame.add(brrw_dtelb);
		frame.add(amntlb);
		frame.add(idTextField);
		
		frame.add(rtrn_dteTextField);
		frame.add(brrw_dteTextField);
		frame.add(amntTextField);
		frame.add(insertbtn);
		frame.add(readbtn);
		frame.add(updatebtn);
		frame.add(deltebtn);
		ActionEvent();
		
		
			
	}
		private void ActionEvent() {
			insertbtn.addActionListener(this);
			insertbtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","222003430","222003430");
						String query="INSERT INTO borrowing VALUES(?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
						pStatement.setString(2, rtrn_dteTextField.getText());
						pStatement.setString(3, brrw_dteTextField.getText());
						pStatement.setInt(4,Integer.parseInt(amntTextField.getText()));
					
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
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","222003430","222003430");
					String sql="UPDATE borrowing SET return_date=?,borrowing_date=?,amount=? WHERE id=?";
					PreparedStatement stm=connection.prepareStatement(sql);
				
					stm.setString(1, rtrn_dteTextField.getText());
					stm.setString(2, brrw_dteTextField.getText());
					stm.setInt(3,Integer.parseInt(amntTextField.getText()));
					stm.setInt(4,Integer.parseInt(idTextField.getText()));
					stm.executeUpdate();
					JOptionPane.showMessageDialog(updatebtn, "update data!");
					stm.close();
					connection.close();	
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
				
			}
		});	
		deltebtn.addActionListener(this);
deltebtn.addActionListener(new ActionListener() {
				
			
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","222003430","222003430");
					String sql="DELETE FROM borrowing  WHERE id=?";
					int brtxf=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:"));
					
					
					PreparedStatement  pStatement=connection.prepareStatement(sql);
					
					
					
					
					 pStatement.setInt(1,brtxf);
					
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
		rtrn_dtelb.setFont(fontii);
		brrw_dtelb.setFont(fontii);
		amntlb.setFont(fontii);
		
		idTextField.setFont(fontii);
		rtrn_dteTextField.setFont(fontii);
		brrw_dteTextField.setFont(fontii);
		amntTextField.setFont(fontii);
		

		
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
borrowingform  atf= new borrowingform();

}
}



