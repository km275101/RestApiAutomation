package com.rest.automation.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.rest.automation.utility.Resources;

public class Initializer {

	
protected static Properties prop;
protected static Resources resources;
protected static CommonAction comAct ;

	@BeforeTest
	public void initialize() throws IOException {
		String s = System.getProperty("user.dir");
		String path = s+"\\src\\main\\resources\\configuration\\Config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		
		//resources = new Resources();
		comAct = new CommonAction();
		
		
	}
	
	

}
