package com.assignment;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFromFileAssignment 
{
	public static void main(String[] args) throws Exception 
	{
		Properties prop = new Properties();
		FileInputStream inputFile = new FileInputStream("C:\\Users\\Admin\\git\\TestingAssignments\\Regular_Assignments\\dataFile.properties");
		prop.load(inputFile);
		System.out.println(prop.getProperty("URL"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("browser_name"));
	}
}
		
	
	



		
	
		
		

	
	

	