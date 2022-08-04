package com.doducvuong.util;

import java.util.Objects;

public class Util {

	/**
	 * method: check if String can parse to Integer
	 * @param strNum
	 * @return true if possible, false if impossible
	 */
	public static boolean isInt(String strNum) {
	    if (strNum == null) {
	    	System.out.println(Constant.ERROR_STRING_NULL);
	        return false;
	    }
	    try {
	        int intNum = Integer.parseInt(strNum);
	        System.out.println(Constant.NOTIFY_STRING_INTEGER + intNum);
	    } catch (NumberFormatException e) {
	    	e.getStackTrace();
	    	System.out.println(Constant.ERROR_STRING_NOT_INTEGER);
	        return false;
	    }
	    return true;
	}
	
	/**
	 * method: check if String is Integer and larger than 0
	 * @param strNum
	 * @return true if this integer value larger than 0, false if string is not an integer or <= 0
	 */
	public static boolean isIntegerNumberLargeThanZero (String strNum) {
		if (isInt(strNum) && Integer.parseInt(strNum) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * method: check if string is not null or empty
	 * @param str
	 * @return true if string is a text, false if string is null or empty
	 */
	public static boolean checkIfStringIsNotNullOrEmpty (String str) {
		if (!Objects.isNull(str) && !"".equals(str)) {
			return true;
		} else {
			return false;
		}
	}
	
}
