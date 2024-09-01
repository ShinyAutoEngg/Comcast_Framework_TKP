package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fisp = new FileInputStream("./configAppData/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fisp);
		String data=prop.getProperty(key);
		return data;
	}
}
