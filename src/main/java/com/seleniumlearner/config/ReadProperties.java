package com.seleniumlearner.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private static Properties properties = new Properties();
    private static String localizationPropertiesFile = "src/main/config.properties";

    private static String readPropertyFile(String localization, String propertyName) {
        try {
            InputStream input = new FileInputStream(localization);
            properties.load(input);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
        return properties.getProperty(propertyName);
    }

    public static String getURL() {
        return readPropertyFile(localizationPropertiesFile, "URL");
    }

    public static String getUsername() {
        return readPropertyFile(localizationPropertiesFile, "username");
    }

    public static String getPassword() {
        return readPropertyFile(localizationPropertiesFile, "password");
    }

}
