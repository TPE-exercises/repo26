package freierTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.hsMannheim.informatik.gdi.uebung04.ByteburgTarifRechner;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GUI_Biteburg extends JFrame {

	public static int ziel;

	public static int start;

	private JPanel contentPane;
	private JTextField txt_StartStation;
	private JTextField txt_finalStation;
	private JTextField txt_price;
	private JTextField txt_info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Biteburg frame = new GUI_Biteburg();
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
	public GUI_Biteburg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_StartStation = new JTextField();
		txt_StartStation.setBounds(21, 44, 186, 32);
		contentPane.add(txt_StartStation);
		txt_StartStation.setColumns(10);

		txt_finalStation = new JTextField();
		txt_finalStation.setBounds(217, 44, 186, 32);
		contentPane.add(txt_finalStation);
		txt_finalStation.setColumns(10);

		JButton btn_Go = new JButton("GO");
		btn_Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ziel = Integer.parseInt(txt_finalStation.getText());
				start = Integer.parseInt(txt_StartStation.getText());

				ByteburgTarifRechner.main(null);

				String info = ByteburgTarifRechner.info;
				int erg = ByteburgTarifRechner.fahrtKosten;
				if (info.equals("Start oder Ziel ist ungültig") || info.equals("Sie sind bereits an ihrem Ziel!")) {
					txt_price.setText("");
				} else {
					txt_price.setText("" + erg + "€");
				}

				txt_info.setText(info);

			}
		});
		btn_Go.setBounds(139, 97, 141, 35);
		contentPane.add(btn_Go);

		JTextArea txtrStart = new JTextArea();
		txtrStart.setEditable(false);
		txtrStart.setText("Start");
		txtrStart.setBounds(21, 21, 76, 22);
		contentPane.add(txtrStart);

		JTextArea txtrZiel = new JTextArea();
		txtrZiel.setEditable(false);
		txtrZiel.setText("Ziel");
		txtrZiel.setBounds(217, 21, 76, 22);
		contentPane.add(txtrZiel);

		txt_price = new JTextField();
		txt_price.setHorizontalAlignment(SwingConstants.CENTER);
		txt_price.setEditable(false);
		txt_price.setColumns(10);
		txt_price.setBounds(172, 139, 76, 32);
		contentPane.add(txt_price);

		txt_info = new JTextField();
		txt_info.setHorizontalAlignment(SwingConstants.CENTER);
		txt_info.setEditable(false);
		txt_info.setColumns(10);
		txt_info.setBounds(21, 192, 382, 32);
		contentPane.add(txt_info);
	}
}
