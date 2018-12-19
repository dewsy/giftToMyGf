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
        if (Props.getInstance().getDate().equals(currentdate)) {
            System.out.println("Today already checked!");
        }
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
        template = template.replace("$bodyContent", "Szeretlek");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("index.html"));
            writer.write(template);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}