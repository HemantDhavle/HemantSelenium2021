package com.qa.opencart.utilities;

import java.util.ArrayList;
import java.util.List;

public class Constants 
{
	public static final String LOGIN_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_TITLE = "Your Store";
	public static final Object IMAC_IMAGE_COUNT = 3;
	public static final Object MACBOOKPRO_IMAGE_COUNT = 4;
	public static final CharSequence LOGIN_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password";
	public static final CharSequence REGISTRATION_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "registration";
	public static final String ADDRESS_SHEET_NAME = "address";
	public static String LOGIN_PAGE_URL_FRACTION = "account/login";
	public static final String ADDRESS_BOOK_TITLE = "Address Book Entries";
	public static final String WISH_LIST_PAGE_TITLE = "My Wish List";
	public static final String PRODUCT_NAME = "iMac";
	public static final String NEWS_LETTER_PAGE_TITLE = "Newsletter Subscription";
	public static final String REWARDS_PAGE_TITLE = "Your Reward Points";
	public static final String AFFILIATE_PAGE_TITLE = "Your Affiliate Information";
	
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
