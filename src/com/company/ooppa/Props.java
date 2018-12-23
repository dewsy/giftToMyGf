package com.company.ooppa;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Props {
    private static Props instance = null;

    private Props() {
        this.getProperties();
    }

    public static Props getInstance() {
        if (instance == null) {
            instance = new Props();
        }
        return instance;
    }

    Map<String, String> variables = new HashMap<>();

    private void getProperties(){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("resources/config.properties");

            // load a properties file
            prop.load(input);


            variables.put("lastVisited", prop.getProperty("lastVisited"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getDate() {
        return variables.get("lastVisited");
    }

    public void saveDateChange(String date) {
        try {
            Properties props = new Properties();
            props.setProperty("lastVisited", date);
            File f = new File("resources/config.properties");
            OutputStream out = new FileOutputStream( f );
            props.store(out, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }



}
