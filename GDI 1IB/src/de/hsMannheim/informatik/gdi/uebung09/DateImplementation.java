package de.hsMannheim.informatik.gdi.uebung09;

import static gdi.MakeItSimple.*;

public class DateImplementation implements Date {

	int day;
	int month;
	int year;

	public DateImplementation(int day, int month, int year) {
		if (year < 1600 || year > 2400)
			throw new GDIException("Das Jahr darf nicht außerhalb von 1600 und 2400 liegen!");

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMonth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Date obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean laterThan(Date d2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Date add(int numberOfDays) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int differenceInDays(Date d2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Weekday getWeekday() {
		// TODO Auto-generated method stub
		return null;
	}
}
