import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;


public class ReadAndDiplayGui {

	private JFrame frame;
	private JTextArea txtrReading;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadAndDiplayGui window = new ReadAndDiplayGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReadAndDiplayGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtrReading = new JTextArea();
		txtrReading.setBackground(Color.WHITE);
		txtrReading.setText("Awaiting File...");
		txtrReading.setForeground(new Color(30, 144, 255));
		txtrReading.setEditable(false);
		txtrReading.setBounds(10, 0, 187, 240);
		frame.getContentPane().add(txtrReading);
		
		JButton btnGetFile = new JButton("Get File");
		btnGetFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenFile of = new  OpenFile();
				
				try {
					of.PickMe();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				txtrReading.setText(of.sb.toString());
				txtrReading.append("\n--------Regular Expression-------\n");
				txtrReading.append(of.myReg.toString() + "\n");
			}
		});
		btnGetFile.setBounds(10, 112, 119, 47);
		frame.getContentPane().add(btnGetFile);
		
		JScrollPane scrollPane = new JScrollPane(txtrReading);
		scrollPane.setBounds(159, 11, 265, 240);
		frame.getContentPane().add(scrollPane);
	}
}
