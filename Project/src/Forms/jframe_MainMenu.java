package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jframe_MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_MainMenu frame = new jframe_MainMenu();
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
	public jframe_MainMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("LoginSystem");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe_login obj1=new  jframe_login();
				obj1.setVisible(true);//MOVE TO ANOTHER JFRAME
				dispose();
			}

			
		});
		btnNewButton.setBounds(219, 124, 143, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNumbersMagics = new JButton("Numbers Magics");
		btnNumbersMagics.setBounds(29, 124, 143, 40);
		contentPane.add(btnNumbersMagics);
	}
}
