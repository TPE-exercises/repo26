package OwnUtils;

public class JavaDocDesign {

	/**
	 * <b>NOT RUNABLE</b>
	 * <li>kleine Hilfe
	 * <li>zeigt möglichkeien
	 * <li> alles mit JavaDoc
	 * <br>
	 *<pre><q>Alles kann besser sein!</q>
	 * <hr>
	 * 
	 * @author Janneck Lange
	 */
	public static void main(String[] args) {
		main(args);
	}

	/**
	 * beforeTest
	 * <q>test</q> afterTest
	 */
	private static void q() {
		// Zitat
	}

	/**
	 * beforeTest
	 * <li>test
	 * <li>test2
	 * <li>test3 afterTest
	 */
	private static void li() {
		// Liste
	}

	/**
	 * beforeTest <b>Test</b> afterTest
	 */
	private static void b() {
		// Dick
	}

	/**
	 * beforeTest
	 * 
	 * <pre>
	 * test
	 * </pre>
	 * 
	 * afterTest
	 */
	private static void pre() {

	}

	/**
	 * beforeTest <i>test</i> afterTest
	 */
	private static void i() {
		// Kusiv
	}

	/**
	 * beforeTest <br>
	 * test afterTest
	 */
	private static void br() {
		// umbruch
	}

	/**
	 * beforeTest
	 * <hr>
	 * test afterTest
	 */
	private static void hr() {
		// trennstrich
	}

}
