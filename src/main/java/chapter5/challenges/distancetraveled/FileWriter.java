package chapter5.challenges.distancetraveled;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
    private String fileName = "";
    private File fw;
    private PrintWriter pw;
    FileWriter(String fileName) throws FileNotFoundException {
        fw = new File(fileName);
        pw = new PrintWriter(fw);

    }
    public FileWriter(FileWriter source)  {
        this.fileName = source.fileName;
        this.fw = source.fw;
        this.pw = source.pw;
    }
    public PrintWriter getPrintWriter() throws FileNotFoundException {
        return new PrintWriter(fw);
    }
    boolean doesFileExist(){
        return fw.exists();
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void writeLine(String line){
        pw.println(line);
    }
    public void closeFile(){
        pw.close();
    }

}
