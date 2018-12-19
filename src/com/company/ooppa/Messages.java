package com.company.ooppa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Messages {

    private static List<String> messages = new ArrayList<>(
            Arrays.asList("Szeretlek!", "Nagyon szeretlek!")
    );



    public static String getRandom() {
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }
}
