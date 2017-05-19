package OwnUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
	public static void main(String[] args) {
		System.out.println(readInt());
	}

	public static String readLine() {
		String string = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			string = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;
	}

	public static int readInt() {
		int i = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			i = Integer.parseInt(br.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
}
