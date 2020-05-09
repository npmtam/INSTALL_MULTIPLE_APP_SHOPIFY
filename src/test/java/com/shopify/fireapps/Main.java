package com.shopify.fireapps;

public class Main {
    public static void main (String[] args){
        String URL = "https://fireapp-store-1.myshopify.com/admin";
        String sau_tach = URL.substring(0, URL.length() - 6);
        System.out.println(sau_tach);
    }
}
