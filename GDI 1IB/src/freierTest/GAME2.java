package freierTest;

import java.awt.Color;

public class GAME2 {

	final static int EMPTY = 0;
	final static int RED = 1;
	final static int BLUE = 2;
	final static int GREEN = 3;
	final static int YELLOW = 4;

	final static int RED_START = 31;
	final static int BLUE_START = 1;
	final static int GREEN_START = 11;
	final static int YELLOW_START = 21;

	public static int redNumberOfStones = 4;
	public static int blueNumberOfStones = 4;
	public static int greenNumberOfStones = 4;
	public static int yellowNumberOfStones = 4;

	public static int nowPlaying;

	public static boolean rollAgain = false;
	public static boolean comeOut = false;
	public static boolean run = true;
	public static int rollTime = 0;
	public static int augen = 0;

	public static void main(String[] args) {
		prepareForNewGame();
		System.out.println(roll3Times());
		System.out.println(cleanHome(nowPlaying));

	}

	/**
	 * 
	 * @return
	 */
	public static void roll() {
		System.out.println("---------------->roll");
		// würfle
		if (rollTime > 0) {
			rollTime--;
			augen = cube();
			run = true;
			if (augen == 6) {
				rollTime = 1;
				comeOut = true;
			}
		}
	}

	/**
	 * Zufällige Zahlzwischen 1-6
	 * 
	 * @return
	 */
	private static int cube() {
		System.out.println("---------------->cube");
		return (int) Math.floor(Math.random() * 6) + 1;

	}

	/**
	 * starte neue runde | setze nächsten spieler | setze würfelheufigkeit
	 */
	public static void nextPlayer() {
		System.out.println("---------------->nextPlayer");
		comeOut = false;
		run = false;
		augen = 0;
		MenschAergereDichNicht_GUI.runFinish = false;
		// setze nächsten spieler
		nowPlaying++;
		if (nowPlaying > 4)
			nowPlaying = 1;
		// bestimme heufigkeit des würfelns
		if (roll3Times())
			rollTime = 3;
		else
			rollTime = 1;

		System.out.println("----------------> Spieler " + nowPlaying);
	}

	/**
	 * prüfe ob 3x gewürfelt werden darf
	 * 
	 * @return
	 */
	private static boolean roll3Times() {
		System.out.println("---------------->roll3Times");
		switch (nowPlaying) {
		case (RED):
			// alle Figuren am Start
			if (cleanHome(RED) == 0)
				return true;
			// Haus nicht ordentlich
			else if (cleanHome(RED) == -1)
				return false;
			// haus ordenlich rest am Start
			else if (cleanHome(RED) + redNumberOfStones == 4)
				return true;
			break;
		case (BLUE):
			if (cleanHome(BLUE) == 0)
				return true;
			else if (cleanHome(BLUE) == -1)
				return false;
			else if (cleanHome(BLUE) + blueNumberOfStones == 4)
				return true;
			break;
		case (GREEN):
			if (cleanHome(GREEN) == 0)
				return true;
			else if (cleanHome(GREEN) == -1)
				return false;
			else if (cleanHome(GREEN) + greenNumberOfStones == 4)
				return true;
			break;
		case (YELLOW):
			if (cleanHome(YELLOW) == 0)
				return true;
			else if (cleanHome(YELLOW) == -1)
				return false;
			else if (cleanHome(YELLOW) + yellowNumberOfStones == 4)
				return true;
			break;
		}
		return false;
	}

