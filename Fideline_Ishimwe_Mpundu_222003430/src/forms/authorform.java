package forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Result;

public class authorform implements ActionListener{
	JFrame frame;
	JLabel idlb= new JLabel("AU_ID");
	JLabel fnlb= new JLabel("AU_FNAME");
	JLabel lnlb= new JLabel("AU_LNAME");
	JLabel biolb= new JLabel("AU_biography");
	
	
	JTextField idTextField= new JTextField();
	JTextField fnTextField= new JTextField();
	JTextField lnTextField= new JTextField();
	JTextField bioTextField= new JTextField();
	
	
	JButton insertbtn= new JButton ("INSERT");
	
	
	
	JButton readbtn= new JButton ("READ");
	JButton updatebtn= new JButton ("UPDATE");
	JButton deltebtn= new JButton ("DELTE");
	protected PreparedStatement Ps;
	
	public authorform() {
		createwindows1();
	}
	
	
	private void createwindows1() {
		frame= new JFrame();
		frame.setTitle("AUTHORFORM");
		frame.setBounds(10,10,500,400);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		setsizeandlocation();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	 
	
	private void setsizeandlocation() {
		idlb.setBounds(10,10,200,30);
		fnlb.setBounds(10,50,200,30);
		lnlb.setBounds(10,90,200,30);
		biolb.setBounds(10,130,200,30);
		
		
		idTextField.setBounds(160,10,130,30);
		fnTextField.setBounds(160,50,130,30);
		lnTextField.setBounds(160,90,130,30);
		bioTextField.setBounds(160,130,130,30);
		
		
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
		frame.add(biolb);
		
		frame.add(idTextField);
		
		frame.add(fnTextField);
		frame.add(lnTextField);
		frame.add(bioTextField);
		
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
					String query="INSERT INTO authors VALUES(?,?,?,?)";
					PreparedStatement pStatement=connection.prepareStatement(query);
					pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
					pStatement.setString(2, fnTextField.getText());
					pStatement.setString(3, lnTextField.getText());
					pStatement.setString(4, bioTextField.getText());
					
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
					String sql="UPDATE authors SET  au_fname=?,au_lname=?,au_biography=? WHERE au_id=?";
					PreparedStatement stm=connection.prepareStatement(sql);
				
					stm.setString(1, fnTextField.getText());
					stm.setString(2, lnTextField.getText());
					stm.setString(3, bioTextField .getText());
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
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","","");
					String sql="DELETE FROM authors  WHERE au_id=?";
					int autTextField=Integer.parseInt(JOptionPane.showInputDialog("Enter au_id to delete:"));
					PreparedStatement  pStatement=connection.prepareStatement(sql);
					
					
					 pStatement.setInt(1,autTextField);
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
		biolb.setFont(fontii);
	
		
		idTextField.setFont(fontii);
		fnTextField.setFont(fontii);
		lnTextField.setFont(fontii);
		bioTextField.setFont(fontii);
		
		
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
	
	authorform atf=new authorform();

}


public void setTitle(String string) {
	// TODO Auto-generated method stub
	
}


public void setTitle(boolean b) {
	// TODO Auto-generated method stub
	
}
}

