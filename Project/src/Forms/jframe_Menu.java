package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import Class.DbConnection;
import Class.class_login;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class jframe_Menu extends JFrame {

	
	
	private JPanel contentPane;
	private JLabel lblusu;
	private static DbConnection BD;
	private JLabel lblWelcome;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRTU;
	private JLabel lblTP;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_Menu frame = new jframe_Menu();
					
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
	public jframe_Menu() {
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 719, 132);
		contentPane.add(menuBar);
		

		
		lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(10, 143, 79, 21);
		contentPane.add(lblWelcome);
		
		lblNewLabel = new JLabel("Type User");
		lblNewLabel.setBounds(10, 182, 79, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Type permits");
		lblNewLabel_1.setBounds(10, 221, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		lblRTU = new JLabel("null");
		lblRTU.setBounds(109, 182, 245, 14);
		contentPane.add(lblRTU);
		
		lblTP = new JLabel("");
		lblTP.setBounds(109, 221, 245, 14);
		contentPane.add(lblTP);
		
		
	
	
		
		lblusu = new JLabel("New label");
		lblusu.setBounds(99, 143, 275, 21);
		contentPane.add(lblusu);
		
		String aux; 
		lblusu.setText(jframe_login.usuarioBienbenida);
		
		
		aux=jframe_login.usuarioBienbenida;
		
		
		
		/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||SEARCH THE USER ON THE TABLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
		String cant="";
		String cant2="";
        try {
            Statement st = (Statement) BD.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Ctrl_user WHERE username='"+aux+"'");
            while(rs.next())
            {
                cant=rs.getString(4);
                cant2=rs.getString(5);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	
        System.out.println("1"+cant);
        System.out.println("2"+cant2);

		/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||SEARCH THE USER ON THE TABLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	
        int catt=Integer.parseInt(cant);
        int permits=Integer.parseInt(cant2);
        int catt2=permits;
        if(catt==1) {
        	lblRTU.setText("USER");
        }else if(catt==2) {
        	lblRTU.setText("ADMIN");
        }
        if(catt2==1) {
        	lblTP.setText("search");
        }else if(catt2==2) {
        	lblTP.setText("search/insert");
        }else if(catt2==3) {
        	lblTP.setText("search/insert/delete");
        }else if(catt2==4) {
        	lblTP.setText("search/insert/delete/update");
        }
        

		
		
		if(permits==1) {
/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/		
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnInsert = new JMenu("Insert");
			mnInsert.setEnabled(false);
			mnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insert();
				}
			});
			mnInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnInsert);

			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnDelete = new JMenu("delete");
			mnDelete.setEnabled(false);
			mnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					delete();
				}
			});
			mnDelete.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/icon.png")));
			menuBar.add(mnDelete);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnUpdate = new JMenu("Update");
			mnUpdate.setEnabled(false);
			mnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					update();
				}
			});
			mnUpdate.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Misc-Download-Database-icon.png")));
			menuBar.add(mnUpdate);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnSearch = new JMenu("Search");
			mnSearch.setEnabled(true);
			mnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					search();
				}
			});
			mnSearch.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/picture-search-icon.png")));
			menuBar.add(mnSearch);
			JMenu mnIInsert = new JMenu("Insert Users");
			mnIInsert.setEnabled(false);
			mnIInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insertU();
				}
			});
			mnIInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnIInsert);
		}else if(permits==2) {
/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnInsert = new JMenu("Insert");
			mnInsert.setEnabled(true);
			mnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insert();
				}
			});
			mnInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnInsert);

			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnDelete = new JMenu("delete");
			mnDelete.setEnabled(false);
			mnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					delete();
				}
			});
			mnDelete.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/icon.png")));
			menuBar.add(mnDelete);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnUpdate = new JMenu("Update");
			mnUpdate.setEnabled(false);
			mnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					update();
				}
			});
			mnUpdate.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Misc-Download-Database-icon.png")));
			menuBar.add(mnUpdate);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnSearch = new JMenu("Search");
			mnSearch.setEnabled(true);
			mnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					search();
				}
			});
			mnSearch.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/picture-search-icon.png")));
			menuBar.add(mnSearch);
			JMenu mnIInsert = new JMenu("Insert Users");
			mnIInsert.setEnabled(false);
			mnIInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insertU();
				}
			});
			mnIInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnIInsert);
		}else if(permits==3) {
/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnInsert = new JMenu("Insert");
			mnInsert.setEnabled(true);
			mnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insert();
				}
			});
			mnInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnInsert);

			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnDelete = new JMenu("delete");
			mnDelete.setEnabled(true);
			mnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					delete();
				}
			});
			mnDelete.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/icon.png")));
			menuBar.add(mnDelete);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnUpdate = new JMenu("Update");
			mnUpdate.setEnabled(false);
			mnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					update();
				}
			});
			mnUpdate.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Misc-Download-Database-icon.png")));
			menuBar.add(mnUpdate);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnSearch = new JMenu("Search");
			mnSearch.setEnabled(true);
			mnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					search();
				}
			});
			mnSearch.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/picture-search-icon.png")));
			menuBar.add(mnSearch);
			JMenu mnIInsert = new JMenu("Insert Users");
			mnIInsert.setEnabled(false);
			mnIInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insertU();
				}
			});
			mnIInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnIInsert);
		}else if(permits==4) {
/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnInsert = new JMenu("Insert");
			mnInsert.setEnabled(true);
			mnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insert();
				}
			});
			mnInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnInsert);

			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnDelete = new JMenu("delete");
			mnDelete.setEnabled(true);
			mnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				delete();
				}
			});
			mnDelete.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/icon.png")));
			menuBar.add(mnDelete);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnUpdate = new JMenu("Update");
			mnUpdate.setEnabled(true);
			mnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					update();
				}
			});
			mnUpdate.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Misc-Download-Database-icon.png")));
			menuBar.add(mnUpdate);
			/*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
			JMenu mnSearch = new JMenu("Search");
			mnSearch.setEnabled(true);
			mnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					search();
				}
			});
			mnSearch.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/picture-search-icon.png")));
			menuBar.add(mnSearch);
			
			JMenu mnIInsert = new JMenu("Insert Users");
			mnIInsert.setEnabled(true);
			mnIInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insertU();
				}
			});
			mnIInsert.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/Document-write-icon.png")));
			menuBar.add(mnIInsert);
		}
/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/	
	
        
        
        /*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
		JMenu mnAbout = new JMenu("About");
		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				about();
			}
		});
		mnAbout.setIcon(new ImageIcon(jframe_Menu.class.getResource("/pics/application-arrow-right-icon.png")));
		menuBar.add(mnAbout);
		
		
        
        
        
        
	}

	protected void insertU() {
		jframe_insertUsers up=new jframe_insertUsers();
		up.setVisible(true);	
	}

	protected void insert() {
		jframe_Insert up=new jframe_Insert();
		up.setVisible(true);	
	}

	protected void delete() {
		jframe_Delete up=new jframe_Delete();
		up.setVisible(true);		
	}

	protected void update() {
	jframe_Update up=new jframe_Update();
	up.setVisible(true);
	
	}

	protected void search() {
		jframe_Consult dep=new jframe_Consult();
		dep.setVisible(true);
		
	}

	protected void about() {
		jframe_AbaoutSoftware de=new jframe_AbaoutSoftware();
		//de.setVisible(true);
		////this.dispose();
        de.setVisible(true);
		
	}
}
