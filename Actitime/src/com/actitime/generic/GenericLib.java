package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Vivek sharma
 *created on 12/05/2018 at 11:41am
 */
public class GenericLib {
   
	static String filepath="./testdata/config.properties";
	//C:\Users\Davinder Singh\eclipse-workspace\Actitime\testdata\config.properties
	/**
	 * description read value from properties file based on key
	 * @param Key
	 * @return String
	 */
	public static String getValue(String Key) 
			
	{
		String value=null;
		
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream(new File(filepath)));
			value=prop.getProperty(Key);
			
		}
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
}