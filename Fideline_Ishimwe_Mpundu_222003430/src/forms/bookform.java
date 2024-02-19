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
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class bookform implements ActionListener {
    JFrame frame;
    JLabel idlb = new JLabel("Book_ID");
    JLabel isbnlb = new JLabel("Book_ISBN");
    JLabel titllb = new JLabel("Book_TITLE");
    JLabel pubyrllb = new JLabel("Book_PUBYEAR");

    JTextField idTextField = new JTextField();
    JTextField isbnTextField = new JTextField();
    JTextField titlTextField = new JTextField();
    JTextField pubyrTextField = new JTextField();

    JButton insertbtn = new JButton("INSERT");
    JButton updatebtn = new JButton("UPDATE");
    JButton deltebtn = new JButton("DELETE");
    JButton viewbtn = new JButton("VIEW");

    JTable tt = new JTable();

    public bookform() {
        createwindows3();
    }

    private void createwindows3() {
        frame = new JFrame();
        frame.setTitle(" BookForm  ");
        frame.setBounds(10, 10, 500, 400);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.getContentPane().setLayout(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setsizeandlocation();

    }

    private void setsizeandlocation() {
        idlb.setBounds(10, 10, 200, 30);
        titllb.setBounds(10, 50, 200, 30);
        isbnlb.setBounds(10, 90, 200, 30);
        pubyrllb.setBounds(10, 130, 200, 30);

        idTextField.setBounds(160, 10, 130, 30);
        titlTextField.setBounds(160, 50, 130, 30);
        isbnTextField.setBounds(160, 90, 130, 30);
        pubyrTextField.setBounds(160, 130, 130, 30);

        insertbtn.setBounds(10, 200, 85, 30);
        updatebtn.setBounds(100, 200, 85, 30);
        deltebtn.setBounds(190, 200, 85, 30);
        viewbtn.setBounds(280, 200, 85, 30);
        addcomponenttoframe();

    }

    private void addcomponenttoframe() {
        frame.add(idlb);
        frame.add(titllb);
        frame.add(isbnlb);
        frame.add(pubyrllb);
        frame.add(idTextField);

        frame.add(titlTextField);
        frame.add(isbnTextField);
        frame.add(pubyrTextField);
        frame.add(insertbtn);
        frame.add(updatebtn);
        frame.add(deltebtn);
        frame.add(viewbtn);
        ActionEvent();
    }

    private void ActionEvent() {
        insertbtn.addActionListener(this);
        updatebtn.addActionListener(this);
        deltebtn.addActionListener(this);
        viewbtn.addActionListener(this);
        setFontforall();
    }

    private void setFontforall() {
        Font fontii = new Font("Georgia", Font.ITALIC, 18);
        idlb.setFont(fontii);
        titllb.setFont(fontii);
        isbnlb.setFont(fontii);
        pubyrllb.setFont(fontii);

        idTextField.setFont(fontii);
        titlTextField.setFont(fontii);
        isbnTextField.setFont(fontii);
        pubyrTextField.setFont(fontii);

        Font fii = new Font("CourierNew", Font.BOLD, 12);
        insertbtn.setFont(fii);
        updatebtn.setFont(fii);
        deltebtn.setFont(fii);
        viewbtn.setFont(fii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertbtn) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_lms", "222003430",
                        "");
                String query = "INSERT INTO book VALUES(?,?,?,?)";
                PreparedStatement pStatement = connection.prepareStatement(query);
                pStatement.setInt(1, Integer.parseInt(idTextField.getText()));
                pStatement.setString(2, titlTextField.getText());
                pStatement.setString(3, isbnTextField.getText());
                pStatement.setInt(4, Integer.parseInt(pubyrTextField.getText()));

                pStatement.executeUpdate();
                JOptionPane.showMessageDialog(insertbtn, "Data inserted successfully");
                pStatement.close();
                connection.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        } else if (e.getSource() == updatebtn) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_lms", "222003430",
                        "");
                String sql = "UPDATE books SET book_title=?, book_isbn=?, book_pubyear=? WHERE book_id=?";
                PreparedStatement stm = connection.prepareStatement(sql);

                stm.setString(1, titlTextField.getText());
                stm.setString(2, isbnTextField.getText());
                stm.setInt(3, Integer.parseInt(pubyrTextField.getText()));
                stm.setInt(4, Integer.parseInt(idTextField.getText()));
                stm.executeUpdate();
                JOptionPane.showMessageDialog(updatebtn, "Data updated successfully!");
                stm.close();
                connection.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        } else if (e.getSource() == deltebtn) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fideline_ishimwe_mpundu_lms", "222003430",
                        "");
                String sql = "DELETE FROM book  WHERE book_id=?";
                int bookIdToDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter book_id to delete:"));
                PreparedStatement pStatement = connection.prepareStatement(sql);

                pStatement.setInt(1, bookIdToDelete);
                pStatement.executeUpdate();
                JOptionPane.showMessageDialog(deltebtn, "Record deleted successfully!");
                pStatement.close();
                connection.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        } else if (e.getSource() == viewbtn) {
            // Perform action for view button here
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root",
                        "");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Book_ID");
                model.addColumn("Book_Title");
                model.addColumn("Book_ISBN");
                model.addColumn("Book_PUBYEAR");

                while (resultSet.next()) {
                    Object[] row = new Object[4];
                    row[0] = resultSet.getInt("book_id");
                    row[1] = resultSet.getString("book_title");
                    row[2] = resultSet.getString("book_isbn");
                    row[3] = resultSet.getInt("book_pubyear");
                    model.addRow(row);
                }

                JTable table = new JTable(model);
                JOptionPane.showMessageDialog(viewbtn, table);
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        bookform atf = new bookform();
    }

	public static void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}