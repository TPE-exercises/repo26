package freierTest;

import static gdi.MakeItSimple.*;

public class MenschAergereDichNicht {

	final static int LEER = 0;
	/**
	 * ab 31
	 */
	final static int ROT = 1;
	/**
	 * ab 1
	 */
	final static int BLAU = 2;
	/**
	 * ab 11
	 */
	final static int GRUEN = 3;
	/**
	 * ab 21
	 */
	final static int GELB = 4;

	final static int ROT_START = 31;
	final static int BLAU_START = 1;
	final static int GRUEN_START = 11;
	final static int GELB_START = 21;

	static int farbe_start = 0;

	public static int rotAnzahlSteine = 4;
	public static int blauAnzahlSteine = 4;
	public static int gruenAnzahlSteine = 4;
	public static int gelbAnzahlSteine = 4;

	static int farbeAnzahlSteine = 0;

	static int[] rotPos = { 0, 0, 0, 0 };
	static int[] blauPos = { 0, 0, 0, 0 };
	static int[] gruenPos = { 0, 0, 0, 0 };
	static int[] gelbPos = { 0, 0, 0, 0 };

	public static int aktuellerSpieler;

	static boolean kommRaus = false;
	static boolean setzen = true;
	static int augen = 0;

	public static void main(String[] args) {

	}

	/**
	 * 
	 */
	public static void spielvorbereitung() {
		if (!isFilePresent("spielbrett.txt") || !isFilePresent("spielbrettKopie.txt") || !isFilePresent("hausRot.txt")
				|| !isFilePresent("hausBlau.txt") || !isFilePresent("hausGruen.txt") || !isFilePresent("hausGelb.txt")
				|| !isFilePresent("brettKopie.txt")) {
			throw new GDIException("EINE DATEI FEHLT");
		} else
			println("Das Spiel kann beginnen");

		raeumeAuf();
		/*
		 * Ermittle Startspieler
		 */
		int startSpieler = (int) Math.floor(Math.random() * 4) + 1;
		switch (startSpieler) {
		case (ROT):
			println("Spieler ROT startet das Spiel");
			aktuellerSpieler = ROT;
			break;
		case (BLAU):
			println("Spieler BLAU startet das Spiel");
			aktuellerSpieler = BLAU;
			break;
		case (GRUEN):
			println("Spieler GRÜN startet das Spiel");
			aktuellerSpieler = GRUEN;
			break;
		case (GELB):
			println("Spieler GELB startet das Spiel");
			aktuellerSpieler = GELB;
			break;
		}
		printSeperator();
	}

	/**
	 * 
	 */
	public static void spielablauf(int augen) {

		if (dreiMalWürfeln(aktuellerSpieler) && heufigkeitWuerfel == 0) {
			println("Du kannst nicht setzen");
			starteNeueRunde();

		} else if (dreiMalWürfeln(aktuellerSpieler) && augen != 6) {

		} else {
			System.out.println("---------------->Setzen: " + setzen + " kommRaus: " + kommRaus);
			while (setzen) {

				if (kommRaus) {
					kommRaus(aktuellerSpieler, augen);
				} else {
					setzeFigur(aktuellerSpieler, augen);
				}
			}

			if (gameOver(aktuellerSpieler)) {
				System.out.println("Game Over");
			}

		}
	}

	public static int heufigkeitWuerfel = 0;

	/**
	 * 
	 * @return
	 */
	public static int wuerfeln() {
		int augen = 0;
		setzen = false;
		kommRaus = false;

		// würfle
		if (heufigkeitWuerfel > 0) {
			heufigkeitWuerfel--;
			augen = wuerfel();
			setzen = true;
			if (augen == 6) {
				heufigkeitWuerfel = 1;
				kommRaus = true;
			}
		}
		return augen;
	}

