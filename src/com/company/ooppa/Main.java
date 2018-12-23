package com.company.ooppa;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static String currentDate;

    public static void main(String[] args) {
        Desktop desktop = java.awt.Desktop.getDesktop();
        currentDate = checkDate();
        createFileFromTemplate(getTemplateAsString());
        Props.getInstance().saveDateChange(checkDate());
        try {
            desktop.open(new File("resources/index.html"));
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
        String templateString = "";
        try {
            File template = new File("resources/template.html");
            byte[] encoded = Files.readAllBytes(Paths.get(template.toURI()));
            templateString = new String(encoded);
        }catch (Exception e){
            e.printStackTrace();
        }
        return templateString;
    }

    private static void createFileFromTemplate(String template) {
        String message = generateMessage();
        template = template.replace("$bodyContent", message);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/index.html"));
            writer.write(template);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateMessage() {
        String message;
        if (Props.getInstance().getDate().equals(currentDate)) {
            return "Ma már jártál erre, nem csalunk! De azért puszi!";
        } else {
            message = Messages.getRandom();
        }
        switch (currentDate.substring(5)) {
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