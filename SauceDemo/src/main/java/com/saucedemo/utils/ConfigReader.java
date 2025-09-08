package com.saucedemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader 
{
	
    private static Properties prop;

  
    
    public static Properties initProperties()
    {
        if (prop == null) {
            prop = new Properties();
            try (InputStream input = ConfigReader.class.getClassLoader()
                    .getResourceAsStream("config.properties")) 
            {
                if (input == null) {
                    throw new RuntimeException("config.properties not found in resources folder");
                }
                prop.load(input);

            } catch (IOException e) 
            {
                throw new RuntimeException("Failed to load config.properties", e);
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        if (prop == null) {
            initProperties();
        }
      
        
        return System.getProperty(key, prop.getProperty(key));
    }

}