	/**
	 * 
	 */
	public static void starteNeueRunde() {
		// bestimme heufigkeit des würfelns
		if (dreiMalWürfeln(aktuellerSpieler))
			heufigkeitWuerfel = 3;
		else
			heufigkeitWuerfel = 1;

		switch (aktuellerSpieler) {
		case (ROT):
			println("Spieler ROT muss Würfeln");
			farbeAnzahlSteine = rotAnzahlSteine;
			farbe_start = ROT_START;
			break;
		case (BLAU):
			println("Spieler BLAU muss Würfeln");
			farbeAnzahlSteine = blauAnzahlSteine;
			farbe_start = BLAU_START;
			break;
		case (GRUEN):
			println("Spieler GRÜN muss Würfeln");
			farbeAnzahlSteine = gruenAnzahlSteine;
			farbe_start = GRUEN_START;
			break;
		case (GELB):
			println("Spieler GELB muss Würfeln");
			farbeAnzahlSteine = gelbAnzahlSteine;
			farbe_start = GELB_START;
			break;
			
		}
		System.out.println("---------------->neue Runde");
		printSeperator();
	}

	/**
	 * 
	 * @return
	 */
	public static int wuerfel() {
		int augen = (int) Math.floor(Math.random() * 6) + 1;
		println("Du hast eine " + augen + " gewürfelt.");
		MenschAergereDichNicht_GUI.augen = augen;
		return augen;
	}

	/**
	 * 
	 * @param farbe
	 * @return
	 */
	private static void kommRaus(int farbe, int augen) {
		if (farbeAnzahlSteine == 0) {// alle Figuren draußen, und 6
			kommRaus = false;
			println("Du hast keine Figuren mehr am Start. Bewege eine auf dem Feld.");
			setzeFigur(aktuellerSpieler, augen);
		} else if (startBelegt(aktuellerSpieler)) {
			println("Dein Startfeld ist besetzt.");
			kommRaus = false;
			setzeFigur(aktuellerSpieler, augen);
		} else {
			if (pruefeObGeschlagen(farbe_start) != 0) {
				schlageFigur(farbe_start, pruefeObGeschlagen(farbe_start));
			}
			dateiNeueFigurAufBrett(aktuellerSpieler, farbe_start);
			kommRaus = false;
			println("Deine Figur wurde auf Feld " + farbe_start + " gesetzt.");
		}
		printSeperator();
	}

	/**
	 * 
	 * @param farbe
	 * @param augen
	 * @param pos
	 */
	private static void setzeFigur(int farbe, int augen) {

		println("Wähle aus, welche Figur du setzten möchtest.");
		// printStatus(aktuellerSpieler);
		welcheFigur = 0;
		while (!(welcheFigur >= 1 && welcheFigur <= 4)) {

		}
		int position = 0;
		switch (aktuellerSpieler) {
		case (ROT):
			position = rotPos[welcheFigur - 1];
			break;
		case (BLAU):
			position = blauPos[welcheFigur - 1];
			break;
		case (GRUEN):
			position = gruenPos[welcheFigur - 1];
			break;
		case (GELB):
			position = gelbPos[welcheFigur - 1];
			break;
		}
		if (zugMoeglich(position, augen, aktuellerSpieler)) {
			if (pruefeObGeschlagen(position) == LEER) {
				println("Deine Figur zieht auf das freie Feld " + (position + augen) + ".");
			} else {
				schlageFigur(position, pruefeObGeschlagen(position));
			}
			dateiFigurBewegtAufBrett(aktuellerSpieler, position, augen);
			setzen = false;
		} else if (insHaus(position, augen, aktuellerSpieler)) {
			println("Bewege Figur ins Haus.");
			dateiNeueFigurImHaus(aktuellerSpieler, position);
			dateiFigurVerschwindet(position);
			setzen = false;
		} else {
			println("Du kannst deine Figur nicht bewegen.");
			setzen = false;
		}

	}

	/**
	 * 
	 * @param pos
	 * @param geschlagener
	 */
	private static void schlageFigur(int pos, int geschlagener) {
		switch (geschlagener) {
		case (ROT):
			rotAnzahlSteine++;
			println("Du hast die rote Figur auf Feld " + pos + " geschlagen.");
			break;
		case (BLAU):
			blauAnzahlSteine++;
			println("Du hast die blaue Figur auf Feld " + pos + " geschlagen.");
			break;
		case (GRUEN):
			rotAnzahlSteine++;
			println("Du hast die grüne Figur auf Feld " + pos + " geschlagen.");
			break;
		case (GELB):
			rotAnzahlSteine++;
			println("Du hast die gelbe Figur auf Feld " + pos + " geschlagen.");
			break;
		}
	}

