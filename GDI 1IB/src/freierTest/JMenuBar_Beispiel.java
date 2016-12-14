package freierTest;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
 
 
public class JMenuBar_Beispiel
{
    // main-Methode
	 public static void main(String[] args)
	    {
	        /* Erzeugung eines neuen Dialoges */
	        JDialog meinJDialog = new JDialog();
	        meinJDialog.setTitle("JMenuBar für unser Java Tutorial Beispiel.");
	        // Wir setzen die Breite auf 450 und die Höhe auf 300 Pixel
	        meinJDialog.setSize(450,300);
	        // Zur Veranschaulichung erstellen wir hier eine Border
	        Border bo = new LineBorder(Color.yellow);
	        // Erstellung einer Menüleiste
	        JMenuBar bar = new JMenuBar();
	        // Wir setzen unsere Umrandung für unsere JMenuBar
	        bar.setBorder(bo);
	        // Erzeugung eines Objektes der Klasse JMenu
	        JMenu menu = new JMenu("Auswahl 1");
	        // Menü wird der Menüleiste hinzugefügt
	        bar.add(menu);
	        // Erzeugung eines Objektes der Klasse JMenu
	        JMenu menu2 = new JMenu("Auswahl 2");
	        // Menü wird der Menüleiste hinzugefügt
	        bar.add(menu2);
	        // Erzeugung eines Objektes der Klasse JMenuItem
	        JMenuItem item1 = new JMenuItem("Ich bin das JMenuItem");
	        // Wir fügen das JMenuItem unserem JMenu hinzu
	        menu.add(item1);
	     // Erzeugung eines Objektes der Klasse JMenuItem
	        JMenuItem item2 = new JMenuItem("Ich auch");
	        // Wir fügen das JMenuItem unserem JMenu hinzu
	        menu.add(item2);

	        // Menüleiste wird für den Dialog gesetzt
	        meinJDialog.setJMenuBar(bar);
	        // Wir lassen unseren Dialog anzeigen
	        meinJDialog.setVisible(true);
	    }
	}