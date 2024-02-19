package forms;

import java.awt.Color;
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

public class RegistrationForm implements ActionListener {
	
	JFrame frame;
	JLabel ulb=new JLabel("ID :");
	JLabel fnlb=new JLabel("NAME:");
	JLabel lnlb=new JLabel("PHONE:");
	JLabel plb=new JLabel("ADDRESS:");
	JLabel emlb=new JLabel("EMAIL :");
	JLabel adlb=new JLabel("USERNAME:");
	JLabel slb=new JLabel("PASSWORD:");
	JLabel hdlb=new JLabel("HIREDDATE:");
	JTextField utxf=new JTextField();
	JTextField fntxf=new JTextField();
	JTextField lntxf=new JTextField();
	JTextField ptxf=new JTextField();
	JTextField emtxf=new JTextField();
	JTextField adtxf=new JTextField();
	JTextField stxf=new JTextField();
	JTextField hdtxf=new JTextField();
	JButton sendbtn=new JButton("SEND");
	JButton conbtn=new JButton("CANCEL");
	RegistrationForm(){
		createwindow();
	}
	private void createwindow() {
		frame=new JFrame();
		frame.setTitle("CREATE ACCOUNT");
		frame.setBounds(10,10, 500, 500);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		setsizeandlocation();
		
	}
	private void setsizeandlocation() {
	ulb.setBounds(10, 10, 200, 30);	
	fnlb.setBounds(10, 60, 200, 30);
	lnlb.setBounds(10, 110, 200, 30);
	plb.setBounds(10, 160, 200, 30);
	emlb.setBounds(10, 210, 200, 30);
	adlb.setBounds(10, 260, 200, 30);
	slb.setBounds(10, 310, 200, 30);
	hdlb.setBounds(10, 370, 200, 30);
	utxf.setBounds(200, 10, 200, 30);
	fntxf.setBounds(200, 60, 200, 30);
	lntxf.setBounds(200, 110, 200, 30);
	ptxf.setBounds(200, 160, 200, 30);
	emtxf.setBounds(200, 210, 200, 30);
	adtxf.setBounds(200, 260, 200, 30);
     stxf.setBounds(200, 310, 200, 30);
     hdtxf.setBounds(200, 370, 200, 30);
     sendbtn.setBounds(100, 420,90, 40);
     conbtn.setBounds(300, 420, 90, 40);
     addcomponent();
     
	}
	private void addcomponent() {
		frame.add(ulb);
		frame.add(fnlb);
		frame.add(lnlb);
		frame.add(plb);
		frame.add(emlb);
		frame.add(adlb);
		frame.add(slb);
		frame.add(hdlb);
		frame.add(utxf);
		frame.add(fntxf);
		frame.add(lntxf);
		frame.add(ptxf);
		frame.add(emtxf);
		frame.add(adtxf);
		frame.add(stxf);
		frame.add(hdtxf);
        frame.add(sendbtn);
        frame.add(conbtn);
        ActionEvent();
	}
	private void ActionEvent() {
		sendbtn.addActionListener(this);
		sendbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_l_m_s","222003430","222003430");
					String query="INSERT INTO registration VALUES(?,?,?,?,?,?,?,?)";
					PreparedStatement pStatement=connection.prepareStatement(query);
					pStatement.setInt(1,Integer.parseInt(utxf.getText()));
					pStatement.setString(2, fntxf.getText());
					pStatement.setString(3, lntxf.getText());
					pStatement.setString(4, ptxf.getText());
					pStatement.setString(5, emtxf.getText());
					pStatement.setString(6, adtxf.getText());
					pStatement.setString(7, stxf.getText());
					pStatement.setString(8, hdtxf.getText());
					pStatement.executeUpdate();
					JOptionPane.showMessageDialog(sendbtn, "data inserted well");
					pStatement.close();
					connection.close();	
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
				
			}
		});
		conbtn.addActionListener(this);
		
		conbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utxf.setText("");
				fntxf.setText("");
				lntxf.setText("");
				ptxf.setText("");
				emtxf.setText("");
				adtxf.setText("");
				stxf.setText("");
				hdtxf.setText("");
				
			}
		});
		
	}
	public static void main(String[] args) {
		RegistrationForm emp=new RegistrationForm();
				

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}