	private static void raeumeAuf() {

		Object datei = openOutputFile("spielbrett.txt");
		for (int i = 0; i < 40; i++) {
			println(datei, 0);
		}
		closeOutputFile(datei);
		datei = openOutputFile("hausRot.txt");
		for (int i = 0; i < 4; i++) {
			println(datei, 0);
		}
		closeOutputFile(datei);
		datei = openOutputFile("hausBlau.txt");
		for (int i = 0; i < 4; i++) {
			println(datei, 0);
		}
		closeOutputFile(datei);
		datei = openOutputFile("hausGruen.txt");
		for (int i = 0; i < 4; i++) {
			println(datei, 0);
		}
		closeOutputFile(datei);
		datei = openOutputFile("hausGelb.txt");
		for (int i = 0; i < 4; i++) {
			println(datei, 0);
		}
		closeOutputFile(datei);

	}

	/**
	 * 
	 */
	private static void printSeperator() {
		println("---------------------------------");
	}

	private static boolean startBelegt(int farbe) {
		switch (farbe) {
		case (ROT):
			for (int i = 0; i < 4; i++) {
				if (rotPos[i] == 31)
					return true;
			}
			break;
		case (BLAU):
			for (int i = 0; i < 4; i++) {
				if (blauPos[i] == 1)
					return true;
			}
			break;
		case (GRUEN):
			for (int i = 0; i < 4; i++) {
				if (gruenPos[i] == 11)
					return true;
			}
			break;
		case (GELB):
			for (int i = 0; i < 4; i++) {
				if (gelbPos[i] == 21)
					return true;
			}
			break;
		}

		return false;
	}

	/**
	 * position+schritte möglich -> true ; wenn ins haus || nicht möglich ->
	 * false
	 * 
	 * @param position
	 * @param schritte
	 * @return
	 */
	private static boolean zugMoeglich(int position, int schritte, int farbe) {

		switch (farbe) {

		case (ROT):
			for (int i = 0; i < 4; i++) {
				if (rotPos[i] == position) {
					if ((position >= 31 && position <= 40) || (position >= 1 && position <= 24))
						return true;
					else if (position + schritte <= 30)
						return true;
				}
			}
			break;
		case (BLAU):
			for (int i = 0; i < 4; i++) {
				if (blauPos[i] == position) {
					if (position + schritte <= 40)
						return false;
				}
			}
			break;
		case (GRUEN):
			for (int i = 0; i < 4; i++) {
				if (gruenPos[i] == position) {
					if ((position >= 17 && position <= 40) || (position >= 1 && position <= 4))
						return true;
					else if (position + schritte <= 10)
						return true;
				}
			}
			break;
		case (GELB):
			for (int i = 0; i < 4; i++) {
				if (gelbPos[i] == position) {
					if ((position >= 21 && position <= 40) || (position >= 1 && position <= 14))
						return true;
					else if (position + schritte <= 20)
						return true;
				}
			}
			break;
		}
		return false;
	}

	/**
	 * 
	 * @param position
	 * @param schritte
	 * @param farbe
	 * @return
	 */
	private static boolean insHaus(int position, int schritte, int farbe) {
		int platzBis = 0;
		int laufeInsHaus = 0;
		switch (farbe) {
		case (ROT):
			platzBis = ersteFigurImHaus(farbe) - 1;
			if (platzBis <= 0)
				return false;
			laufeInsHaus = position - 30 + schritte;
			if (laufeInsHaus > platzBis)
				return false;

			dateiFigurVerschwindet(position);
			dateiNeueFigurImHaus(farbe, laufeInsHaus);

			break;
		case (BLAU):
			platzBis = ersteFigurImHaus(farbe) - 1;
			if (platzBis <= 0)
				return false;
			laufeInsHaus = position - 40 + schritte;
			if (laufeInsHaus > platzBis)
				return false;

			dateiFigurVerschwindet(position);
			dateiNeueFigurImHaus(farbe, laufeInsHaus);

			break;
		case (GRUEN):
			platzBis = ersteFigurImHaus(farbe) - 1;
			if (platzBis <= 0)
				return false;
			laufeInsHaus = position - 10 + schritte;
			if (laufeInsHaus > platzBis)
				return false;

			dateiFigurVerschwindet(position);
			dateiNeueFigurImHaus(farbe, laufeInsHaus);

			break;
		case (GELB):
			platzBis = ersteFigurImHaus(farbe) - 1;
			if (platzBis <= 0)
				return false;
			laufeInsHaus = position - 20 + schritte;
			if (laufeInsHaus > platzBis)
				return false;

			dateiFigurVerschwindet(position);
			dateiNeueFigurImHaus(farbe, laufeInsHaus);

			break;
		}

		return false;

	}

