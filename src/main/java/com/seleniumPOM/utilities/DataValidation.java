package com.seleniumPOM.utilities;

import org.testng.annotations.Test;

public class DataValidation {
	
	public static boolean isEmptyString(CharSequence cs){
		return cs == null || cs.length() == 0;
	}
	
	public static boolean isDigit(CharSequence cs)
	{
		if(isEmptyString(cs)){
			return false;
		}
		
		int len = cs.length();
		for (int i = 0; i < len; i++){
			if( !Character.isDigit(cs.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public String intToString(int num){
		return (String.format("%s", num));
	}
	
	public char[] stringToChar(String str){
		char charArray[] =str.toCharArray();
		return charArray;
	}
	
	@Test
	public void test(){
		System.out.println(isDigit("2"));
		String num = intToString(123456);
		System.out.println(num.charAt(5));
		
		System.out.println(stringToChar("john"));
	}

}
