/*
 *  Copyright (c) 2011 by Twilio, Inc., all rights reserved.
 *
 *  Use of this software is subject to the terms and conditions of 
 *  the Twilio Terms of Service located at http://www.twilio.com/legal/tos
 */

package com.twilio.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Constants {

	public static String tokenServerUrl = "";
	public static String[] countryNamesArray = { "UK +44", "India +91",
			"Australia +61", "South Africa +27", "Switzerland +41" };
	public static String selectCountryTitle = "Select the country";
	static HashMap<String, Integer> countryFileNameMap = new HashMap<String, Integer>();

	public static ArrayList<String> getCountryNameAL() {
		ArrayList<String> countryNamesAL = new ArrayList<String>(
				Arrays.asList(countryNamesArray));
		return countryNamesAL;

	}

	public static void setImageFileName() {

		countryFileNameMap.put("UK +44", R.drawable.gb);
		countryFileNameMap.put("India +91", R.drawable.in);
		countryFileNameMap.put("Australia +61", R.drawable.au);
		countryFileNameMap.put("South Africa +27", R.drawable.za);
		countryFileNameMap.put("Switzerland +41", R.drawable.ch);

	}

	public static int getImageFileName(String countryName) {
		setImageFileName();
		return countryFileNameMap.get(countryName);
	}
}