	/**
	 * gibt die Farbe an pos aus
	 * 
	 * @param pos
	 * @return
	 */
	private static int pruefeObGeschlagen(int pos) {
		// lesen
		Object spielbrett = openInputFile("spielbrett.txt");

		for (int i = 0; i < pos; i++) {
			readInt(spielbrett);
		}
		int wasIstAnPos = readInt(spielbrett);

		closeInputFile(spielbrett);
		return wasIstAnPos;
	}

	/**
	 * 
	 */
	private static void dateiKopiereSpielbrett() {
		// lesen
		Object spielbrett = openInputFile("spielbrett.txt");
		// schreiben
		Object kopie = openOutputFile("spielbrettKopie.txt");
		int value;
		for (int i = 0; i < 40; i++) {
			value = readInt(spielbrett);
			println(kopie, value);
		}
		closeOutputFile(kopie);
		closeInputFile(spielbrett);
	}

	/**
	 * 
	 * @param farbe
	 */
	private static void dateiKopiereHaus(int farbe) {
		// lesen
		Object haus = null;
		switch (farbe) {
		case (ROT):
			haus = openInputFile("hausRot.txt");
			break;
		case (BLAU):
			haus = openInputFile("hausBlau.txt");
			break;
		case (GRUEN):
			haus = openInputFile("hausGruen.txt");
			break;
		case (GELB):
			haus = openInputFile("hausGelb.txt");
			break;
		}
		// schreiben
		Object kopie = openOutputFile("brettKopie.txt");
		int value;
		for (int i = 0; i < 4; i++) {
			value = readInt(haus);
			println(kopie, value);
		}
		closeOutputFile(kopie);
		closeInputFile(haus);
	}

	/**
	 * 
	 * @param farbe
	 * @param pos
	 */
	private static void dateiNeueFigurImHaus(int farbe, int pos) {
		dateiKopiereHaus(farbe);
		// lesen
		Object kopie = openInputFile("brettKopie.txt");
		// schreiben
		Object haus = null;
		switch (farbe) {
		case (ROT):
			haus = openOutputFile("hausRot.txt");
			break;
		case (BLAU):
			haus = openOutputFile("hausBlau.txt");
			break;
		case (GRUEN):
			haus = openOutputFile("hausGruen.txt");
			break;
		case (GELB):
			haus = openOutputFile("hausGelb.txt");
			break;
		}

		int value;
		for (int i = 0; i < pos; i++) {
			value = readInt(kopie);
			println(haus, value);
		}
		println(haus, farbe);
		readInt(kopie);
		for (int i = pos + 1; i < 4; i++) {
			value = readInt(kopie);
			println(haus, value);
		}

		closeOutputFile(haus);
		closeInputFile(kopie);
	}

