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
        String message;
        if (Props.getInstance().getDate().equals(currentdate)) {
            return "Ma már jártál erre, nem csalunk! De azért puszi!";
        } else {
            message = Messages.getRandom();
        }
        switch (currentdate.substring(5)) {
            case "08/18":
                return "Áldott évfordulót nekünk!";
            case "05/01":
                return "Isten éltessen szülinapod alkalmából!";
            case "01/19":
                return "Boldog névnapot!";
            case "03/08":
                return "Boldog nőnapot!";
            case "02/14":
                return "Boldog Valentin napot!";
            case "12/25":
                return "Áldott karácsonyt!";
            case "01/01":
                return "B.U.É.K!";
        }
        return message;
    }
}