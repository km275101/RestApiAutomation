package com.rest.automation.action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.rest.automation.utility.Resources;

public class CommonAction extends Resources{
   
   public String generateString(String FileName) throws IOException {
		String s = System.getProperty("user.dir");
		String filePath = s+"\\src\\main\\resources\\payload\\"+FileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
		
	}
   
   

}
