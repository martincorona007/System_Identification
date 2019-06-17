package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import Class.DbConnection;
import Class.class_aux;
import Class.class_login;
import Hilo.Hilo;


import javax.swing.event.ChangeEvent;
import javax.swing.JPasswordField;

public class jframe_login extends JFrame {

	private JPanel contentPane;
	public static JProgressBar progressBar;
	private static JTextField txt1;
	private static JPasswordField txt2;
	private String username;
	public static String usuarioBienbenida;
	public static Integer in1;
	public static Integer in2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_login frame = new jframe_login();
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

	public jframe_login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				loading();
			}

			
		});
		progressBar.setBounds(88, 131, 298, 14);
		contentPane.add(progressBar);
		
		txt1 = new JTextField();
		
		txt1.setBounds(124, 168, 233, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn();
			}
		});
		btnNewButton.setBounds(297, 261, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(21, 171, 80, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(21, 209, 80, 14);
		contentPane.add(lblNewLabel_1);
	
		txt2 = new JPasswordField();
		txt2.setBounds(124, 206, 233, 20);
		contentPane.add(txt2);
	}

/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
//METHODS
	public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username =user;
    }

	protected void loading() {
		if(progressBar.getValue()==100) {
			jframe_Menu obj1=new jframe_Menu();
			obj1.setVisible(true);
		
			dispose();
		}
	}
	protected void LogIn() {
		
		try{
			if(txt1.getText().length()>0 && txt2.getPassword().length>0 ){
				
				if(checkUser(txt1.getText(),txt2.getPassword())){
					/*jframe_Menu obj1=new jframe_Menu();
					obj1.setVisible(true);
				
					dispose();*/
				
					Hilo barra=new Hilo();
					barra.start();

				
				}else{
					JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contrasenia no son validos.");
                    JOptionPane.showMessageDialog(null, txt1.getText()+" " +txt2.getPassword() );
                    txt1.setText("");
                    //limpiar campos
                    txt2.setText("");        
                     
                    txt2.requestFocusInWindow();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contrasenia.\n" +"NO puede dejar ningun campo vacio");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	boolean checkUser(String User,char[] cs){
		try{
			DbConnection con=new DbConnection();//database
			String admin=jframe_login.txt1.getText();
			String contra=String.valueOf(jframe_login.txt2.getPassword());
			
			//int resultado=0;
			String SSQL="SELECT * FROM Ctrl_user WHERE username='"+admin+"' AND password='"+contra+"'";
			// Statement stmt=connection.createStatement();
			 Statement stmt=con.getConnection().createStatement();  
			 ResultSet rs=stmt.executeQuery(SSQL);
			 
			 class_aux usuario2=new class_aux();
			 class_login usu=new class_login();
			 usu.setUsername(admin);
			 usu.setPassword(contra);
			 System.out.println("ad"+admin);
			 
			 
			 class_login usu3=usuario2.obtenerUsuario(usu);
			 
			 
			usuarioBienbenida=admin;
			
	            if( rs.first() )        // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
	         
	            	return true;        //usuario validado correctamente
	            else
	                return false;
	            
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
