package freierTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Window.Type;

public class MenschAergereDichNicht_GUI extends JFrame {
	static Color farben[] = { Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
			Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
			Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
			Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
			Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
			Color.BLACK, Color.BLACK };

	private JPanel Game;

	static int game[] = new int[41];
	static boolean homeRed[] = new boolean[4];
	static boolean homeBlue[] = new boolean[4];
	static boolean homeGreen[] = new boolean[4];
	static boolean homeYellow[] = new boolean[4];

	public static int statusRed[] = new int[4];
	//0 alle am start | 1 3 am Start
	public static int redIndex = 0;
	public static int statusBlue[] = new int[4];
	public static int blueIndex = 0;
	public static int statusGreen[] = new int[4];
	public static int greenIndex = 0;
	public static int statusYellow[] = new int[4];
	public static int yellowIndex = 0;

	public static boolean runFinish = false;

	private static JTextPane txtP_1;
	private static JTextPane txtP_2;
	private static JTextPane txtP_3;
	private static JTextPane txtP_4;
	private static JTextPane txtP_5;
	private static JTextPane txtP_6;
	private static JTextPane txtP_7;
	private static JTextPane txtP_8;
	private static JTextPane txtP_9;
	private static JTextPane txtP_10;
	private static JTextPane txtP_11;
	private static JTextPane txtP_12;
	private static JTextPane txtP_13;
	private static JTextPane txtP_14;
	private static JTextPane txtP_15;
	private static JTextPane txtP_16;
	private static JTextPane txtP_17;
	private static JTextPane txtP_18;
	private static JTextPane txtP_19;
	private static JTextPane txtP_20;
	private static JTextPane txtP_21;
	private static JTextPane txtP_22;
	private static JTextPane txtP_23;
	private static JTextPane txtP_24;
	private static JTextPane txtP_25;
	private static JTextPane txtP_26;
	private static JTextPane txtP_27;
	private static JTextPane txtP_28;
	private static JTextPane txtP_29;
	private static JTextPane txtP_30;
	private static JTextPane txtP_31;
	private static JTextPane txtP_32;
	private static JTextPane txtP_33;
	private static JTextPane txtP_34;
	private static JTextPane txtP_35;
	private static JTextPane txtP_36;
	private static JTextPane txtP_37;
	private static JTextPane txtP_38;
	private static JTextPane txtP_39;
	private static JTextPane txtP_40;
	private static JRadioButton rb_hr1;
	private static JRadioButton rb_hr2;
	private static JRadioButton rb_hr3;
	private static JRadioButton rb_hr4;
	private static JRadioButton rb_hb1;
	private static JRadioButton rb_hb2;
	private static JRadioButton rb_hb3;
	private static JRadioButton rb_hb4;
	private static JRadioButton rb_hg1;
	private static JRadioButton rb_hg2;
	private static JRadioButton rb_hg3;
	private static JRadioButton rb_hg4;
	private static JRadioButton rb_hy1;
	private static JRadioButton rb_hy2;
	private static JRadioButton rb_hy3;
	private static JRadioButton rb_hy4;
	
	static JTextPane txtP_redStart;
	static JTextPane txtP_blueStart;
	static JTextPane txtP_greenStart;
	static JTextPane txtP_yellowStart;

	// FigurPosition Button
	public static JButton btn_Figure1;
	public static JButton btn_Figure2;
	public static JButton btn_Figure3;
	public static JButton btn_Figure4;

	public static String pos1 = "Feld 1";
	public static String pos2 = "Feld 2";
	public static String pos3 = "Feld 3";
	public static String pos4 = "Feld 4";

	private static JTextField txt_aPlayer;
	private static JTextField txt_heufigkeit;
	private JTextField txt_wuerfel;

	final static int LEER = 0;
	final static int ROT = 1;
	final static int BLAU = 2;
	final static int GRUEN = 3;
	final static int GELB = 4;