	/**
	 * Nummer der Sauber im Haus stehenden Figuren | 0 wenn alle am Start | -1
	 * Haus nicht sauber
	 * 
	 * @param farbe
	 * @return
	 */
	private static int cleanHome(int farbe) {
		System.out.println("---------------->cleanHome");
		int cleanLevel = -1;
		switch (nowPlaying) {
		case (RED):
			if (redNumberOfStones == 4)
				return 0;
			else {
				for (int i = 0; i < 4; i++) {
					System.out.println(i + " | " + MenschAergereDichNicht_GUI.homeRed[i] + " | Level: " + cleanLevel);
					if (MenschAergereDichNicht_GUI.homeRed[i] && cleanLevel < 0) {
						return -1;
					} else if (MenschAergereDichNicht_GUI.homeRed[i]) {
						cleanLevel++;
					}
				}
			}
			return cleanLevel;
		case (BLUE):
			if (blueNumberOfStones == 4)
				return 0;
			else {
				for (int i = 0; i < 4; i++) {
					if (MenschAergereDichNicht_GUI.homeBlue[i] && cleanLevel < 0) {
						return -1;
					} else if (MenschAergereDichNicht_GUI.homeBlue[i]) {
						cleanLevel++;
					}
				}
			}
			return cleanLevel;
		case (GREEN):
			if (greenNumberOfStones == 4)
				return 0;
			else {
				for (int i = 0; i < 4; i++) {
					if (MenschAergereDichNicht_GUI.homeGreen[i] && cleanLevel < 0) {
						return -1;
					} else if (MenschAergereDichNicht_GUI.homeGreen[i]) {
						cleanLevel++;
					}
				}
			}
			return cleanLevel;
		case (YELLOW):
			if (yellowNumberOfStones == 4)
				return 0;
			else {
				for (int i = 0; i < 4; i++) {
					if (MenschAergereDichNicht_GUI.homeYellow[i] && cleanLevel < 0) {
						return -1;
					} else if (MenschAergereDichNicht_GUI.homeYellow[i]) {
						cleanLevel++;
					}
				}
			}
			return cleanLevel;

		}
		return -1;
	}