	/**
	 * 
	 * @param farbe
	 * @param pos
	 * @param schritte
	 */
	private static void dateiFigurBewegtImHaus(int farbe, int pos, int schritte) {
		dateiKopiereHaus(farbe);
		// lesen
		Object kopie = openInputFile("brettKopie.txt");
		// schreiben
		Object haus = null;
		switch (farbe) {
		case (ROT):
			haus = openOutputFile("hausRot.txt");
			break;
		case (BLAU):
			haus = openOutputFile("hausBlau.txt");
			break;
		case (GRUEN):
			haus = openOutputFile("hausGruen.txt");
			break;
		case (GELB):
			haus = openOutputFile("hausGelb.txt");
			break;
		}

		int value;
		for (int i = 1; i < pos; i++) {
			value = readInt(kopie);
			println(haus, value);
		}
		println(haus, 0);
		readInt(kopie);
		for (int i = pos + 1; i < pos + schritte; i++) {
			value = readInt(kopie);
			println(haus, value);
		}
		println(haus, farbe);
		readInt(kopie);
		for (int i = pos + schritte + 1; i <= 4; i++) {
			value = readInt(kopie);
			println(haus, value);
		}

		closeOutputFile(haus);
		closeInputFile(kopie);
	}

	/**
	 * 
	 * @param farbe
	 * @param pos
	 */
	private static void dateiNeueFigurAufBrett(int farbe, int pos) {
		dateiKopiereSpielbrett();
		// lesen
		Object kopie = openInputFile("spielbrettKopie.txt");
		// schreiben
		Object spielbrett = openOutputFile("spielbrett.txt");

		int value;
		for (int i = 1; i < pos; i++) {
			value = readInt(kopie);
			println(spielbrett, value);
		}
		println(spielbrett, farbe);
		readInt(kopie);
		for (int i = pos + 1; i <= 40; i++) {
			value = readInt(kopie);
			println(spielbrett, value);
		}

		closeOutputFile(spielbrett);
		closeInputFile(kopie);
		MenschAergereDichNicht_GUI.setzeFarbe(pos, farbe);
		switch (farbe) {
		case (ROT):
			for (int i = 0; i < 4; i++) {
				if (rotPos[i] == 0) {
					rotPos[i] = pos;
					rotAnzahlSteine--;

					return;
				}
			}
			break;
		case (BLAU):
			for (int i = 0; i < 4; i++) {
				if (blauPos[i] == 0) {
					blauPos[i] = pos;
					blauAnzahlSteine--;
					return;
				}
			}
			break;
		case (GRUEN):
			for (int i = 0; i < 4; i++) {
				if (gruenPos[i] == 0) {
					gruenPos[i] = pos;
					gruenAnzahlSteine--;
					return;
				}
			}
			break;
		case (GELB):
			for (int i = 0; i < 4; i++) {
				if (gelbPos[i] == 0) {
					gelbPos[i] = pos;
					gelbAnzahlSteine--;
					return;
				}
			}
			break;
		}
	}

	/**
	 * 
	 * @param farbe
	 * @param pos
	 * @param schritte
	 */
	private static void dateiFigurBewegtAufBrett(int farbe, int pos, int schritte) {
		dateiKopiereSpielbrett();
		// lesen
		Object kopie = openInputFile("spielbrettKopie.txt");
		// schreiben
		Object spielbrett = openOutputFile("spielbrett.txt");
		int value;
		// über "0" wechsel
		if (pos + schritte > 40) {
			// kopiere bis posNeu und setze Figur
			for (int i = 1; i < pos + schritte - 40; i++) {
				value = readInt(kopie);
				println(spielbrett, value);

			}
			println(spielbrett, farbe);
			readInt(kopie);
			// kopiere bis pos und lösche
			for (int i = pos + schritte - 40 + 1; i < pos; i++) {
				value = readInt(kopie);
				println(spielbrett, value);
			}
			println(spielbrett, LEER);
			readInt(kopie);
			// kopiere bis ende
			for (int i = pos + 1; i <= 40; i++) {
				value = readInt(kopie);
				println(spielbrett, value);
			}
		} else {
			// kopiere bis pos und lösche
			for (int i = 1; i < pos; i++) {
				value = readInt(kopie);
				println(spielbrett, value);
			}
			println(spielbrett, LEER);
			readInt(kopie);
			// kopiere bis posNeu und Setze Figur
			for (int i = pos + 1; i < pos + schritte; i++) {
				value = readInt(kopie);
				println(spielbrett, value);
			}
			println(spielbrett, farbe);
			readInt(kopie);
			// kopiere Rest
			for (int i = pos + schritte + 1; i <= 40; i++) {
				value = readInt(kopie);
				println(spielbrett, value);
			}
		}

		closeOutputFile(spielbrett);
		closeInputFile(kopie);

		MenschAergereDichNicht_GUI.setzeFarbe(pos + schritte, farbe);
		MenschAergereDichNicht_GUI.setzeFarbe(pos, LEER);
		// Speichere Positionen des Spielers im Array
		switch (farbe) {
		case (ROT):
			for (int i = 0; i < 4; i++) {
				if (rotPos[i] == pos) {
					rotPos[i] = pos + schritte;
					return;
				}
			}
			break;
		case (BLAU):
			for (int i = 0; i < 4; i++) {
				if (blauPos[i] == pos) {
					blauPos[i] = pos + schritte;
					return;
				}
			}
			break;
		case (GRUEN):
			for (int i = 0; i < 4; i++) {
				if (gruenPos[i] == pos) {
					gruenPos[i] = pos + schritte;
					return;
				}
			}
			break;
		case (GELB):
			for (int i = 0; i < 4; i++) {
				if (gelbPos[i] == pos) {
					gelbPos[i] = pos + schritte;
					return;
				}
			}
			break;
		}
	}

