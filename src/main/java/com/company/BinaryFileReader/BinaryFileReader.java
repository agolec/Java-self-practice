package com.company.BinaryFileReader;

import java.io.*;
import java.nio.Buffer;

public class BinaryFileReader {
    private static String inputString;
    private static DataInputStream inputFile;

    private static void readBinaryFile(String fileName, boolean informUserFileDone) throws IOException {
        boolean endOfFile = false;
        DataInputStream inputFile;
        try {
            inputFile = new DataInputStream(new FileInputStream(fileName));
            while(!endOfFile){
                try {
                    if(inputFile != null){
                        inputString = inputFile.readUTF();
                        System.out.println(inputString);
                    } else{
                        System.out.println("No input. Breaking from loop.");
                        break;
                    }

                } catch (EOFException e){
                    endOfFile = true;
                } catch(IOException e){
                    System.out.println("Exception: IOException: \n" +
                            "Messsage:" + e.getMessage());
                }
            }
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        if(informUserFileDone){
            System.out.println("Done reading file");
        }

    }
    public static void readBinaryFile(String fileName) throws IOException {
        try {
            readBinaryFile(fileName, true);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
