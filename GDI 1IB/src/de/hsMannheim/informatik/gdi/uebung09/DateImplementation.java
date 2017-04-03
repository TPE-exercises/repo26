package de.hsMannheim.informatik.gdi.uebung09;

import static gdi.MakeItSimple.*;

public class DateImplementation implements Date {

	int day;
	int month;
	int year;

	public DateImplementation(int day, int month, int year) {
		if (year < 1600 || year > 2400)
			throw new GDIException("Das Jahr darf nicht außerhalb von 1600 und 2400 liegen!");
		if (month < 1 || month > 12)
			throw new GDIException("Der Monat muss existieren! (1-12)");
		int monthDays = monthDays(month, year);
		if (day < 1 || day > monthDays)
			throw new GDIException("Der Tag muss im Monat existieren!");

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public static void main(String[] args) {
		DateImplementation name = new DateImplementation(29, 2, 2016);
//		println(name.toString());
		DateImplementation name2 = new DateImplementation(10, 1, 2017);
		println((name.differenceInDays(name2)));
//		println(name.add(365));
		
	}

	@Override
	public int getDay() {

		return day;
	}

	@Override
	public int getMonth() {

		return month;
	}

	@Override
	public int getYear() {

		return year;
	}

	@Override
	public boolean equals(Date obj) {

		if (this.day == obj.getDay() && this.month == obj.getMonth() && this.year == obj.getYear())
			return true;

		return false;
	}

	@Override
	public boolean laterThan(Date d2) {

		if (this.year > d2.getYear())
			return true;

		if (this.year == d2.getYear())
			if (this.month > d2.getMonth())
				return true;

			else if (this.month == d2.getMonth())
				if (this.day > d2.getDay())
					return true;

		return false;
	}

	@Override
	public Date add(int numberOfDays) {

		int newday = this.day;
		int newmonth = this.month;
		int newyear = this.year;

		if (numberOfDays > 0) {
			while (numberOfDays != 0) {

		

				newday++;

				if (newday > monthDays(newmonth, newyear)) {
					newmonth++;
					newday = 1;
				}
				if (newmonth > 12) {
					newyear++;
					newmonth = 1;
					newday = 1;
				}

				numberOfDays--;

			}
			Date newdate = new DateImplementation(newday, newmonth, newyear);
			return newdate;
		} else if (numberOfDays == 0) {
			Date newdate = new DateImplementation(newday, newmonth, newyear);
			return newdate;
		} else {
			while (numberOfDays != 0) {

				newday--;

				if (newday == 0) {
					newmonth--;
					newday = monthDays(newmonth, newyear);
				}
				if (newmonth == 0) {
					newyear--;
					newmonth = 12;
					newday = monthDays(newmonth, newyear);
				}

				numberOfDays++;

			}
			Date newdate = new DateImplementation(newday, newmonth, newyear);
			return newdate;
		}

	}
	
	private int monthDays(int month, int year){
		int monthDays = 0;
		switch (month) {
		case (1):
			monthDays = 31;
			break;
		case (2):
			monthDays = 28;
			if ((year - 1900) % 4 == 0 && year % 400 == 0)
				monthDays += 1;
			break;
		case (3):
			monthDays = 31;
			break;
		case (4):
			monthDays = 30;
			break;
		case (5):
			monthDays = 31;
			break;
		case (6):
			monthDays = 30;
			break;
		case (7):
			monthDays = 31;
			break;
		case (8):
			monthDays = 31;
			break;
		case (9):
			monthDays = 30;
			break;
		case (10):
			monthDays = 31;
			break;
		case (11):
			monthDays = 30;
			break;
		case (12):
			monthDays = 31;
			break;
		default: 
			monthDays = 31;
		}
		
		
		return monthDays;
		
	}
	

	@Override
	public int differenceInDays(Date d2) {
		
		int difference = 0;
		
		if(this.laterThan(d2)){
			while(!this.equals(d2)){
				d2 = d2.add(1);
				difference ++;
			}
		}
		else if(!this.laterThan(d2)){
			while(!this.equals(d2)){
				d2 = d2.add(-1);
				difference ++;
			}
		}
		
		return difference;
	}

	@Override
	public Weekday getWeekday() {

		int weekday = 0;

		int yearsSince1900 = year - 1900;
		weekday += yearsSince1900 % 7;
		weekday += (yearsSince1900 / 4) % 7;

		switch (month) {
		case (1):
			weekday += 0;
			break;
		case (2):
			weekday += 3;
			break;
		case (3):
			weekday += 3;
			break;
		case (4):
			weekday += 6;
			break;
		case (5):
			weekday += 1;
			break;
		case (6):
			weekday += 4;
			break;
		case (7):
			weekday += 6;
			break;
		case (8):
			weekday += 2;
			break;
		case (9):
			weekday += 5;
			break;
		case (10):
			weekday += 0;
			break;
		case (11):
			weekday += 3;
			break;
		case (12):
			weekday += 5;
			break;
		}

		if (yearsSince1900 % 4 == 0)
			if (month == 1 || month == 2)
				weekday--;

		weekday += day;
		weekday = weekday % 7;

		switch (weekday) {
		case (0):
			return Weekday.SUNDAY;
		case (1):
			return Weekday.MONDAY;
		case (2):
			return Weekday.TUESDAY;
		case (3):
			return Weekday.WEDNESDAY;
		case (4):
			return Weekday.THURSDAY;
		case (5):
			return Weekday.FRIDAY;
		case (6):
			return Weekday.SATURDAY;
		default:
			return null;
		}

	}

	public String toString() {
		String string = "";
		string += day;
		string += ".";
		string += month;
		string += ".";
		string += year;

		return string;

	}
}
