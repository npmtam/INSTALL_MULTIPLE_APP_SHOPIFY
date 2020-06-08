package com.shopify.fireapps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File fileOrDir = new File("C:\\Attachments\\img");
        Main myFiles = new Main();
        myFiles.traverseDepthFiles(fileOrDir);
    }

    public void traverseDepthFiles(final File fileOrDir) {
        // check xem fileOrDir la file hay foder
        if (fileOrDir.isDirectory()) {
            // in ten folder ra man hinh
            System.out.println(fileOrDir.getAbsolutePath());

            final File[] children = fileOrDir.listFiles();
            if (children == null) {
                return;
            }
            // sắp xếp file theo thứ tự tăng dần
            Arrays.sort(children, new Comparator<File>() {
                public int compare(final File o1, final File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for (final File each : children) {
                // gọi lại hàm traverseDepthFiles()
                traverseDepthFiles(each);
            }
        } else {
            // in ten file ra man hinh
            System.out.println(fileOrDir.getAbsolutePath());
        }
    }
}
