package com.LMS.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getExcelFilePath() {
		String excelfilelpath = prop.getProperty("excelFilePath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}

	// HomePage URL
	public static String getHomePageUrl() {
		String homePageurl = prop.getProperty("baseurl");
		if (homePageurl != null)
			return homePageurl;
		else
			throw new RuntimeException("HomePageurl not specified in the Config.properties file");
	}

	
		
}
