package com.shopify.fireapps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String COMMA_DELIMITER = ",";
    private static final String root_Path = System.getProperty("user.dir");
    private static String file = root_Path + "/src/test/resources/readStoreData.csv";
    private static String stt, url, urlUncut, email, storeName, storeType;

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(file));

            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                while ((line = br.readLine()) != null) {
                    while ((line = br.readLine()) != null) {
                        printStoreData(parseCsvLine(line));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void printStoreData(List<String> store) {
        stt = store.get(0);
        urlUncut = store.get(1);
        email = store.get(2);
        storeName = store.get(3);
        storeType = store.get(4);
        String url2 = urlUncut.substring(8);
        url = url2.substring(0, url2.length() - 14);
        if (storeType.equals("Premium")) {
            System.out.println("STT: " + stt);
            System.out.println("URL: " + url);
            System.out.println("Email: " + email);
            System.out.println("Store Name: " + storeName);
            System.out.println("Store Type: " + storeType);
        }
    }
}
