package com.rajcic.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

        static {
            try {
                FileInputStream file = new FileInputStream("src/main/resources/config.properties");
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

        public static String get(String key){

            String envValue = System.getenv(key.toUpperCase());
            if(envValue !=null) return envValue;
            return properties.getProperty(key);
        }
    }




