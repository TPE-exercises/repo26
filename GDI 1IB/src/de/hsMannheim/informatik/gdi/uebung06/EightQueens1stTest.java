package de.hsMannheim.informatik.gdi.uebung06;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

import org.junit.After;
import org.junit.Test;

public class EightQueens1stTest {
	boolean debug = false;
	@After
	public void tearDown() throws Exception {
		new File("proto.txt").delete();
	}

	private int[][] linksOben = new int[][] {
			{1, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{1, 0, 0, 0, 0, 0, 0, 0}
	};
	
	private int[][] gültigeLösung = new int[][] {
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{1, 0, 0, 0, 0, 0, 0, 0}
	};
	
	@Test
	public void gültigeLösung() throws Exception {
		assertTrue(EightQueens.isValidSolution(gültigeLösung, debug));
	}

	@Test
	public void ungültigeLösung() throws Exception {
		assertFalse(EightQueens.isValidSolution(linksOben, debug));
	}
	
	@Test
	public void keineMarkierungFürEineGültigeLösung() throws Exception {
		int[][] copy = (int[][]) gültigeLösung.clone();
		EightQueens.markThreatenedQueens(copy);
		assertTrue(Arrays.equals(gültigeLösung, copy));
	}
	
	
	
	private String compareToString( int[][] expected, int[][] actual ) {
		String result = "\n";
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++)
				result += expected[row][col] + " ";
			result += "  <->  ";
			for (int col = 0; col < 8; col++)
				result += actual[row][col] + " ";
			result += "\n";
		}
		return result;
	}
	private boolean equals(int[][] expected, int[][] actual) {
		for (int row = 0; row < 8; row++)
			for (int col = 0; col < 8; col++)
				if (expected[row][col] != actual[row][col])
					return false;
		return true;
	}
	
	@Test
	public void readField() throws Exception {
		int[][] testField = new int[][] {
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0},
				{0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0}
		};
		System.out.println(new File("proto.txt").getAbsoluteFile());
		try (BufferedWriter out = new BufferedWriter(new FileWriter("proto.txt"))) {
			for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++)
					out.write(testField[row][col] + " ");
				out.newLine();
			}
		}
		
		int[][] field = EightQueens.readFieldFromFile("proto.txt");
		
		assertTrue(compareToString(testField, field), 
				equals(testField, field));
	}

}