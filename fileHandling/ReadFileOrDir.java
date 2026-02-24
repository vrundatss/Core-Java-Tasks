package com.tss.fileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileOrDir {

    public static void main(String[] args) {
//        File file = new File("C:\\Users\\vrunda.chavada\\Training Projects\\Java projects\\OOP-App-TSS\\src\\com\\tss\\fileHandling\\folder\\Hello.txt");

                File file = new File("C:\\Users\\vrunda.chavada\\Training Projects\\Java projects\\OOP-App-TSS\\src\\com\\tss\\fileHandling\\folder");

        if (file.exists()){
            if(file.isFile()){
                try (FileReader fileReader = new FileReader(file)) {
                    int ch;
                    while ((ch = fileReader.read()) != -1) {
                        System.out.print((char) ch);
                    }
                }catch (IOException exception){
                    System.out.println(exception.fillInStackTrace());
                }
            }else {
                System.out.println("===> Main directory details : ");
                directoryDetails(file);
            }
        }else {
            System.out.println("File is not exist...");
        }

    }

    private static void directoryDetails(File file) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());

            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println("   ---> File: " + f.getName());
                    } else if (f.isDirectory()) {
                        System.out.println("===> Sub directory details : ");
                        directoryDetails(f);
                    }
                }
            }
        } else if (file.isFile()) {
            System.out.println("File: " + file.getName());
        }
    }

}