	/**
	 * index of firstFigure
	 * 
	 * @param farbe
	 * @return
	 */
	private static int firstInHome(int farbe) {
		System.out.println("---------------->firstInHome");
		switch (farbe) {
		case (RED):
			for (int i = 0; i < 4; i++)
				if (MenschAergereDichNicht_GUI.homeRed[i])
					return i;
			break;
		case (BLUE):
			for (int i = 0; i < 4; i++)
				if (MenschAergereDichNicht_GUI.homeBlue[i])
					return i;
			break;
		case (GREEN):
			for (int i = 0; i < 4; i++)
				if (MenschAergereDichNicht_GUI.homeGreen[i])
					return i;
			break;
		case (YELLOW):
			for (int i = 0; i < 4; i++)
				if (MenschAergereDichNicht_GUI.homeYellow[i])
					return i;
			break;

		}

		return 4;

	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public static boolean move(int index) {
		System.out.println("---------------->move");
		int pos = 0;
		System.out.println("----------------> Bewege Index: " + index);
		switch (nowPlaying) {
		case (RED):
			pos = MenschAergereDichNicht_GUI.statusRed[index];
			if (pos == 0 && augen != 6)
				return false;
			System.out.println("----------------> Red move " + pos + "");
			if (comeOut && pos == 0) {
				if (startWithNewFigure()) {
					return true;
				}
			} else if (fieldAllowed(pos, index)) {
				System.out.println("----------------> Red run");
				return runWithFigure(pos, index);
			}

			break;
		case (BLUE):
			pos = MenschAergereDichNicht_GUI.statusBlue[index];
			if (pos == 0 && augen != 6)
				return false;
			System.out.println("----------------> Blue move " + pos + "");
			if (comeOut && pos == 0) {
				if (startWithNewFigure()) {
					rollTime = 1;
					return true;
				}
			} else if (fieldAllowed(pos, index)) {
				System.out.println("----------------> Blue run");
				return runWithFigure(pos, index);
			}

			break;
		case (GREEN):
			pos = MenschAergereDichNicht_GUI.statusGreen[index];
			if (pos == 0 && augen != 6)
				return false;
			System.out.println("----------------> Green move " + pos + "");
			if (comeOut && pos == 0) {
				if (startWithNewFigure()) {
					rollTime = 1;
					return true;
				}
			} else if (fieldAllowed(pos, index)) {
				System.out.println("----------------> Green run");
				return runWithFigure(pos, index);
			}

			break;
		case (YELLOW):
			pos = MenschAergereDichNicht_GUI.statusYellow[index];
			if (pos == 0 && augen != 6)
				return false;
			System.out.println("----------------> Yellow move " + pos + "");
			if (comeOut && pos == 0) {
				if (startWithNewFigure()) {
					rollTime = 1;
					return true;
				}
			} else if (fieldAllowed(pos, index)) {
				System.out.println("----------------> Yellow run");
				return runWithFigure(pos, index);
			}

			break;
		}

		return false;

	}

	public static void update() {
		System.out.println("---------------->update");
		MenschAergereDichNicht_GUI.redIndex = 0;
		MenschAergereDichNicht_GUI.blueIndex = 0;
		MenschAergereDichNicht_GUI.greenIndex = 0;
		MenschAergereDichNicht_GUI.yellowIndex = 0;
		for (int i = 1; i <= 40; i++) {
			if (MenschAergereDichNicht_GUI.game[i] == 0) {
				MenschAergereDichNicht_GUI.farben[i] = Color.BLACK;
			} else if (MenschAergereDichNicht_GUI.game[i] == RED) {
				MenschAergereDichNicht_GUI.farben[i] = Color.RED;
				MenschAergereDichNicht_GUI.statusRed[MenschAergereDichNicht_GUI.redIndex] = i;
				MenschAergereDichNicht_GUI.redIndex++;
			} else if (MenschAergereDichNicht_GUI.game[i] == BLUE) {
				MenschAergereDichNicht_GUI.farben[i] = Color.BLUE;
				MenschAergereDichNicht_GUI.statusBlue[MenschAergereDichNicht_GUI.blueIndex] = i;
				MenschAergereDichNicht_GUI.blueIndex++;
			} else if (MenschAergereDichNicht_GUI.game[i] == GREEN) {
				MenschAergereDichNicht_GUI.farben[i] = Color.GREEN;
				MenschAergereDichNicht_GUI.statusGreen[MenschAergereDichNicht_GUI.greenIndex] = i;
				MenschAergereDichNicht_GUI.greenIndex++;
			} else if (MenschAergereDichNicht_GUI.game[i] == YELLOW) {
				MenschAergereDichNicht_GUI.farben[i] = Color.YELLOW;
				MenschAergereDichNicht_GUI.statusYellow[MenschAergereDichNicht_GUI.yellowIndex] = i;
				MenschAergereDichNicht_GUI.yellowIndex++;
			}
		}
	}

	/**
	 * 
	 * @param pos
	 * @return
	 */
	private static boolean setFigure(int newPos, int index, int oldPos) {
		System.out.println("---------------->setFigure");
		// feld ist leer
		if (MenschAergereDichNicht_GUI.game[newPos] == 0) {
			MenschAergereDichNicht_GUI.game[newPos] = nowPlaying;
			// wenn gerade aus dem start raus wird möglicherweise etwas falsches
			// gelöscht
			MenschAergereDichNicht_GUI.game[oldPos] = 0;
			switch (MenschAergereDichNicht_GUI.game[newPos]) {
			case (RED):
				MenschAergereDichNicht_GUI.statusRed[index] = newPos;
				break;
			case (BLUE):
				MenschAergereDichNicht_GUI.statusBlue[index] = newPos;
				break;
			case (GREEN):
				MenschAergereDichNicht_GUI.statusGreen[index] = newPos;
				break;
			case (YELLOW):
				MenschAergereDichNicht_GUI.statusYellow[index] = newPos;
				break;
			}
			return true;
		} // Feld vom Spieler selbst belegt
		else if (MenschAergereDichNicht_GUI.game[newPos] == nowPlaying) {
			return false;
		} // ein Spieler wird geschmissen
		else {
			switch (MenschAergereDichNicht_GUI.game[newPos]) {
			case (RED):
				redNumberOfStones++;
				MenschAergereDichNicht_GUI.redIndex--;
				for (int i = 0; i < 4; i++) {
					if (MenschAergereDichNicht_GUI.statusRed[i] == newPos) {
						MenschAergereDichNicht_GUI.statusRed[i] = 0;
					}
				}
				break;
			case (BLUE):
				blueNumberOfStones++;
				MenschAergereDichNicht_GUI.blueIndex--;
				for (int i = 0; i < 4; i++) {
					if (MenschAergereDichNicht_GUI.statusBlue[i] == newPos) {
						MenschAergereDichNicht_GUI.statusBlue[i] = 0;
					}
				}
				break;
			case (GREEN):
				greenNumberOfStones++;
				MenschAergereDichNicht_GUI.greenIndex--;
				for (int i = 0; i < 4; i++) {
					if (MenschAergereDichNicht_GUI.statusGreen[i] == newPos) {
						MenschAergereDichNicht_GUI.statusGreen[i] = 0;
					}
				}
				break;
			case (YELLOW):
				yellowNumberOfStones++;
				MenschAergereDichNicht_GUI.yellowIndex--;
				for (int i = 0; i < 4; i++) {
					if (MenschAergereDichNicht_GUI.statusYellow[i] == newPos) {
						MenschAergereDichNicht_GUI.statusYellow[i] = 0;
					}
				}
				break;
			}
			MenschAergereDichNicht_GUI.game[newPos] = nowPlaying;
			MenschAergereDichNicht_GUI.game[oldPos] = 0;
			switch (MenschAergereDichNicht_GUI.game[newPos]) {
			case (RED):
				MenschAergereDichNicht_GUI.statusRed[index] = newPos;
				break;
			case (BLUE):
				MenschAergereDichNicht_GUI.statusBlue[index] = newPos;
				break;
			case (GREEN):
				MenschAergereDichNicht_GUI.statusGreen[index] = newPos;
				break;
			case (YELLOW):
				MenschAergereDichNicht_GUI.statusYellow[index] = newPos;
				break;
			}
			return true;
		}

	}

	/**
	 * 
	 * @param nowPos
	 * @return
	 */
	private static boolean fieldAllowed(int nowPos, int index) {
		System.out.println("---------------->fieldAllowed");
		switch (nowPlaying) {

		case (RED):
			int hausPos;
			hausPos = nowPos + augen - RED_START + 1;
			if ((nowPos >= 31 && nowPos <= 40) || (nowPos >= 1 && nowPos <= 24))
				return true;
			else if (nowPos + augen <= 30)
				return true;
			// gehe ins Haus
			else if (firstInHome(RED) >= hausPos)
				return true;
			// bewege im Haus
			else if (nowPos > 40 && augen < 4) {
				return moveInHome(nowPos, index);
			}

			break;
		case (BLUE):
			hausPos = nowPos + augen - BLUE_START + 1;
			if (nowPos >= 1 && nowPos <= 34)
				return true;
			else if (nowPos + augen <= 40)
				return true;
			// gehe ins Haus
			else if (firstInHome(BLUE) >= hausPos)
				return true;
			// bewege im Haus
			else if (nowPos > 40 && augen < 4) {
				return moveInHome(nowPos, index);
			}

			break;
		case (GREEN):
			hausPos = nowPos + augen - GREEN_START + 1;
			if ((nowPos >= 11 && nowPos <= 40) || (nowPos >= 1 && nowPos <= 4))
				return true;
			else if (nowPos + augen <= 10)
				return true;
			// gehe ins Haus
			else if (firstInHome(GREEN) >= hausPos)
				return true;
			// bewege im Haus
			else if (nowPos > 40 && augen < 4) {
				return moveInHome(nowPos, index);
			}

			break;
		case (YELLOW):
			hausPos = nowPos + augen - YELLOW_START + 1;
			if ((nowPos >= 21 && nowPos <= 40) || (nowPos >= 1 && nowPos <= 14))
				return true;
			else if (nowPos + augen <= 20)
				return true;
			// gehe ins Haus
			else if (firstInHome(YELLOW) >= hausPos)
				return true;
			// bewege im Haus
			else if (nowPos > 40 && augen < 4) {
				return moveInHome(nowPos, index);
			}

			break;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	private static boolean startWithNewFigure() {
		System.out.println("---------------->startWithNewFigure");
		
		switch (nowPlaying) {
		case (RED):
			if (redNumberOfStones == 0 || MenschAergereDichNicht_GUI.game[31] == RED) {
				comeOut = false;
				return false;
			} else {
				redNumberOfStones--;
				if (setFigure(31, MenschAergereDichNicht_GUI.redIndex, 0)) {
					comeOut = false;
					return true;
				} else
					return false;
			}

		case (BLUE):
			if (blueNumberOfStones == 0 || MenschAergereDichNicht_GUI.game[1] == BLUE) {
				comeOut = false;
				return false;
			} else {
				blueNumberOfStones--;
				if (setFigure(1, MenschAergereDichNicht_GUI.blueIndex, 0)) {
					comeOut = false;
					return true;
				} else
					return false;
			}
		case (GREEN):
			if (greenNumberOfStones == 0 || MenschAergereDichNicht_GUI.game[11] == GREEN)

			{
				comeOut = false;
				return false;
			} else {
				greenNumberOfStones--;
				if (setFigure(11, MenschAergereDichNicht_GUI.greenIndex, 0)) {
					comeOut = false;
					return true;
				} else
					return false;
			}
		case (YELLOW):
			if (yellowNumberOfStones == 0 || MenschAergereDichNicht_GUI.game[21] == YELLOW) {
				comeOut = false;
				return false;
			} else {
				yellowNumberOfStones--;
				if (setFigure(21, MenschAergereDichNicht_GUI.yellowIndex, 0)) {
					comeOut = false;

					return true;
				} else
					return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param pos
	 * @return
	 */
	private static boolean runWithFigure(int pos, int index) {
		System.out.println("---------------->runWithFigure");
		int endField = pos + augen;
		if (endField > 40)
			endField -= 40;
		switch (nowPlaying) {
		case (RED):
			if (MenschAergereDichNicht_GUI.game[endField] == RED) {
				return false;
			} else if (pos <= 30 && endField > 30) {
				return goHome(pos, index);
			} else
				return (setFigure(endField, index, pos));

		case (BLUE):
			if (MenschAergereDichNicht_GUI.game[endField] == BLUE) {
				return false;
			} else if (pos <= 40 && endField > 40) {
				return goHome(pos, index);
			} else
				return (setFigure(endField, index, pos));

		case (GREEN):
			if (MenschAergereDichNicht_GUI.game[endField] == GREEN) {
				return false;
			} else if (pos <= 10 && endField > 10) {
				return goHome(pos, index);
			} else
				return (setFigure(endField, index, pos));

		case (YELLOW):
			if (MenschAergereDichNicht_GUI.game[endField] == YELLOW) {
				return false;
			} else if (pos <= 20 && endField > 20) {
				return goHome(pos, index);
			} else
				return (setFigure(endField, index, pos));

		}
		return false;
	}

	/**
	 * 
	 * @param pos
	 * @param index
	 * @return
	 */
	private static boolean goHome(int pos, int index) {
		System.out.println("---------------->GoHome");
		int hausPos;
		switch (nowPlaying) {
		case (RED):
			hausPos = pos + augen - RED_START + 1;
			if (hausPos > 4)
				return false;
			else if (firstInHome(RED) >= hausPos) {
				MenschAergereDichNicht_GUI.homeRed[hausPos - 1] = true;
				MenschAergereDichNicht_GUI.game[pos] = 0;
				MenschAergereDichNicht_GUI.statusRed[index] = hausPos + 40;
			} else
				System.out.println("_______________Unbekannter Fehler Rote Figur ins Haus | HausPos: " + hausPos
						+ " | firstInHome: " + firstInHome(RED));
			break;
		case (BLUE):
			hausPos = pos + augen - BLUE_START - 39;
			if (hausPos > 4)
				return false;
			else if (firstInHome(BLUE) >= hausPos) {
				MenschAergereDichNicht_GUI.homeBlue[hausPos - 1] = true;
				MenschAergereDichNicht_GUI.game[pos] = 0;
				MenschAergereDichNicht_GUI.statusBlue[index] = hausPos + 40;
			} else
				System.out.println("_______________Unbekannter Fehler blaue Figur ins Haus | HausPos: " + hausPos
						+ " | firstInHome: " + firstInHome(BLUE));
			break;
		case (GREEN):
			hausPos = pos + augen - GREEN_START + 1;
			if (hausPos > 4)
				return false;
			else if (firstInHome(GREEN) >= hausPos) {
				MenschAergereDichNicht_GUI.homeGreen[hausPos - 1] = true;
				MenschAergereDichNicht_GUI.game[pos] = 0;
				MenschAergereDichNicht_GUI.statusGreen[index] = hausPos + 40;
			} else
				System.out.println("_______________Unbekannter Fehler grüne Figur ins Haus | HausPos: " + hausPos
						+ " | firstInHome: " + firstInHome(GREEN));
			break;
		case (YELLOW):
			hausPos = pos + augen - YELLOW_START + 1;
			if (hausPos > 4)
				return false;
			else if (firstInHome(YELLOW) >= hausPos) {
				MenschAergereDichNicht_GUI.homeYellow[hausPos - 1] = true;
				MenschAergereDichNicht_GUI.game[pos] = 0;
				MenschAergereDichNicht_GUI.statusYellow[index] = hausPos + 40;
			} else
				System.out.println("_______________Unbekannter Fehler gelbe Figur ins Haus | HausPos: " + hausPos
						+ " | firstInHome: " + firstInHome(YELLOW));
			break;

		}

		return false;

	}

	/**
	 * 
	 * @param nowPos
	 * @return
	 */
	private static int mobility(int nowPos) {
		System.out.println("---------------->mobility");
		// TODO Methode Schreiben
		int mobility = 0;

		switch (nowPlaying) {
		case (RED):
			for (int i = nowPos - 40; i < 4; i++)
				if (!MenschAergereDichNicht_GUI.homeRed[i]) {
					mobility++;
				} else
					return mobility;
			break;
		case (BLUE):
			for (int i = nowPos - 40; i < 4; i++)
				if (!MenschAergereDichNicht_GUI.homeBlue[i]) {
					mobility++;
				} else
					return mobility;
			break;
		case (GREEN):
			for (int i = nowPos - 40; i < 4; i++)
				if (!MenschAergereDichNicht_GUI.homeGreen[i]) {
					mobility++;
				} else
					return mobility;
			break;
		case (YELLOW):
			for (int i = nowPos - 40; i < 4; i++)
				if (!MenschAergereDichNicht_GUI.homeYellow[i]) {
					mobility++;
				} else
					return mobility;
			break;

		}
		return 0;
	}

	private static boolean moveInHome(int nowPos, int index) {
		System.out.println("---------------->moveInHome");
		int mobility = mobility(nowPos);
		if (mobility < augen)
			return false;

		switch (nowPlaying) {
		case (RED):
			MenschAergereDichNicht_GUI.homeRed[nowPos - 40] = false;
			MenschAergereDichNicht_GUI.homeRed[nowPos - 40 + augen] = true;
			MenschAergereDichNicht_GUI.statusRed[index] = nowPos;
			return true;
			
		case (BLUE):
			MenschAergereDichNicht_GUI.homeBlue[nowPos - 40] = false;
			MenschAergereDichNicht_GUI.homeBlue[nowPos - 40 + augen] = true;
			MenschAergereDichNicht_GUI.statusRed[index] = nowPos;
			return true;
		case (GREEN):
			MenschAergereDichNicht_GUI.homeGreen[nowPos - 40] = false;
			MenschAergereDichNicht_GUI.homeGreen[nowPos - 40 + augen] = true;
			MenschAergereDichNicht_GUI.statusGreen[index] = nowPos;
			return true;
		case (YELLOW):
			MenschAergereDichNicht_GUI.homeYellow[nowPos - 40] = false;
			MenschAergereDichNicht_GUI.homeYellow[nowPos - 40 + augen] = true;
			MenschAergereDichNicht_GUI.statusYellow[index] = nowPos;
			return true;

		}
		return false;

	}

	/**
	 * 
	 */
	public static void prepareForNewGame() {
		System.out.println("---------------->prepareForNewGame");
		// spielfeld inizialisieren
		for (int i = 0; i < 40; i++) {
			MenschAergereDichNicht_GUI.game[i] = 0;
		}
		// häuser inizialisieren
		for (int i = 0; i < 4; i++) {
			MenschAergereDichNicht_GUI.homeRed[i] = false;
			MenschAergereDichNicht_GUI.homeBlue[i] = false;
			MenschAergereDichNicht_GUI.homeGreen[i] = false;
			MenschAergereDichNicht_GUI.homeYellow[i] = false;
		}
		for (int i = 0; i < 4; i++) {
			MenschAergereDichNicht_GUI.statusRed[i] = 0;
			MenschAergereDichNicht_GUI.statusBlue[i] = 0;
			MenschAergereDichNicht_GUI.statusGreen[i] = 0;
			MenschAergereDichNicht_GUI.statusYellow[i] = 0;
		}

		// ermitle ersten spieler
		int firstPlayer = (int) Math.floor(Math.random() * 4) + 1;
		switch (firstPlayer) {
		case (RED):
			System.out.println("Spieler ROT startet das Spiel");
			nowPlaying = RED;
			break;
		case (BLUE):
			System.out.println("Spieler BLAU startet das Spiel");
			nowPlaying = BLUE;
			break;
		case (GREEN):
			System.out.println("Spieler GRÜN startet das Spiel");
			nowPlaying = GREEN;
			break;
		case (YELLOW):
			System.out.println("Spieler GELB startet das Spiel");
			nowPlaying = YELLOW;
			break;
		}
		nextPlayer();
	}
}
