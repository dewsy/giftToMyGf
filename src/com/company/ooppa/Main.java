package com.company.ooppa;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static File getHTMLFile() {
        URL url = Main.class.getResource("index.html");
        return new File(url.getPath());
    }

    public static void main(String[] args) {
        Desktop desktop = java.awt.Desktop.getDesktop();
        File fileToOpen = getHTMLFile();
        if (Props.getInstance().getDate().equals(checkDate())) {
            System.out.println("Today already checked!");
        }
        Props.getInstance().saveDateChange(checkDate());
        try {
            desktop.open(fileToOpen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String checkDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}