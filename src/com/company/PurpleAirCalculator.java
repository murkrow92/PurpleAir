package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PurpleAirCalculator {

	private static Date startDate = new Date(2009, 6, 1);
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public static long differentTime(Date calcDate) {
		return calcDate.getTime() - startDate.getTime();
	}

	public static void calculate(){
		Scanner scanner = new Scanner(System.in);

	}



}