	/**
	 * Figur geht ins Haus
	 * 
	 * @param pos
	 */
	private static void dateiFigurVerschwindet(int pos) {
		dateiKopiereSpielbrett();
		// lesen
		Object kopie = openInputFile("spielbrettKopie.txt");
		// schreiben
		Object spielbrett = openOutputFile("spielbrett.txt");

		int value;
		for (int i = 1; i < pos; i++) {
			value = readInt(kopie);
			println(spielbrett, value);
		}
		println(spielbrett, 0);
		readInt(kopie);
		for (int i = pos + 1; i <= 40; i++) {
			value = readInt(kopie);
			println(spielbrett, value);
		}

		closeOutputFile(spielbrett);
		closeInputFile(kopie);

		MenschAergereDichNicht_GUI.setzeFarbe(pos, LEER);

	}

	/**
	 * Alle Figuren tief im Haus und keinen Auf dem Spielbrett
	 * 
	 * @param farbe
	 * @return
	 */
	private static boolean dreiMalWürfeln(int farbe) {
		switch (farbe) {
		case (ROT):
			if (rotAnzahlSteine == 4)
				return true;
			else if (hausSauber(ROT) == -1)
				return false;
			else if (hausSauber(ROT) + rotAnzahlSteine == 4)
				return true;
			break;
		case (BLAU):
			if (blauAnzahlSteine == 4)
				return true;
			else if (hausSauber(BLAU) == -1)
				return false;
			else if (hausSauber(BLAU) + blauAnzahlSteine == 4)
				return true;
			break;
		case (GRUEN):
			if (gruenAnzahlSteine == 4)
				return true;
			else if (hausSauber(GRUEN) == -1)
				return false;
			else if (hausSauber(GRUEN) + gruenAnzahlSteine == 4)
				return true;
			break;
		case (GELB):
			if (gelbAnzahlSteine == 4)
				return true;
			else if (hausSauber(GELB) == -1)
				return false;
			else if (hausSauber(GELB) + gelbAnzahlSteine == 4)
				return true;
			break;
		}

		return false;
	}

