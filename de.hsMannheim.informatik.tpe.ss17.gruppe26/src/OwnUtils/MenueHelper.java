package OwnUtils;

import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.readLine;

public class MenueHelper {

	// public static void main(String[] args){
	// menuePrinter("option 1", "option 2","option 3");
	// }

	/**
	 * choose an Option between min and max. catch enter of Strings
	 * 
	 * @author lange
	 * @param int
	 *            min
	 * @param int
	 *            max
	 * @return int value
	 */
	public static int chooseOption(int min, int max) {
		int value = 0;
		do {
			try {
				value = readInt();
			} catch (Exception ex) {
				System.out.println("Geben Sie eine Zahl ein!");
			}
			readLine();
			if (value > max || value < min)
				System.out.println("Geben Sie einen Wert zwischen " + min + " und " + max + " ein.");
		} while (value > max || value < min);
		return value;
	}

	/**
	 * generate menuetext
	 * 
	 * @author lange
	 * @param String
	 *            "restparam"
	 */
	public static void menuePrinter(String... menueOptions) {
		OwnUtils.printLines.printSeperatorLine();
		System.out.println("Wählen Sie eine der folgenden Optionen: ");
		for (int i = 0; i < menueOptions.length; i++) {
			System.out.println("(" + i + ") " + menueOptions[i]);
		}
	}
}
