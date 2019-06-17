package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import Class.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class jframe_Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textDelete;
	private JButton btnDelete;
	private static DbConnection BD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_Delete frame = new jframe_Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jframe_Delete() {
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(75, 21, 63, 30);
		contentPane.add(lblId);
		
		textDelete = new JTextField();
		textDelete.setBounds(148, 21, 185, 30);
		contentPane.add(textDelete);
		textDelete.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = (Statement) BD.getConnection().createStatement();
					//Statement stmt2 = (Statement) BD.getConnection().createStatement();
					stmt.execute("DELETE FROM nummagic WHERE ID_num="+textDelete.getText());
					//stmt2.execute("INSERT INTO libros_vendidos WHERE id_librovendido="+textDelete.getText());
					
					JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente");
					
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,"No ha eliminado correctamente");
					ex.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(319, 108, 89, 23);
		contentPane.add(btnDelete);
	}

}
