package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import Class.DbConnection;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class jframe_insertUsers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static DbConnection BD;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_insertUsers frame = new jframe_insertUsers();
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
	public jframe_insertUsers() {
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 19, 222, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(10, 11, 150, 50);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(10, 11, 150, 127);
		contentPane.add(lblPassword);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserType.setBounds(10, 73, 150, 68);
		contentPane.add(lblUserType);
		
		JLabel lblUserPermits = new JLabel("User Permits");
		lblUserPermits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserPermits.setBounds(10, 136, 150, 15);
		contentPane.add(lblUserPermits);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "admin", "user"}));
		comboBox.setBounds(170, 101, 222, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "search", "search/insert", "search/insert/delete", "search/insert/delete/update"}));
		comboBox_1.setBounds(170, 137, 222, 25);
		contentPane.add(comboBox_1);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {	
					String query="INSERT INTO Ctrl_user(username,password,FK_user_type,FK_permit_type)  values(?,?,?,?)";
				PreparedStatement statement=(PreparedStatement) BD.getConnection().prepareStatement(query);
					//PreparedStatement statement = (PreparedStatement) BD.getConnection().prepareStatement(query);
					//InsertToDataBase(txtFolio_ID.getText(),textPropietario.getText(),textCP.getText(),textLFDExpedicion.getText(),textKeyVehicular.getText(),textRecaudadora.getText(),textPlacas.getText(),textMarca.getText(),textLSubmarca.getText(),textVersion.getText(),textModelo.getText(),textColor_1.getText(),textColor_2.getText(),textSerie.getText(),textMotor.getText(),textNRPVDOC_REG.getText(),comboBoxMov.getSelectedItem().toString(),comboBoxProce.getSelectedItem().toString(),comboBoxCombus.getSelectedItem().toString(),comboxBoxServi.getSelectedItem().toString(),comboBoxUso.getSelectedItem().toString(),comboBoxClase.getSelectedItem().toString(),comboBoxTipo.getSelectedItem().toString(),comboBoxCilindros.getSelectedItem().toString(),comboBoxPuerta.getSelectedItem().toString(),textPasajKG.getText());
				
				statement.setString(1,textField.getText());	
				statement.setString(2,textField_1.getText());
				String v1=comboBox.getSelectedItem().toString();
				
				String v2=comboBox_1.getSelectedItem().toString();
				
				if(v1=="user") {
					statement.setInt(3,1);
						
				}else if(v1=="admin"){
					statement.setInt(3,2);
					
				}
				
				if(v2=="search") {
					statement.setInt(4,1);
				}else if(v2=="search/insert") {
					statement.setInt(4,2);
				}else if(v2=="search/insert/delete") {
					statement.setInt(4,3);
				}else if(v2=="search/insert/delete/update") {
					statement.setInt(4,4);
				}
			
				
				statement.executeUpdate();
				BD.desconectar();
				
				JOptionPane.showMessageDialog(null,"Datos almacenados correctamente");
				textField.setText("");	
				textField_1.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
			
				
				
				
					/*Statement stmt=BD.getConnection().createStatement();
				String query="";
					stmt.executeUpdate(query);
					*/
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Datos almacenados Incorrectamente /o campo no llenado");
					ex.printStackTrace();
				}
				
			}
		});
		btnInsert.setBounds(335, 190, 89, 23);
		contentPane.add(btnInsert);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 68, 223, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
