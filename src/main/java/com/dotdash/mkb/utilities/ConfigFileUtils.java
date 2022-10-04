package com.dotdash.mkb.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileUtils {

    private static Properties browserProperties;
    private static Properties userCredentialsProperties;

    private static String browserPropsFilePath= "src\\main\\resources\\general.config";
    private static String userCreditsPropsFilePath= "src\\main\\resources\\userCredentials.config";

    public static void readAllProperties(){
        browserProperties = readPropertyFile(browserPropsFilePath);
        userCredentialsProperties = readPropertyFile(userCreditsPropsFilePath);
    }

    private static Properties readPropertyFile(String filePath) {
        BufferedReader reader;
        Properties properties;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("general.config not found at " + filePath);
        }
        return properties;
    }

    public static String getBrowserProperty(String property){
        return browserProperties.getProperty(property);
    }

    public static String getUserCredentialsProperty(String property){
        return userCredentialsProperties.getProperty(property);
    }


}