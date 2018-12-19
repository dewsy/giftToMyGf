package com.company.ooppa;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static String currentdate;

    public static void main(String[] args) {
        Desktop desktop = java.awt.Desktop.getDesktop();
        currentdate = checkDate();
        createFileFromTemplate(getTemplateAsString());
        Props.getInstance().saveDateChange(checkDate());
        try {
            desktop.open(new File("index.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String checkDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static String getTemplateAsString() {
        URL url = Main.class.getResource("template.html");
        String htmlString = "";
        try {
            htmlString = new String (Files.readAllBytes(Paths.get(url.getPath())) );
    } catch (Exception e) {
        e.printStackTrace();
        }
        return htmlString;
    }

    private static void createFileFromTemplate(String template) {
        String message = generateMessage();
        template = template.replace("$bodyContent", message);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("index.html"));
            writer.write(template);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateMessage() {
        String message = "";
        if (Props.getInstance().getDate().equals(currentdate)) {
            message = "It's already checked today!";
            return message;
        } else {
            message = Messages.getRandom();
        }
        switch (currentdate.substring(5)) {
            case "08/18":
                message = "Happy anniversary!";
                return message;
            case "05/01":
                message = "Happy birthday kincsem!";
                return message;
            case "01/19":
                message = "Happy namesday!";
                return message;
            case "03/08":
                message = "Happy international women's day!";
                return message;
            case "02/14":
                message = "Happy Valentine's day!";
                return message;
        }
        return message;
    }
}