	/**
	 * 
	 * @param farbe
	 * @return 0 = nicht sauber; 1-4 anzahl der sauberen
	 */
	private static int hausSauber(int farbe) {
		int ordnung = 0;
		switch (farbe) {
		case (ROT):
			Object dateiRot = openInputFile("hausRot.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiRot) == 1) {
					ordnung++;
				} else
					ordnung = 0;
			}
			closeInputFile(dateiRot);
			break;
		case (BLAU):
			Object dateiBlau = openInputFile("hausBlau.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiBlau) == 1) {
					ordnung++;
				} else
					ordnung = 0;
			}
			closeInputFile(dateiBlau);
			break;
		case (GRUEN):
			Object dateiGruen = openInputFile("hausGruen.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiGruen) == 1) {
					ordnung++;
				} else
					ordnung = 0;
			}
			closeInputFile(dateiGruen);
			break;
		case (GELB):
			Object dateiGelb = openInputFile("hausGelb.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiGelb) == 1) {
					ordnung++;
				} else
					ordnung = 0;
			}
			closeInputFile(dateiGelb);
			break;
		}

		return ordnung;

	}

	/**
	 * Position von erster Figur im Haus; 0, wenn keine im Haus
	 * 
	 * @param farbe
	 * @return
	 */
	private static int ersteFigurImHaus(int farbe) {

		switch (farbe) {
		case (ROT):
			Object dateiRot = openInputFile("hausRot.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiRot) == 1) {
					return i + 1;
				}
			}
			closeInputFile(dateiRot);
			break;
		case (BLAU):
			Object dateiBlau = openInputFile("hausBlau.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiBlau) == 1) {
					return i + 1;
				}
			}
			closeInputFile(dateiBlau);
			break;
		case (GRUEN):
			Object dateiGruen = openInputFile("hausGruen.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiGruen) == 1) {
					return i + 1;
				}
			}
			closeInputFile(dateiGruen);
			break;
		case (GELB):
			Object dateiGelb = openInputFile("hausGelb.txt");
			for (int i = 0; i < 4; i++) {
				if (readInt(dateiGelb) == 1) {
					return i + 1;
				}
			}
			closeInputFile(dateiGelb);
			break;
		}

		return 0;

	}

	private static void printStatus(int farbe) {
		int figurenAmStart = 0;
		String pos = "";
		switch (farbe) {
		case (ROT):
			figurenAmStart = rotAnzahlSteine;
			for (int i = 0; i < 4; i++) {
				pos += "Figur ";
				pos += i + 1;

				if (rotPos[i] == 0)
					pos += " Start";
				else if (rotPos[i] > 40) {
					pos += "Haus an ";
					pos += rotPos[i] - 40;
				} else {
					pos += ": Feld ";
					pos += rotPos[i];
				}
				pos += " | ";
			}
			break;
		case (BLAU):
			figurenAmStart = blauAnzahlSteine;
			for (int i = 0; i < 4; i++) {
				pos += "Figur ";
				pos += i + 1;

				if (blauPos[i] == 0)
					pos += " Start";
				else if (blauPos[i] > 40) {
					pos += "Haus an ";
					pos += blauPos[i] - 40;
				} else {
					pos += ": Feld ";
					pos += blauPos[i];
				}
				pos += " | ";
			}
			break;
		case (GRUEN):
			figurenAmStart = gruenAnzahlSteine;
			for (int i = 0; i < 4; i++) {
				pos += "Figur ";
				pos += i + 1;

				if (gruenPos[i] == 0)
					pos += " Start";
				else if (gruenPos[i] > 40) {
					pos += "Haus an ";
					pos += gruenPos[i] - 40;
				} else {
					pos += ": Feld ";
					pos += gruenPos[i];
				}
				pos += " | ";
			}
			break;
		case (GELB):
			figurenAmStart = gelbAnzahlSteine;
			for (int i = 0; i < 4; i++) {
				pos += "Figur ";
				pos += i + 1;

				if (gelbPos[i] == 0)
					pos += " Start";
				else if (gelbPos[i] > 40) {
					pos += "Haus an ";
					pos += gelbPos[i] - 40;
				} else {
					pos += ": Feld ";
					pos += gelbPos[i];
				}
				pos += " | ";
			}
			break;
		}
		println("Spieler " + aktuellerSpieler + " hat " + figurenAmStart + " Figuren am Start.");
		println(pos);
		printSeperator();
	}

	/**
	 * Hat farbe das Spiel gewonnen
	 * 
	 * @param farbe
	 * @return
	 */
	private static boolean gameOver(int farbe) {
		switch (farbe) {
		case (ROT):
			if (hausSauber(farbe) == 4)
				return true;
			break;
		case (BLAU):
			if (hausSauber(farbe) == 4)
				return true;
			break;
		case (GRUEN):
			if (hausSauber(farbe) == 4)
				return true;
			break;
		case (GELB):
			if (hausSauber(farbe) == 4)
				return true;
			break;
		}
		return false;
	}

}
