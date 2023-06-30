package com.company.BinaryFileReader;

import com.company.BinaryFileWriter.BinaryFileWriter;
import com.company.util.DirectoryAndFilePath;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String doesntExist = "Idonotexist.dat";
        // write your code here
        //BinaryFileReader.readBinaryFile(DirectoryAndFilePath.getDirectoryPathAndFile());
        BinaryFileReader.readBinaryFile(doesntExist);
        System.out.println("Program end.");
    }
}
