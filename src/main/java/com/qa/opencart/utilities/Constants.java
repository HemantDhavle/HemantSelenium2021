package com.qa.opencart.utilities;

import java.util.ArrayList;
import java.util.List;

public class Constants 
{
	public static final String LOGIN_PAGE_TITLE = "Account Logins";
	public static final String ACCOUNT_PAGE_TITLE = "Your Store";
	public static final Object IMAC_IMAGE_COUNT = 3;
	public static final Object MACBOOKPRO_IMAGE_COUNT = 4;
	public static final CharSequence LOGIN_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password";
	public static final CharSequence REGISTRATION_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "registration";
	public static String LOGIN_PAGE_URL_FRACTION = "account/login";
	
	public static List<String> accountSectionHeaderList()
	{
		List<String> sectionHeaderList = new ArrayList<String>();
		sectionHeaderList.add("My Account");
		sectionHeaderList.add("My Orders");
		sectionHeaderList.add("My Affiliate Account");
		sectionHeaderList.add("Newsletter");
		return sectionHeaderList;
	}
	
}
