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

            String envKey = switch (key) {
                case "base_uri" -> "BOOKER_BASE_URI";
                case "username" -> "BOOKER_USERNAME";
                case "password" -> "BOOKER_PASSWORD";
                default -> key.toUpperCase();
            };

            String envValue = System.getenv(envKey);

            if (envValue != null && !envValue.isBlank()) {
                return envValue;
            }


            return properties.getProperty(key);


        }
    }




