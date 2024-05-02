package com.LMS.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	private final static String filePath="./src/test/resources/config/config.properties";

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(filePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
     //Browser
	public static String getBrowser() {
		String browserName = prop.getProperty("browser");
		if (browserName != null)
			return browserName;
		else
			throw new RuntimeException("Browser is  not specified in the Configuration.properties file.");
	}

	//Excel file Path
	public static String getExcelFilePath() {
		String excelfilelpath = prop.getProperty("excelFilePath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}

	// HomePage URL
		public static String getHomePageUrl() {
			String homePageurl = prop.getProperty("loginURL");
			if (homePageurl != null)
				return homePageurl;
			else
				throw new RuntimeException("HomePageurl not specified in the Config.properties file");
		}
	
		
}
