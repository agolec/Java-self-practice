package com.company.BinaryFileWriter;

import java.io.*;

//This class must be able to write to a binary text file
public class BinaryFileWriter {
    private static DataOutputStream dataOutputStream;
    private static String fileName;
//    public BinaryFileWriter(String fileName) throws IOException {
//        this.fileName = fileName;
//
//    }
    public static void writeToFile(String fileDirectory,String inputString,boolean append){
        fileName = fileDirectory;
        try {
            if(append){
                dataOutputStream = new DataOutputStream(new FileOutputStream(fileName,true));
            }else{
                dataOutputStream = new DataOutputStream(new FileOutputStream(fileName,false));
            }
            dataOutputStream.writeUTF(inputString);
            dataOutputStream.close();
            System.out.println("done.");

        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not Found\n" +
                    "Message: " + e.getMessage());
        }
        catch (IOException e) {
            e.getMessage();
        }

    }

}
