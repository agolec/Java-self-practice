package com.company.util;

public class DirectoryAndFilePath {
    final static String fileDirectory = "C:\\Users\\agolec\\Documents\\utf2023\\untitled\\src\\main\\java\\com\\company\\file\\";
    final static String fileName = "text.dat";

    public static String getFileDirectory(){
        return fileDirectory;
    }
    public static String getFileName(){
        return fileName;
    }
    public static String getDirectoryPathAndFile(){
        return fileDirectory + fileName;
    }
}
