package com.project.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constants {

	public static final String  propertyfile = "src\\Properties";
	public static Properties prop;
	public static String propertyvalue;
	
	public static String URL = getpropertyvalue("URL");
	public static String path = getpropertyvalue("path");
	public static String SheetName = getpropertyvalue("SheetName");
	
	public static String getpropertyvalue(String propertyname ){
		
		try {
			
			prop = loadproperty();
		
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		propertyvalue = prop.getProperty(propertyname);
		
		return propertyvalue;
	}
	public static Properties loadproperty() throws IOException{
		
		prop=new Properties();
		FileInputStream f1 = null;
		
		try {
			
			f1 = new FileInputStream(propertyfile);
		
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop.load(f1);
		return prop;
		
	}
	
}
