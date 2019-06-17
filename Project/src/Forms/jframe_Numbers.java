package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import Class.DbConnection;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class jframe_Numbers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static DbConnection BD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_Numbers frame = new jframe_Numbers();
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
	public jframe_Numbers() {
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPushMe = new JButton("Push me");
		btnPushMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {	
					 Statement stmt=(Statement) BD.getConnection().createStatement();
					 ResultSet registro=stmt.executeQuery("SElECT data from Info WHERE  ID_in='"+textField.getText()+"'");
					if(registro.next()==true){
						
						textField_1.setText(registro.getString("data"));	
						
					
					
						//registro.setString(13,date);
						
					}else{
						JOptionPane.showMessageDialog(null,"NO existe el Folio ingresado");
						
					}
					
					
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Datos almacenados Incorrectamente /o campo no llenado");
						e1.printStackTrace();
				}		
			}
		});
		btnPushMe.setBounds(159, 70, 89, 23);
		contentPane.add(btnPushMe);
		
		textField = new JTextField();
		textField.setBounds(26, 39, 343, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblWriteSomething = new JLabel("Write something");
		lblWriteSomething.setBounds(26, 4, 290, 14);
		contentPane.add(lblWriteSomething);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 107, 343, 143);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		
		
		
		
		
	}
}
