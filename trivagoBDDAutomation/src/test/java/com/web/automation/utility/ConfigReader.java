package com.web.automation.utility;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

	public static String readProjectConfiguration(String KeyName) {
		return readFile("ConfigFiles/ProjectConfiguration.properties", KeyName);
	}

	public static String readElementLocators(String KeyName) {
		return readFile("ElementLocators/Locators.properties", KeyName);
	}
	
	public static String readTestData(String KeyName) {
		return readFile("ConfigFiles/TestData.properties", KeyName);
	}

	private static String readFile(String filePath, String KeyName) {
		try {
			FileReader file = new FileReader(new File(filePath));
			Properties readproperty = new Properties();
			readproperty.load(file);
			return readproperty.getProperty(KeyName).trim();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw (new RuntimeException("*****ERROR******: -  Key with name " + KeyName + " does not exist"));
		}
	}

}
