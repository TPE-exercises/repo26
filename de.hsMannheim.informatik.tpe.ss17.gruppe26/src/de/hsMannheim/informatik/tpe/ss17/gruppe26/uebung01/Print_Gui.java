package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Print_Gui extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_root;
	private static JTextField textField_size;
	private static JTextField textField_hight;
	private static JTextField textField_min;
	private static JTextField textField_max;

	/**
	 * Launch the application.
	 */
	private static BTree tree = null;;

	public static void iniziallisiere(BTree atree) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print_Gui frame = new Print_Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		tree = atree;

	}

	/**
	 * Create the frame.
	 */
	public Print_Gui() {
		setTitle("BTree");
		setAlwaysOnTop(true);
		System.out.println("************K");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_root = new JTextField();
		textField_root.setEditable(false);
		textField_root.setHorizontalAlignment(SwingConstants.CENTER);
		textField_root.setBounds(52, 64, 372, 32);
		contentPane.add(textField_root);
		textField_root.setColumns(10);

		JTextArea txtrSize = new JTextArea();
		txtrSize.setEnabled(false);
		txtrSize.setEditable(false);
		txtrSize.setText("SIZE");
		txtrSize.setBounds(0, 0, 36, 22);
		contentPane.add(txtrSize);

		textField_size = new JTextField();
		textField_size.setText("1");
		textField_size.setEditable(false);
		textField_size.setBounds(0, 21, 36, 22);
		contentPane.add(textField_size);
		textField_size.setColumns(10);

		JTextArea txtrHight = new JTextArea();
		txtrHight.setEnabled(false);
		txtrHight.setEditable(false);
		txtrHight.setText("HIGHT");
		txtrHight.setBounds(42, 0, 44, 22);
		contentPane.add(txtrHight);

		textField_hight = new JTextField();
		textField_hight.setText("1");
		textField_hight.setEditable(false);
		textField_hight.setColumns(10);
		textField_hight.setBounds(42, 21, 44, 22);
		contentPane.add(textField_hight);

		JTextArea txtrMin = new JTextArea();
		txtrMin.setEnabled(false);
		txtrMin.setEditable(false);
		txtrMin.setText("MIN");
		txtrMin.setBounds(91, 0, 44, 22);
		contentPane.add(txtrMin);

		textField_min = new JTextField();
		textField_min.setText("1");
		textField_min.setEditable(false);
		textField_min.setColumns(10);
		textField_min.setBounds(91, 21, 44, 22);
		contentPane.add(textField_min);

		JTextArea txtrMax = new JTextArea();
		txtrMax.setEnabled(false);
		txtrMax.setEditable(false);
		txtrMax.setText("MAX");
		txtrMax.setBounds(142, 0, 44, 22);
		contentPane.add(txtrMax);

		textField_max = new JTextField();
		textField_max.setText("1");
		textField_max.setEditable(false);
		textField_max.setColumns(10);
		textField_max.setBounds(142, 21, 44, 22);
		contentPane.add(textField_max);

		JTextArea txtrRoot = new JTextArea();
		txtrRoot.setEnabled(false);
		txtrRoot.setEditable(false);
		txtrRoot.setText("ROOT");
		txtrRoot.setBounds(0, 72, 36, 22);
		contentPane.add(txtrRoot);

		textField_l2 = new JTextField();
		textField_l2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_l2.setEditable(false);
		textField_l2.setColumns(10);
		textField_l2.setBounds(52, 96, 372, 32);
		contentPane.add(textField_l2);

		txtrL = new JTextArea();
		txtrL.setText("L1");
		txtrL.setEnabled(false);
		txtrL.setEditable(false);
		txtrL.setBounds(0, 104, 36, 22);
		contentPane.add(txtrL);

		textField_l3 = new JTextField();
		textField_l3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_l3.setEditable(false);
		textField_l3.setColumns(10);
		textField_l3.setBounds(52, 129, 372, 32);
		contentPane.add(textField_l3);

		txtrL_1 = new JTextArea();
		txtrL_1.setText("L2");
		txtrL_1.setEnabled(false);
		txtrL_1.setEditable(false);
		txtrL_1.setBounds(0, 137, 36, 22);
		contentPane.add(txtrL_1);

		textField_l4 = new JTextField();
		textField_l4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_l4.setEditable(false);
		textField_l4.setColumns(10);
		textField_l4.setBounds(52, 162, 372, 32);
		contentPane.add(textField_l4);

		txtrL_2 = new JTextArea();
		txtrL_2.setText("L3");
		txtrL_2.setEnabled(false);
		txtrL_2.setEditable(false);
		txtrL_2.setBounds(0, 170, 36, 22);
		contentPane.add(txtrL_2);

		textField_l5 = new JTextField();
		textField_l5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_l5.setEditable(false);
		textField_l5.setColumns(10);
		textField_l5.setBounds(52, 194, 372, 32);
		contentPane.add(textField_l5);

		txtrL_3 = new JTextArea();
		txtrL_3.setText("L4");
		txtrL_3.setEnabled(false);
		txtrL_3.setEditable(false);
		txtrL_3.setBounds(0, 202, 36, 22);
		
		contentPane.add(txtrL_3);
		/**
		 * 
		 * 
		 * 
		 * START
		 * 
		 * 
		 */

		Integer maxI = tree.getMax();
		String maxS = "" + maxI;
		textField_max.setText(maxS);

		Integer minI = tree.getMin();
		String minS = "" + minI;
		textField_min.setText(minS);

		Integer sizeI = tree.size();
		String sizeS = "" + sizeI;
		textField_size.setText(sizeS);

		Integer heightI = tree.height();
		String heightS = "" + heightI;
		textField_hight.setText(heightS);

		printLevelorder(((MyBTree) tree).getRoot(), ((MyBTree) tree).m);
		for (int i = 0; i < levelorder.length; i++) {
			levelorder[i]=levelorder[i].replace("[[", "-[");
			levelorder[i]=levelorder[i].replace("]]", "]-     ");
		}

		switch (levelorder.length) {
		case 8:
			// textField_l7.setText(levelorder[7]);
		case 7:
			// textField_l6.setText(levelorder[6]);
		case 6:
			textField_l5.setText(levelorder[5]);
		case 5:
			textField_l4.setText(levelorder[4]);
		case 4:
			textField_l3.setText(levelorder[3]);
		case 3:
			textField_l3.setText(levelorder[2]);
		case 2:
			textField_l2.setText(levelorder[1]);
		case 1:
			textField_root.setText(levelorder[0]);
			break;
		default:
			System.out.println("*************SWITCH Default");

		}

	}

	private String[] levelorder = new String[tree.height()];
	private JTextField textField_l2;
	private JTextArea txtrL;
	private JTextField textField_l3;
	private JTextArea txtrL_1;
	private JTextField textField_l4;
	private JTextArea txtrL_2;
	private JTextField textField_l5;
	private JTextArea txtrL_3;

	public void printLevelorder(Node root, int m) {
		Node node = root;
		if (node == null)
			return;
		else {
			for (int i = 0; i < tree.height(); i++) {

				levelorder[i] = "";
				printLevelorder_rec(node, i, m);
				nodeLevel++;
			}
		}
	}

	private int nodeLevel = 0;

	private void printLevelorder_rec(Node node, int level, int m) {
		if (level > 0) {
			for (int i = 0; i < 2 * m + 1; i++) {
				if (node.getNode(i) != null) {
					levelorder[nodeLevel] += "[";
					printLevelorder_rec(node.getNode(i), level - 1, m);
					levelorder[nodeLevel] += "]";
				}
			}
		} else {
			for (int i = 0; i < 2 * m + 1; i++) {
				if (node.getValue(i) != null) {
					levelorder[nodeLevel] += " " + node.getValue(i) + " ";
				}
			}

		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
