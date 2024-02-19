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

public class langaugeform implements ActionListener{
	JFrame frame;
	JLabel idlb= new JLabel("Lng_ID");
	JLabel fnlb= new JLabel("Lng_FNAME");
	JLabel lnlb= new JLabel("Lng_LNAME");
	JLabel ctrlb1= new JLabel("Lng_COUNTRY");
	
	
	JTextField idTextField= new JTextField();
	JTextField fnTextField= new JTextField();
	JTextField lnTextField= new JTextField();
	JTextField ctrTextField= new JTextField();
	
	
	JButton insertbtn= new JButton ("INSERT");
	JButton readbtn= new JButton ("READ");
	JButton updatebtn= new JButton ("UPDATE");
	JButton deltebtn= new JButton ("DELTE");
	

	
	public langaugeform () {
		createwindows2();
	}
	
	
	private void createwindows2() {
		frame= new JFrame();
		frame.setTitle("LanguageForm  ");
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
		ctrlb1.setBounds(10,130,200,30);
		
		
		idTextField.setBounds(160,10,130,30);
		fnTextField.setBounds(160,50,130,30);
		lnTextField.setBounds(160,90,130,30);
		ctrTextField.setBounds(160,130,130,30);
		
		
		insertbtn.setBounds(10,250,85,30);
		readbtn.setBounds(100,250,85,30);
		updatebtn.setBounds(190,250,85,30);
		deltebtn.setBounds(280,250,85,30);
		addcomponenttoframe();
		
		// TODO Auto-generated method stub
		
	}


	private void addcomponenttoframe() {
		frame.add(idlb);
		frame.add(fnlb);
		frame.add(lnlb);
		frame.add(ctrlb1);
		frame.add(idTextField);
		
		frame.add(fnTextField);
		frame.add(lnTextField);
		frame.add(ctrTextField);
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
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","222003430","222003430");
					String query="INSERT INTO language VALUES(?,?,?,?)";
					PreparedStatement pStatement=connection.prepareStatement(query);
					pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
					pStatement.setString(2, fnTextField.getText());
					pStatement.setString(3, lnTextField.getText());
					pStatement.setString(4, ctrTextField.getText());
				
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
					String sql="UPDATE language SET lng_fname=?,lng_lname=?,lng_country=? WHERE lng_id=?";
					PreparedStatement stm=connection.prepareStatement(sql);
					
					stm.setString(1, fnTextField.getText());
					stm.setString(2, lnTextField.getText());
					stm.setString(3, ctrTextField.getText());
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
					String query="DELETE FROM language  WHERE lng_id=?";
					int lgTextField=Integer.parseInt(JOptionPane.showInputDialog("Enter lng_id to delete:"));
					PreparedStatement  pStatement =connection.prepareStatement(query);
					
					
					
					
					 pStatement.setInt(1,lgTextField);
					
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
		ctrlb1.setFont(fontii);
		
		idTextField.setFont(fontii);
		fnTextField.setFont(fontii);
		lnTextField.setFont(fontii);
		ctrTextField.setFont(fontii);

		
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
	langaugeform  atf=new langaugeform ();

}
}


