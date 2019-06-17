package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import Class.DbConnection;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class jframe_Consult extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;

	DefaultTableModel columns;
	Statement st;
	private JTextField textBuscar;
	String atributo="ID_num";
	private JScrollPane scrollPane11SEARCH;
	private JTable tableData2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_Consult frame = new jframe_Consult();
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
	public jframe_Consult() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1221, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ButtonGroup grupo = new ButtonGroup();
		contentPane.setLayout(null);
		
		JLabel lblConsultaPor = new JLabel("Consulta por:");
		lblConsultaPor.setBounds(10, 11, 94, 14);
		contentPane.add(lblConsultaPor);
		
		JRadioButton RBbarra = new JRadioButton("Codigo de barra");
		RBbarra.setBounds(85, 7, 109, 23);
		contentPane.add(RBbarra);
		
		JRadioButton RBbtnNombre = new JRadioButton("Nombre");
		RBbtnNombre.setBounds(209, 7, 109, 23);
		contentPane.add(RBbtnNombre);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(291, 33, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.add(RBbarra);
				grupo.add(RBbtnNombre);
				if(RBbarra.isSelected()) {atributo="ID_num";llenar(textBuscar.getText());}
				else if(RBbtnNombre.isSelected()) {atributo="nombre";llenar(textBuscar.getText());
				}else {
					JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna opción ");
				}
			
			}
		});
		contentPane.add(btnBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(10, 34, 257, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnMostrarTodosLos = new JButton("Mostrar todos los datos");
		btnMostrarTodosLos.setBounds(404, 33, 157, 23);
		btnMostrarTodosLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenar("");
			}
		});
		contentPane.add(btnMostrarTodosLos);
		
		scrollPane11SEARCH = new JScrollPane();
		scrollPane11SEARCH.setEnabled(false);
		scrollPane11SEARCH.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane11SEARCH.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane11SEARCH.setBounds(10, 68, 1184, 295);
		contentPane.add(scrollPane11SEARCH);
		
		tableData2 = new JTable();
		
		scrollPane11SEARCH.setViewportView(tableData2);
		
		
	}
	void llenar(String value) {
		try {
			DbConnection con=new DbConnection();
			String [] titulos= {"ID_num","nombre","nombre_paterno","nombre_materno","Fechanacimiento","numero_personas","numero_hersec","numero_per","numero_des","numero_superper1","numero_superper2","numero_subben"};
			columns=new DefaultTableModel(null,titulos);
			st=(Statement) con.getConnection().createStatement();
			String datos[]=new String[13];//files to save in the table
			
			String query="";
			if(value.equals("")) {
				query="SElECT ID_num,nombre,nombre_paterno,nombre_materno,Fechanacimiento,numero_personas,numero_hersec,numero_per,numero_des,numero_superper1,numero_superper2,numero_subben FROM nummagic ";
			}else {
				
				query="SElECT ID_num,nombre,nombre_paterno,nombre_materno,Fechanacimiento,numero_personas,numero_hersec,numero_per,numero_des,numero_superper1,numero_superper2,numero_subben FROM nummagic WHERE "+atributo+"='"+value+"'";
			
			}
			
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				datos[0]=rs.getString(1);//data table 1
				datos[1]=rs.getString(2);//********
				datos[2]=rs.getString(3);///******
				datos[3]=rs.getString(4);//*******
				datos[4]=rs.getString(5);
				datos[5]=rs.getString(6);
				
				columns.addRow(datos);
			}
			tableData2.setModel(columns);
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
}