	private JButton btn_nSpieler;
	private JButton btn_update;
	private static JTextField txt_err;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GAME2.prepareForNewGame();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenschAergereDichNicht_GUI frame = new MenschAergereDichNicht_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("Main ende");
	}

	public static void aSpielerInfo() {
		GAME2.update();
		int aSpieler = GAME2.nowPlaying;
		switch (aSpieler) {
		case (ROT):
			txt_aPlayer.setText("ROT");

			// Nenne Variable für Knopfnamen
			// Knopf 1
			if (statusRed[0] != 0 && statusRed[0] <= 40)
				pos1 = "Feld: " + statusRed[0];
			else if (statusRed[0] == 0)
				pos1 = "Start";
			else
				pos1 = "Haus " + (statusRed[0] - 40);
			// Knopf 2
			if (statusRed[1] != 0 && statusRed[1] <= 40)
				pos2 = "Feld: " + statusRed[1];
			else if (statusRed[1] == 0)
				pos2 = "Start";
			else
				pos2 = "Haus " + (statusRed[1] - 40);
			// Knopf3
			if (statusRed[2] != 0 && statusRed[2] <= 40)
				pos3 = "Feld: " + statusRed[2];
			else if (statusRed[2] == 0)
				pos3 = "Start";
			else
				pos3 = "Haus " + (statusRed[2] - 40);
			// Knopf 4
			if (statusRed[3] != 0 && statusRed[3] <= 40)
				pos4 = "Feld: " + statusRed[3];
			else if (statusRed[3] == 0)
				pos4 = "Start";
			else
				pos4 = "Haus " + (statusRed[3] - 40);

			break;
		case (BLAU):
			txt_aPlayer.setText("BLAU");
			// k1
			if (statusBlue[0] != 0 && statusBlue[0] <= 40)
				pos1 = "Feld: " + statusBlue[0];
			else if (statusBlue[0] == 0)
				pos1 = "Start";
			else
				pos1 = "Haus " + (statusBlue[0] - 40);
			// K2
			if (statusBlue[1] != 0 && statusBlue[1] <= 40)
				pos2 = "Feld: " + statusBlue[1];
			else if (statusBlue[1] == 0)
				pos2 = "Start";
			else
				pos2 = "Haus " + (statusBlue[1] - 40);
			// k3
			if (statusBlue[2] != 0 && statusBlue[2] <= 40)
				pos3 = "Feld: " + statusBlue[2];
			else if (statusBlue[2] == 0)
				pos3 = "Start";
			else
				pos3 = "Haus " + (statusBlue[2] - 40);
			// k4
			if (statusBlue[3] != 0 && statusBlue[3] <= 40)
				pos4 = "Feld: " + statusBlue[3];
			else if (statusBlue[3] == 0)
				pos4 = "Start";
			else
				pos4 = "Haus " + (statusBlue[3] - 40);
			break;
		case (GRUEN):
			txt_aPlayer.setText("GRUEN");
			// k1
			if (statusGreen[0] != 0 && statusGreen[0] <= 40)
				pos1 = "Feld: " + statusGreen[0];
			else if (statusGreen[0] == 0)
				pos1 = "Start";
			else
				pos1 = "Haus " + (statusGreen[0] - 40);
			// k2
			if (statusGreen[1] != 0 && statusGreen[1] <= 40)
				pos2 = "Feld: " + statusGreen[1];
			else if (statusGreen[1] == 0)
				pos2 = "Start";
			else
				pos2 = "Haus " + (statusGreen[1] - 40);
			// k3
			if (statusGreen[2] != 0 && statusGreen[2] <= 40)
				pos3 = "Feld: " + statusGreen[2];
			else if (statusGreen[2] == 0)
				pos3 = "Start";
			else
				pos3 = "Haus " + (statusGreen[2] - 40);
			// k4
			if (statusGreen[3] != 0 && statusGreen[3] <= 40)
				pos4 = "Feld: " + statusGreen[3];
			else if (statusGreen[3] == 0)
				pos4 = "Start";
			else
				pos4 = "Haus " + (statusGreen[3] - 40);
			break;
		case (GELB):
			txt_aPlayer.setText("GELB");
			// k1
			if (statusYellow[0] != 0 && statusYellow[0] <= 40)
				pos1 = "Feld: " + statusYellow[0];
			else if (statusYellow[0] == 0)
				pos1 = "Start";
			else
				pos1 = "Haus " + (statusYellow[0] - 40);
			// k2
			if (statusYellow[1] != 0 && statusYellow[1] <= 40)
				pos2 = "Feld: " + statusYellow[1];
			else if (statusYellow[1] == 0)
				pos2 = "Start";
			else
				pos2 = "Haus " + (statusYellow[1] - 40);
			// k3
			if (statusYellow[2] != 0 && statusYellow[2] <= 40)
				pos3 = "Feld: " + statusYellow[2];
			else if (statusYellow[2] == 0)
				pos3 = "Start";
			else
				pos3 = "Haus " + (statusYellow[2] - 40);
			// k4
			if (statusYellow[3] != 0 && statusYellow[3] <= 40)
				pos4 = "Feld: " + statusYellow[3];
			else if (statusYellow[3] == 0)
				pos4 = "Start";
			else
				pos4 = "Haus " + (statusYellow[3] - 40);
			break;
		}
		//Print Position  des spielers
		System.out.println(
				"Red: " + statusRed[0] + " | " + statusRed[1] + " | " + statusRed[2] + " | " + statusRed[3]);
		System.out.println("Blue: " + statusBlue[0] + " | " + statusBlue[1] + " | " + statusBlue[2] + " | "
				+ statusBlue[3]);
		System.out.println("Green: " + statusGreen[0] + " | " + statusGreen[1] + " | " + statusGreen[2] + " | "
				+ statusGreen[3]);
		System.out.println("Yellow: " + statusYellow[0] + " | " + statusYellow[1] + " | " + statusYellow[2]
				+ " | " + statusYellow[3]);
		//Print anzahl der Figuren am start
		System.out.println();
		System.out.println("RED count Figures: " + GAME2.redNumberOfStones);
		System.out.println("BLUE count Figures: " + GAME2.blueNumberOfStones);
		System.out.println("GREEN count Figures: " + GAME2.greenNumberOfStones);
		System.out.println("YELLOW count Figures: " + GAME2.yellowNumberOfStones);

		//Text des Knopfes
		btn_Figure1.setText(pos1);
		btn_Figure2.setText(pos2);
		btn_Figure3.setText(pos3);
		btn_Figure4.setText(pos4);
		
		//Start
		txtP_redStart.setText(" " + GAME2.redNumberOfStones);
		txtP_blueStart.setText(" " + GAME2.blueNumberOfStones);
		txtP_greenStart.setText(" " + GAME2.greenNumberOfStones);
		txtP_yellowStart.setText(" " + GAME2.yellowNumberOfStones);
		
		
		txt_heufigkeit.setText(""+ GAME2.rollTime);

		// aktualisiere Spielbrett
		txtP_1.setBackground(farben[1]);
		txtP_2.setBackground(farben[2]);
		txtP_3.setBackground(farben[3]);
		txtP_4.setBackground(farben[4]);
		txtP_5.setBackground(farben[5]);
		txtP_6.setBackground(farben[6]);
		txtP_7.setBackground(farben[7]);
		txtP_8.setBackground(farben[8]);
		txtP_9.setBackground(farben[9]);
		txtP_10.setBackground(farben[10]);
		txtP_11.setBackground(farben[11]);
		txtP_12.setBackground(farben[12]);
		txtP_13.setBackground(farben[13]);
		txtP_14.setBackground(farben[14]);
		txtP_15.setBackground(farben[15]);
		txtP_16.setBackground(farben[16]);
		txtP_17.setBackground(farben[17]);
		txtP_18.setBackground(farben[18]);
		txtP_19.setBackground(farben[19]);
		txtP_20.setBackground(farben[20]);
		txtP_21.setBackground(farben[21]);
		txtP_22.setBackground(farben[22]);
		txtP_23.setBackground(farben[23]);
		txtP_24.setBackground(farben[24]);
		txtP_25.setBackground(farben[25]);
		txtP_26.setBackground(farben[26]);
		txtP_27.setBackground(farben[27]);
		txtP_28.setBackground(farben[28]);
		txtP_29.setBackground(farben[29]);
		txtP_30.setBackground(farben[30]);
		txtP_31.setBackground(farben[31]);
		txtP_32.setBackground(farben[32]);
		txtP_33.setBackground(farben[33]);
		txtP_34.setBackground(farben[34]);
		txtP_35.setBackground(farben[35]);
		txtP_36.setBackground(farben[36]);
		txtP_37.setBackground(farben[37]);
		txtP_38.setBackground(farben[38]);
		txtP_39.setBackground(farben[39]);
		txtP_40.setBackground(farben[40]);
		
		rb_hb1.setSelected(homeBlue[0]);
		rb_hb2.setSelected(homeBlue[1]);
		rb_hb3.setSelected(homeBlue[2]);
		rb_hb4.setSelected(homeBlue[3]);
		
		rb_hr1.setSelected(homeRed[0]);
		rb_hr2.setSelected(homeRed[1]);
		rb_hr3.setSelected(homeRed[2]);
		rb_hr4.setSelected(homeRed[3]);
		
		rb_hy1.setSelected(homeYellow[0]);
		rb_hy2.setSelected(homeYellow[1]);
		rb_hy3.setSelected(homeYellow[2]);
		rb_hy4.setSelected(homeYellow[3]);
		
		rb_hg1.setSelected(homeGreen[0]);
		rb_hg2.setSelected(homeGreen[1]);
		rb_hg3.setSelected(homeGreen[2]);
		rb_hg4.setSelected(homeGreen[3]);
	}

	/**
	 * 
	 * @param pos
	 * @param farbe
	 */
	public static void setzeFarbe(int pos, int farbe) {
		switch (farbe) {
		case (LEER):
			farben[pos ] = Color.BLACK;
			break;
		case (ROT):
			farben[pos ] = Color.RED;
			break;
		case (BLAU):
			farben[pos ] = Color.BLUE;
			break;
		case (GRUEN):
			farben[pos ] = Color.GREEN;
			break;
		case (GELB):
			farben[pos ] = Color.YELLOW;
			break;
		}
	}

	/**
	 * 
	 * @param anzahl
	 * @param farbe
	 */
	public static void setzeHaus(int anzahl, int farbe) {

	}

	/**
	 * 
	 * @param anzahl
	 * @param farbe
	 */
	public static void setzeStart(int farbe) {
		int anzahl = 4;
		switch (farbe) {
		case (ROT):
			anzahl = GAME2.redNumberOfStones;


			break;
		case (BLAU):
			anzahl = GAME2.blueNumberOfStones;
	
			break;

		case (GRUEN):
			anzahl = GAME2.greenNumberOfStones;
			
			break;
		case (GELB):
			anzahl = GAME2.yellowNumberOfStones;
		
			break;
		}
	}

	/**
	 * Create the frame.
	 */
	public MenschAergereDichNicht_GUI() {
		setAlwaysOnTop(true);
		setTitle("Mensch Ärgere Dich Nicht");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 617);
		Game = new JPanel();
		Game.setForeground(Color.RED);
		Game.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Game);
		Game.setLayout(null);

		JButton btn_wuerfel = new JButton("Würfel");
		btn_wuerfel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_err.setText("");
				if (GAME2.augen == 6)
					txt_err.setText("Du darfst nichr mehr Würfeln!");
				else if (GAME2.rollTime != 0) {
					GAME2.roll();
					System.out.println("---------------->gewürfelt " + GAME2.augen);
					txt_wuerfel.setText("Ergebnis: " + GAME2.augen);
					
				} else
					txt_err.setText("Du darfst nichr mehr Würfeln!");
				aSpielerInfo();

			}

		});
		btn_wuerfel.setBounds(21, 441, 100, 35);
		Game.add(btn_wuerfel);

		txtP_39 = new JTextPane();
		txtP_39.setEditable(false);
		txtP_39.setBackground(farben[39]);
		txtP_39.setBounds(230, 60, 30, 30);
		Game.add(txtP_39);

		txtP_38 = new JTextPane();
		txtP_38.setEditable(false);
		txtP_38.setBackground(farben[38]);
		txtP_38.setBounds(230, 95, 30, 30);
		Game.add(txtP_38);

		txtP_37 = new JTextPane();
		txtP_37.setEditable(false);
		txtP_37.setBackground(farben[37]);
		txtP_37.setBounds(230, 130, 30, 30);
		Game.add(txtP_37);

		txtP_36 = new JTextPane();
		txtP_36.setEditable(false);
		txtP_36.setBackground(farben[36]);
		txtP_36.setBounds(230, 165, 30, 30);
		Game.add(txtP_36);

		txtP_35 = new JTextPane();
		txtP_35.setEditable(false);
		txtP_35.setBackground(farben[35]);
		txtP_35.setBounds(230, 200, 30, 30);
		Game.add(txtP_35);

		txtP_34 = new JTextPane();
		txtP_34.setEditable(false);
		txtP_34.setBackground(farben[34]);
		txtP_34.setBounds(195, 200, 30, 30);
		Game.add(txtP_34);

		txtP_33 = new JTextPane();
		txtP_33.setEditable(false);
		txtP_33.setBackground(farben[33]);
		txtP_33.setBounds(160, 200, 30, 30);
		Game.add(txtP_33);

		txtP_32 = new JTextPane();
		txtP_32.setEditable(false);
		txtP_32.setBackground(farben[32]);
		txtP_32.setBounds(125, 200, 30, 30);
		Game.add(txtP_32);

		txtP_31 = new JTextPane();
		txtP_31.setEditable(false);
		txtP_31.setBackground(farben[31]);
		txtP_31.setBounds(90, 200, 30, 30);
		Game.add(txtP_31);

		txtP_30 = new JTextPane();
		txtP_30.setEditable(false);
		txtP_30.setBackground(farben[30]);
		txtP_30.setBounds(90, 235, 30, 30);
		Game.add(txtP_30);

		txtP_29 = new JTextPane();
		txtP_29.setEditable(false);
		txtP_29.setBackground(farben[29]);
		txtP_29.setBounds(90, 270, 30, 30);
		Game.add(txtP_29);

		txtP_28 = new JTextPane();
		txtP_28.setEditable(false);
		txtP_28.setBackground(farben[28]);
		txtP_28.setBounds(125, 270, 30, 30);
		Game.add(txtP_28);

		txtP_27 = new JTextPane();
		txtP_27.setEditable(false);
		txtP_27.setBackground(farben[27]);
		txtP_27.setBounds(160, 270, 30, 30);
		Game.add(txtP_27);

		txtP_26 = new JTextPane();
		txtP_26.setEditable(false);
		txtP_26.setBackground(farben[26]);
		txtP_26.setBounds(195, 270, 30, 30);
		Game.add(txtP_26);

		txtP_25 = new JTextPane();
		txtP_25.setEditable(false);
		txtP_25.setBackground(farben[25]);
		txtP_25.setBounds(230, 270, 30, 30);
		Game.add(txtP_25);

		txtP_24 = new JTextPane();
		txtP_24.setEditable(false);
		txtP_24.setBackground(farben[24]);
		txtP_24.setBounds(230, 305, 30, 30);
		Game.add(txtP_24);

		txtP_23 = new JTextPane();
		txtP_23.setEditable(false);
		txtP_23.setBackground(farben[23]);
		txtP_23.setBounds(230, 340, 30, 30);
		Game.add(txtP_23);

		txtP_22 = new JTextPane();
		txtP_22.setEditable(false);
		txtP_22.setBackground(farben[22]);
		txtP_22.setBounds(230, 375, 30, 30);
		Game.add(txtP_22);

		txtP_21 = new JTextPane();
		txtP_21.setEditable(false);
		txtP_21.setBackground(farben[21]);
		txtP_21.setBounds(230, 410, 30, 30);
		Game.add(txtP_21);

		txtP_20 = new JTextPane();
		txtP_20.setEditable(false);
		txtP_20.setBackground(farben[20]);
		txtP_20.setBounds(265, 410, 30, 30);
		Game.add(txtP_20);

		txtP_19 = new JTextPane();
		txtP_19.setEditable(false);
		txtP_19.setBackground(farben[19]);
		txtP_19.setBounds(300, 410, 30, 30);
		Game.add(txtP_19);

		txtP_18 = new JTextPane();
		txtP_18.setEditable(false);
		txtP_18.setBackground(farben[18]);
		txtP_18.setBounds(300, 375, 30, 30);
		Game.add(txtP_18);

		txtP_17 = new JTextPane();
		txtP_17.setEditable(false);
		txtP_17.setBackground(farben[17]);
		txtP_17.setBounds(300, 340, 30, 30);
		Game.add(txtP_17);

		txtP_16 = new JTextPane();
		txtP_16.setEditable(false);
		txtP_16.setBackground(farben[16]);
		txtP_16.setBounds(300, 305, 30, 30);
		Game.add(txtP_16);

		txtP_15 = new JTextPane();
		txtP_15.setEditable(false);
		txtP_15.setBackground(farben[15]);
		txtP_15.setBounds(300, 270, 30, 30);
		Game.add(txtP_15);

		txtP_14 = new JTextPane();
		txtP_14.setEditable(false);
		txtP_14.setBackground(farben[14]);
		txtP_14.setBounds(335, 270, 30, 30);
		Game.add(txtP_14);

		txtP_13 = new JTextPane();
		txtP_13.setEditable(false);
		txtP_13.setBackground(farben[13]);
		txtP_13.setBounds(370, 270, 30, 30);
		Game.add(txtP_13);

		txtP_12 = new JTextPane();
		txtP_12.setEditable(false);
		txtP_12.setBackground(farben[12]);
		txtP_12.setBounds(405, 270, 30, 30);
		Game.add(txtP_12);

		txtP_11 = new JTextPane();
		txtP_11.setEditable(false);
		txtP_11.setBackground(farben[11]);
		txtP_11.setBounds(440, 270, 30, 30);
		Game.add(txtP_11);

		txtP_10 = new JTextPane();
		txtP_10.setEditable(false);
		txtP_10.setBackground(farben[10]);
		txtP_10.setBounds(440, 235, 30, 30);
		Game.add(txtP_10);

		txtP_9 = new JTextPane();
		txtP_9.setEditable(false);
		txtP_9.setBackground(farben[9]);
		txtP_9.setBounds(440, 200, 30, 30);
		Game.add(txtP_9);

		txtP_8 = new JTextPane();
		txtP_8.setEditable(false);
		txtP_8.setBackground(farben[8]);
		txtP_8.setBounds(405, 200, 30, 30);
		Game.add(txtP_8);

		txtP_7 = new JTextPane();
		txtP_7.setEditable(false);
		txtP_7.setBackground(farben[7]);
		txtP_7.setBounds(370, 200, 30, 30);
		Game.add(txtP_7);

		txtP_6 = new JTextPane();
		txtP_6.setEditable(false);
		txtP_6.setBackground(farben[6]);
		txtP_6.setBounds(335, 200, 30, 30);
		Game.add(txtP_6);

		txtP_5 = new JTextPane();
		txtP_5.setEditable(false);
		txtP_5.setBackground(farben[5]);
		txtP_5.setBounds(300, 200, 30, 30);
		Game.add(txtP_5);

		txtP_4 = new JTextPane();
		txtP_4.setEditable(false);
		txtP_4.setBackground(farben[4]);
		txtP_4.setBounds(300, 165, 30, 30);
		Game.add(txtP_4);

		txtP_3 = new JTextPane();
		txtP_3.setEditable(false);
		txtP_3.setBackground(farben[3]);
		txtP_3.setBounds(300, 130, 30, 30);
		Game.add(txtP_3);

		txtP_2 = new JTextPane();
		txtP_2.setEditable(false);
		txtP_2.setBackground(farben[2]);
		txtP_2.setBounds(300, 95, 30, 30);
		Game.add(txtP_2);

		txtP_1 = new JTextPane();
		txtP_1.setEditable(false);
		txtP_1.setBackground(farben[1]);
		txtP_1.setBounds(300, 60, 30, 30);
		Game.add(txtP_1);

		txtP_40 = new JTextPane();
		txtP_40.setEditable(false);
		txtP_40.setBackground(farben[40]);
		txtP_40.setBounds(265, 60, 30, 30);
		Game.add(txtP_40);

		rb_hr1 = new JRadioButton("");
		rb_hr1.setEnabled(false);
		rb_hr1.setBounds(125, 235, 30, 30);
		Game.add(rb_hr1);

		rb_hr2 = new JRadioButton("");
		rb_hr2.setEnabled(false);
		rb_hr2.setBounds(160, 235, 30, 30);
		Game.add(rb_hr2);

		rb_hr3 = new JRadioButton("");
		rb_hr3.setEnabled(false);
		rb_hr3.setBounds(195, 235, 30, 30);
		Game.add(rb_hr3);

		rb_hr4 = new JRadioButton("");
		rb_hr4.setEnabled(false);
		rb_hr4.setBounds(230, 235, 30, 30);
		Game.add(rb_hr4);

		rb_hb1 = new JRadioButton("");
		rb_hb1.setEnabled(false);
		rb_hb1.setBounds(265, 95, 30, 30);
		Game.add(rb_hb1);

		rb_hb2 = new JRadioButton("");
		rb_hb2.setEnabled(false);
		rb_hb2.setBounds(265, 130, 30, 30);
		Game.add(rb_hb2);

		rb_hb3 = new JRadioButton("");
		rb_hb3.setEnabled(false);
		rb_hb3.setBounds(265, 165, 30, 30);
		Game.add(rb_hb3);

		rb_hb4 = new JRadioButton("");
		rb_hb4.setEnabled(false);
		rb_hb4.setBounds(265, 200, 30, 30);
		Game.add(rb_hb4);

		rb_hg4 = new JRadioButton("");
		rb_hg4.setEnabled(false);
		rb_hg4.setBounds(300, 235, 30, 30);
		Game.add(rb_hg4);

		rb_hg3 = new JRadioButton("");
		rb_hg3.setEnabled(false);
		rb_hg3.setBounds(335, 235, 30, 30);
		Game.add(rb_hg3);

		rb_hg2 = new JRadioButton("");
		rb_hg2.setEnabled(false);
		rb_hg2.setBounds(370, 235, 30, 30);
		Game.add(rb_hg2);

		rb_hg1 = new JRadioButton("");
		rb_hg1.setEnabled(false);
		rb_hg1.setBounds(405, 235, 30, 30);
		Game.add(rb_hg1);

		rb_hy1 = new JRadioButton("");
		rb_hy1.setEnabled(false);
		rb_hy1.setBounds(265, 375, 30, 30);
		Game.add(rb_hy1);

		rb_hy2 = new JRadioButton("");
		rb_hy2.setEnabled(false);
		rb_hy2.setBounds(265, 340, 30, 30);
		Game.add(rb_hy2);

		rb_hy3 = new JRadioButton("");
		rb_hy3.setEnabled(false);
		rb_hy3.setBounds(265, 305, 30, 30);
		Game.add(rb_hy3);

		rb_hy4 = new JRadioButton("");
		rb_hy4.setEnabled(false);
		rb_hy4.setBounds(265, 270, 30, 30);
		Game.add(rb_hy4);

		JTextPane textPane_39 = new JTextPane();
		textPane_39.setEditable(false);
		textPane_39.setEnabled(false);
		textPane_39.setText("-->");
		textPane_39.setBounds(82, 173, 39, 25);
		Game.add(textPane_39);

		JTextPane textPane_40 = new JTextPane();
		textPane_40.setText("<--");
		textPane_40.setEnabled(false);
		textPane_40.setEditable(false);
		textPane_40.setBounds(448, 306, 39, 25);
		Game.add(textPane_40);

		txtP_yellowStart = new JTextPane();
		txtP_yellowStart.setForeground(Color.LIGHT_GRAY);
		txtP_yellowStart.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtP_yellowStart.setText(" 4");
		txtP_yellowStart.setEditable(false);
		txtP_yellowStart.setBackground(Color.YELLOW);
		txtP_yellowStart.setBounds(125, 340, 65, 65);
		Game.add(txtP_yellowStart);

		 txtP_greenStart = new JTextPane();
		 txtP_greenStart.setForeground(Color.LIGHT_GRAY);
		txtP_greenStart.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtP_greenStart.setText(" 4");
		txtP_greenStart.setEditable(false);
		txtP_greenStart.setBackground(Color.GREEN);
		txtP_greenStart.setBounds(370, 340, 65, 65);
		Game.add(txtP_greenStart);

		 txtP_blueStart = new JTextPane();
		 txtP_blueStart.setForeground(Color.LIGHT_GRAY);
		 txtP_blueStart.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtP_blueStart.setText(" 4");
		txtP_blueStart.setEditable(false);
		txtP_blueStart.setBackground(Color.BLUE);
		txtP_blueStart.setBounds(370, 95, 65, 65);
		Game.add(txtP_blueStart);

		 txtP_redStart = new JTextPane();
		 txtP_redStart.setForeground(Color.LIGHT_GRAY);
		 txtP_redStart.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtP_redStart.setText(" 4");
		txtP_redStart.setEditable(false);
		txtP_redStart.setBackground(Color.RED);
		txtP_redStart.setBounds(125, 95, 65, 65);
		Game.add(txtP_redStart);

		JTextPane textPane_21 = new JTextPane();
		textPane_21.setEditable(false);
		textPane_21.setBackground(Color.YELLOW);
		textPane_21.setBounds(263, 268, 34, 139);
		Game.add(textPane_21);

		JTextPane textPane_22 = new JTextPane();
		textPane_22.setEditable(false);
		textPane_22.setBackground(Color.BLUE);
		textPane_22.setBounds(263, 93, 34, 139);
		Game.add(textPane_22);

		JTextPane textPane_23 = new JTextPane();
		textPane_23.setEditable(false);
		textPane_23.setBackground(Color.RED);
		textPane_23.setBounds(123, 233, 139, 34);
		Game.add(textPane_23);

		JTextPane textPane_24 = new JTextPane();
		textPane_24.setEditable(false);
		textPane_24.setBackground(Color.GREEN);
		textPane_24.setBounds(298, 233, 139, 34);
		Game.add(textPane_24);

		txt_wuerfel = new JTextField();
		txt_wuerfel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txt_wuerfel.setEditable(false);
		txt_wuerfel.setBounds(21, 483, 141, 32);
		Game.add(txt_wuerfel);
		txt_wuerfel.setColumns(10);

		txt_aPlayer = new JTextField();
		txt_aPlayer.setEditable(false);
		txt_aPlayer.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txt_aPlayer.setColumns(10);
		txt_aPlayer.setBounds(500, 377, 97, 32);
		Game.add(txt_aPlayer);

		txt_heufigkeit = new JTextField();
		txt_heufigkeit.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txt_heufigkeit.setEditable(false);
		txt_heufigkeit.setColumns(10);
		txt_heufigkeit.setBounds(127, 441, 35, 35);
		Game.add(txt_heufigkeit);

		btn_nSpieler = new JButton("Nächster Spieler");
		btn_nSpieler.addActionListener(new ActionListener() {
			/**
			 * Nächster Spieler
			 */
			public void actionPerformed(ActionEvent arg0) {
				GAME2.nextPlayer();
				System.out.println("---------------->nächster Spieler");
				aSpielerInfo();
				txt_err.setText("");

			}
		});
		btn_nSpieler.setBounds(0, 0, 192, 35);
		Game.add(btn_nSpieler);

		btn_update = new JButton("Aktuallisieren");
		btn_update.addActionListener(new ActionListener() {
			/**
			 * Update
			 */
			public void actionPerformed(ActionEvent arg0) {
				aSpielerInfo();
			}
		});
		btn_update.setBounds(197, 0, 162, 35);
		Game.add(btn_update);

		txt_err = new JTextField();
		txt_err.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_err.setEditable(false);
		txt_err.setColumns(10);
		txt_err.setBounds(168, 483, 307, 32);
		Game.add(txt_err);

		btn_Figure1 = new JButton(pos1);
		btn_Figure1.addActionListener(new ActionListener() {
			/**
			 * Knopf bewege Figur 1
			 */
			public void actionPerformed(ActionEvent arg0) {
				txt_err.setText("");
				if (GAME2.move(0)) {
					GAME2.augen = 0;
				} else
					txt_err.setText("Figur konnte nicht bewegt werden.");
		
				aSpielerInfo();
				
			}
		});
		btn_Figure1.setBounds(489, 410, 108, 35);
		Game.add(btn_Figure1);

		btn_Figure2 = new JButton(pos2);
		btn_Figure2.addActionListener(new ActionListener() {
			/**
			 * Knopf bewege Figur 2
			 */
			public void actionPerformed(ActionEvent arg0) {
				txt_err.setText("");
				if (GAME2.move(1)) {
					GAME2.augen = 0;
				} else
					txt_err.setText("Figur konnte nicht bewegt werden.");
			
				aSpielerInfo();
			}
		});
		btn_Figure2.setBounds(489, 445, 108, 35);
		Game.add(btn_Figure2);

		btn_Figure3 = new JButton(pos3);
		btn_Figure3.addActionListener(new ActionListener() {
			/**
			 * Knopf bewege Figur 3
			 */
			public void actionPerformed(ActionEvent arg0) {
				txt_err.setText("");
				if (GAME2.move(2)) {
					GAME2.augen = 0;
				} else
					txt_err.setText("Figur konnte nicht bewegt werden.");
		
				aSpielerInfo();
			}
		});
		btn_Figure3.setBounds(489, 480, 108, 35);
		Game.add(btn_Figure3);

		btn_Figure4 = new JButton(pos4);
		btn_Figure4.addActionListener(new ActionListener() {
			/**
			 * Knopf bewege Figur 4
			 */
			public void actionPerformed(ActionEvent arg0) {
				txt_err.setText("");
				if (GAME2.move(3)) {
					GAME2.augen = 0;
				} else
					txt_err.setText("Figur konnte nicht bewegt werden.");
				
				aSpielerInfo();
			}
		});
		btn_Figure4.setBounds(489, 515, 108, 35);
		Game.add(btn_Figure4);

	}
}
