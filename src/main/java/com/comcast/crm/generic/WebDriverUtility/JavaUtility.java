package com.comcast.crm.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;

import com.github.javafaker.Faker;

public class JavaUtility 
{
	public int getRandomNumber()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(5000); //any number based on test cases
		return ranNum;
	}
	public String getFakeFullName()
	{
		Faker fake = new Faker();
		String fullName = fake.name().fullName();
		return fullName;
	}
	
	public String getFakeName()
	{
		Faker fake = new Faker();
		String name = fake.name().name();
		return name;
	}
	
	public String getSystemDateAsYYYYMMDD()
	{
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd"); // Month should be in upper case
		String SysDate=sim.format(dateObj);		
		return SysDate;
	}
	
	public String getRequiredDateAsYYYYMMDD(int days)
	{
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String StartDate=sim.format(dateObj);		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days); 
		String EndDate = sim.format(cal.getTime());
		return EndDate;		
	}
	
	public String getTimeStampDetails()
	{
		String time = new Date().toString();
		return time;
	}
	
	public String getTimeStampDetailsforScreenshot()
	{
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		return time;
	}
	
	
}
