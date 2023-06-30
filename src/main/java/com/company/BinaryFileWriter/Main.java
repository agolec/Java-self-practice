package com.company.BinaryFileWriter;

import com.company.util.DirectoryAndFilePath;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        BinaryFileWriter.writeToFile(DirectoryAndFilePath.getDirectoryPathAndFile(),"Testing",false);
        System.out.println("Program end.");
    }
}
