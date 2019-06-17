package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import Class.DbConnection;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;



public class jframe_Insert extends JFrame {

	private JPanel contentPane;
	private static DbConnection BD;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JButton btnInsert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_Insert frame = new jframe_Insert();
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
	public jframe_Insert() {
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(10, 56, 89, 20);
		contentPane.add(lblNombre);
		
		JLabel lblNombrePaterno = new JLabel("nombre paterno");
		lblNombrePaterno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombrePaterno.setBounds(10, 84, 140, 26);
		contentPane.add(lblNombrePaterno);
		
		JLabel lblNombreMaterno = new JLabel("nombre materno");
		lblNombreMaterno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombreMaterno.setBounds(10, 121, 140, 14);
		contentPane.add(lblNombreMaterno);
		
		JLabel lblFechaDeNacimiento = new JLabel("fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFechaDeNacimiento.setBounds(10, 159, 166, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblNumeroPersonas = new JLabel("numero personas");
		lblNumeroPersonas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroPersonas.setBounds(10, 184, 140, 14);
		contentPane.add(lblNumeroPersonas);
		
		JLabel lblNumeroHersec = new JLabel("numero hersec");
		lblNumeroHersec.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroHersec.setBounds(10, 215, 140, 14);
		contentPane.add(lblNumeroHersec);
		
		JLabel lblNumeroPer = new JLabel("numero per");
		lblNumeroPer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroPer.setBounds(10, 240, 140, 26);
		contentPane.add(lblNumeroPer);
		
		JLabel lblNumeroDes = new JLabel("numero des");
		lblNumeroDes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroDes.setBounds(10, 277, 140, 14);
		contentPane.add(lblNumeroDes);
		
		JLabel lblNumeroSuper = new JLabel("numero super1");
		lblNumeroSuper.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroSuper.setBounds(10, 314, 140, 14);
		contentPane.add(lblNumeroSuper);
		
		JLabel lblNumeroSuper_1 = new JLabel("numero super2");
		lblNumeroSuper_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroSuper_1.setBounds(10, 348, 140, 14);
		contentPane.add(lblNumeroSuper_1);
		
		JLabel lblNumeroSubben = new JLabel("numero subben");
		lblNumeroSubben.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroSubben.setBounds(10, 378, 140, 14);
		contentPane.add(lblNumeroSubben);
		
		textField = new JTextField();
		textField.setBounds(160, 56, 264, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 90, 264, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 126, 264, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 159, 264, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 184, 264, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(160, 215, 264, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(160, 246, 264, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(160, 277, 264, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(160, 314, 264, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(160, 348, 264, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(160, 378, 264, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					String query="INSERT INTO nummagic(nombre,nombre_paterno,nombre_materno,Fechanacimiento,numero_personas,numero_hersec,numero_per,numero_des,numero_superper1,numero_superper2,numero_subben) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement=(PreparedStatement) BD.getConnection().prepareStatement(query);
					//PreparedStatement statement = (PreparedStatement) BD.getConnection().prepareStatement(query);
					//InsertToDataBase(txtFolio_ID.getText(),textPropietario.getText(),textCP.getText(),textLFDExpedicion.getText(),textKeyVehicular.getText(),textRecaudadora.getText(),textPlacas.getText(),textMarca.getText(),textLSubmarca.getText(),textVersion.getText(),textModelo.getText(),textColor_1.getText(),textColor_2.getText(),textSerie.getText(),textMotor.getText(),textNRPVDOC_REG.getText(),comboBoxMov.getSelectedItem().toString(),comboBoxProce.getSelectedItem().toString(),comboBoxCombus.getSelectedItem().toString(),comboxBoxServi.getSelectedItem().toString(),comboBoxUso.getSelectedItem().toString(),comboBoxClase.getSelectedItem().toString(),comboBoxTipo.getSelectedItem().toString(),comboBoxCilindros.getSelectedItem().toString(),comboBoxPuerta.getSelectedItem().toString(),textPasajKG.getText());
				
				statement.setString(1,textField.getText());	
				statement.setString(2,textField_1.getText());
				statement.setString(3,textField_2.getText());
				statement.setString(4,textField_3.getText());
				statement.setInt(5, Integer.parseInt(textField_4.getText()));
				statement.setInt(6, Integer.parseInt(textField_5.getText()));
				statement.setInt(7, Integer.parseInt(textField_6.getText()));
				statement.setInt(8, Integer.parseInt(textField_7.getText()));
				statement.setInt(9, Integer.parseInt(textField_8.getText()));
				statement.setInt(10, Integer.parseInt(textField_9.getText()));
				statement.setInt(11, Integer.parseInt(textField_10.getText()));
				
				statement.executeUpdate();
				BD.desconectar();
				
				JOptionPane.showMessageDialog(null,"Datos almacenados correctamente");
				textField.setText("");	
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				
			} catch (Exception eps) {
				JOptionPane.showMessageDialog(null,"Datos almacenados Incorrectamente /o campo no llenado");
					eps.printStackTrace();
				}
			}
		});
		btnInsert.setBounds(335, 411, 89, 23);
		contentPane.add(btnInsert);
	}

}
